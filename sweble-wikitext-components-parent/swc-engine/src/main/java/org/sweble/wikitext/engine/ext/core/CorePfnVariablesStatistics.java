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

package org.sweble.wikitext.engine.ext.core;

import org.sweble.wikitext.engine.config.ParserFunctionGroup;
import org.sweble.wikitext.engine.config.WikiConfig;

public class CorePfnVariablesStatistics
		extends
			ParserFunctionGroup
{
	private static final long serialVersionUID = 1L;

	// =========================================================================

	protected CorePfnVariablesStatistics(WikiConfig wikiConfig)
	{
		super("Core - Variables - Statistics");
	}

	public static CorePfnVariablesStatistics group(WikiConfig wikiConfig)
	{
		return new CorePfnVariablesStatistics(wikiConfig);
	}

	// =========================================================================
	// ==
	// == Entire wiki
	// == --------------------
	// == TODO: {{NUMBEROFPAGES}}
	// == TODO: {{NUMBEROFARTICLES}}
	// == TODO: {{NUMBEROFFILES}}
	// == TODO: {{NUMBEROFEDITS}}
	// == TODO: {{NUMBEROFVIEWS}}
	// == TODO: {{NUMBEROFUSERS}}
	// == TODO: {{NUMBEROFADMINS}}
	// == TODO: {{NUMBEROFACTIVEUSERS}}
	// == TODO: {{PAGESINCATEGORY:categoryname}}, {{PAGESINCAT:Help}}
	// == TODO: {{NUMBERINGROUP:groupname}}, {{NUMINGROUP:groupname}}
	// == TODO: {{PAGESINNS:index}}, {{PAGESINNAMESPACE:index}}
	// ==
	// =========================================================================
}
