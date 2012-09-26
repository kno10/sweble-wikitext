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

package org.sweble.wikitext.engine.ext.parser_functions;

import static org.sweble.wikitext.parser.utils.AstBuilder.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.sweble.wikitext.engine.ExpansionFrame;
import org.sweble.wikitext.engine.SoftErrorNode;
import org.sweble.wikitext.engine.utils.EngineTextUtils;
import org.sweble.wikitext.parser.nodes.Template;
import org.sweble.wikitext.parser.utils.StringConversionException;
import org.sweble.wikitext.parser.utils.StringConverter;

import de.fau.cs.osr.ptk.common.ast.AstNode;
import de.fau.cs.osr.utils.StringUtils;

public class ParserFunctionTime
		extends
			ParserFunctionsExtPfn
{
	private static final long serialVersionUID = 1L;
	
	public ParserFunctionTime()
	{
		super("time");
	}
	
	@Override
	public AstNode invoke(
			Template pfn,
			ExpansionFrame frame,
			List<? extends AstNode> args)
	{
		if (args.size() < 1)
			return pfn;
		
		// ---- format
		
		String format = expandArgToString(frame, args, 0);
		if (format == null)
			return error(_("Cannot convert format argument to string!"));
		
		// ---- timestamp
		
		String timestampStr = null;
		if (args.size() >= 2)
		{
			timestampStr = expandArgToString(frame, args, 1);
			if (timestampStr == null)
				return error(_("Cannot convert timestamp argument to string!"));
		}
		
		if (timestampStr != null && !timestampStr.isEmpty())
			return notYetImplemented(_("Cannot handle non-empty timestamp argument!"));
		
		// ---- language
		
		String languageTag = null;
		if (args.size() >= 3)
		{
			languageTag = expandArgToString(frame, args, 2);
			if (languageTag == null)
				return error(_("Cannot convert language argument to string!"));
		}
		
		if (languageTag != null && !languageTag.isEmpty())
			return notYetImplemented(_("Cannot handle non-empty language argument!"));
		
		languageTag = "en";
		
		// ---- let's format ourselves a date...
		
		Locale locale = new Locale(languageTag);
		
		Calendar timestamp = new GregorianCalendar(locale);
		timestamp.setLenient(true);
		
		return format(format, timestamp, locale);
	}
	
	private AstNode format(String format, Calendar timestamp, Locale locale)
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < format.length(); ++i)
		{
			char ch = format.charAt(i);
			switch (ch)
			{
				case 'j':
					sb.append(timestamp.get(GregorianCalendar.DAY_OF_MONTH));
					break;
				
				case 'Y':
					sb.append(timestamp.get(GregorianCalendar.YEAR));
					break;
				
				case 'F':
					sb.append(timestamp.getDisplayName(
							GregorianCalendar.MONTH,
							GregorianCalendar.LONG,
							locale));
					break;
				
				default:
					sb.append(ch);
					break;
			}
		}
		
		return astText(sb.toString());
	}
	
	private String _(String string, Object... args)
	{
		return string;
	}
	
	private String expandArgToString(
			ExpansionFrame preprocessorFrame,
			List<? extends AstNode> args,
			final int index)
	{
		AstNode arg = preprocessorFrame.expand(args.get(index));
		
		EngineTextUtils.trim(arg);
		
		String format = null;
		try
		{
			format = StringConverter.convert(arg).trim();
		}
		catch (StringConversionException e1)
		{
		}
		return format;
	}
	
	private SoftErrorNode error(String msg)
	{
		return new SoftErrorNode(astProtectedText(StringUtils.escHtml(msg)));
	}
	
	private SoftErrorNode notYetImplemented(String msg)
	{
		SoftErrorNode error = new SoftErrorNode(astProtectedText(StringUtils.escHtml(msg)));
		error.addCssClass("not-yet-implemented");
		return error;
	}
}
