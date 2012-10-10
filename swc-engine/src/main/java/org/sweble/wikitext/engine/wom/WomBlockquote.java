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
package org.sweble.wikitext.engine.wom;

/**
 * Denotes a long quotation.
 * 
 * Corresponds to the XHTML 1.0 Transitional element "blockquote".
 * 
 * <b>Child elements:</b> [Block elements]*
 */
public interface WomBlockquote
		extends
			WomBlockElement,
			WomUniversalAttributes
{
	/**
	 * Get source of the quotation.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "cite".
	 * 
	 * @return The source of the citation or <code>null</code> if the attribute
	 *         is not specified.
	 */
	public String getCite();
	
	/**
	 * Set the source of the quotation.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "cite".
	 * 
	 * @param source
	 *            The source of the citation or <code>null</code> to remove the
	 *            attribute.
	 * @return The source of the citation.
	 */
	public String setCite(String source);
}
