/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sweble.wikitext.parser.parser;

import org.sweble.wikitext.parser.WtEntityMap;
import org.sweble.wikitext.parser.nodes.Ignored;
import org.sweble.wikitext.parser.nodes.OnlyInclude;
import org.sweble.wikitext.parser.nodes.PreproWikitextPage;
import org.sweble.wikitext.parser.nodes.WikitextNode;
import org.sweble.wikitext.parser.nodes.WtList;
import org.sweble.wikitext.parser.nodes.WtText;
import org.sweble.wikitext.parser.nodes.XmlComment;
import org.sweble.wikitext.parser.preprocessor.PreprocessedWikitext;
import org.sweble.wikitext.parser.preprocessor.ProtectedText;

import de.fau.cs.osr.ptk.common.AstVisitor;

public class PreprocessorToParserTransformer
{
	public static PreprocessedWikitext transform(
			PreproWikitextPage preprocessedArticle,
			WtEntityMap entityMap)
	{
		return new PreprocessedWikitext(
				(String) new TransformVisitor(entityMap, false).go(preprocessedArticle),
				entityMap);
	}
	
	public static PreprocessedWikitext transform(
			PreproWikitextPage preprocessedArticle)
	{
		WtEntityMap entityMap = preprocessedArticle.getEntityMap();
		return new PreprocessedWikitext(
				(String) new TransformVisitor(entityMap, false).go(preprocessedArticle),
				entityMap);
	}
	
	public static PreprocessedWikitext transform(
			PreproWikitextPage preprocessedArticle,
			WtEntityMap entityMap,
			boolean trim)
	{
		return new PreprocessedWikitext(
				(String) new TransformVisitor(entityMap, trim).go(preprocessedArticle),
				entityMap);
	}
	
	public static PreprocessedWikitext transform(
			PreproWikitextPage preprocessedArticle,
			boolean trim)
	{
		WtEntityMap entityMap = preprocessedArticle.getEntityMap();
		return new PreprocessedWikitext(
				(String) new TransformVisitor(entityMap, trim).go(preprocessedArticle),
				entityMap);
	}
	
	// =========================================================================
	
	protected static final class TransformVisitor
			extends
				AstVisitor<WikitextNode>
	{
		private StringBuilder builder;
		
		private WtEntityMap entityMap;
		
		private final boolean trim;
		
		public TransformVisitor(WtEntityMap entityMap, boolean trim)
		{
			this.entityMap = entityMap;
			this.trim = trim;
		}
		
		// =====================================================================
		
		@Override
		protected boolean before(WikitextNode node)
		{
			builder = new StringBuilder();
			return super.before(node);
		}
		
		@Override
		protected String after(WikitextNode node, Object result)
		{
			return builder.toString();
		}
		
		// =====================================================================
		
		public void visit(PreproWikitextPage n)
		{
			iterate(n);
		}
		
		public void visit(WikitextNode n)
		{
			makeParserEntity(n);
		}
		
		public void visit(ProtectedText n)
		{
			makeParserEntity(n);
		}
		
		private void makeParserEntity(WikitextNode n)
		{
			int id = entityMap.registerEntity(n);
			builder.append('\uE000');
			builder.append(id);
			builder.append('\uE001');
		}
		
		public void visit(WtList n)
		{
			iterate(n);
		}
		
		public void visit(OnlyInclude n)
		{
			iterate(n);
		}
		
		public void visit(WtText n)
		{
			builder.append(n.getContent());
		}
		
		public void visit(Ignored n)
		{
			// Always trimmed
		}
		
		public void visit(XmlComment n)
		{
			if (!trim)
			{
				visit((WikitextNode) n);
			}
		}
	}
}