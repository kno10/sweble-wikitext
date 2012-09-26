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

package org.example;

import java.io.IOException;

import org.sweble.wikitext.engine.config.ParserConfigImpl;
import org.sweble.wikitext.engine.config.WikiConfigImpl;
import org.sweble.wikitext.engine.utils.DefaultConfigEn;
import org.sweble.wikitext.parser.WikitextEncodingValidator;
import org.sweble.wikitext.parser.WikitextParser;
import org.sweble.wikitext.parser.WikitextPostprocessor;
import org.sweble.wikitext.parser.WikitextPreprocessor;
import org.sweble.wikitext.parser.encval.ValidatedWikitext;
import org.sweble.wikitext.parser.nodes.ParsedWikitextPage;
import org.sweble.wikitext.parser.nodes.PreproWikitextPage;
import org.sweble.wikitext.parser.parser.PreprocessorToParserTransformer;
import org.sweble.wikitext.parser.preprocessor.PreprocessedWikitext;

import xtc.parser.ParseException;
import de.fau.cs.osr.ptk.common.ParserCommon;
import de.fau.cs.osr.ptk.common.ast.AstNode;

public final class FullParser
		extends
			ParserCommon
{
	private ParserConfigImpl parserConfig;
	
	public FullParser()
	{
		WikiConfigImpl config = DefaultConfigEn.generate();
		parserConfig = config.getParserConfig();
	}
	
	public FullParser(
			boolean warningsEnabled,
			boolean gatherRtData,
			boolean autoCorrect)
	
	{
		WikiConfigImpl config = DefaultConfigEn.generate();
		parserConfig = config.getParserConfig();
		parserConfig.setWarningsEnabled(warningsEnabled);
		parserConfig.setGatherRtData(gatherRtData);
		parserConfig.setAutoCorrect(autoCorrect);
	}
	
	@Override
	public AstNode parseArticle(String source, String title) throws IOException, ParseException
	{
		// Encoding validation
		
		WikitextEncodingValidator v = new WikitextEncodingValidator();
		
		ValidatedWikitext validated = v.validate(source, title);
		
		// Pre-processing
		
		WikitextPreprocessor prep = new WikitextPreprocessor(parserConfig);
		
		PreproWikitextPage prepArticle =
				(PreproWikitextPage) prep.parseArticle(validated, title, false);
		
		// Parsing
		
		PreprocessedWikitext ppw = PreprocessorToParserTransformer
				.transform(prepArticle);
		
		WikitextParser p = new WikitextParser(parserConfig);
		
		ParsedWikitextPage parsedArticle =
				(ParsedWikitextPage) p.parseArticle(ppw, title);
		
		// Post-processing
		
		WikitextPostprocessor postp = new WikitextPostprocessor(parserConfig);
		
		ParsedWikitextPage postpArticle =
				(ParsedWikitextPage) postp.postprocess(parsedArticle, title);
		
		// User-defined processing
		
		ParsedWikitextPage userProcessed = (ParsedWikitextPage) process(postpArticle);
		
		return userProcessed;
	}
}
