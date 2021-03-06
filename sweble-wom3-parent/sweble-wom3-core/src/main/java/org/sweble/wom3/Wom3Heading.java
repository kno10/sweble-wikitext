/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package org.sweble.wom3;

/**
 * Denotes the heading of a section.
 * 
 * The level of the heading is stored in the section node which is always the
 * parent node of a heading. This interface is only concerned with the content
 * of the heading and the content's formatting.
 * 
 * Corresponds to the WXML 1.0 element "heading". Also partly corresponds to the
 * XHTML 1.0 Transitional elements "h1" - "h6".
 * 
 * <b>Child elements:</b> Mixed, [Inline elements]*
 */
public interface Wom3Heading
		extends
			Wom3ElementNode,
			Wom3UniversalAttributes
{
	/**
	 * Get the alignment of the content inside the tag.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "align".
	 * 
	 * @return The alignment or <code>null</code> if the attribute is not
	 *         specified.
	 */
	public Wom3HorizAlign getAlign();

	/**
	 * Set the alignment of the content inside the tag.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "align".
	 * 
	 * @param align
	 *            The new alignment or <code>null</code> to remove the
	 *            attribute. Only the values LEFT, RIGHT, CENTER and JUSTIFY are
	 *            allowed.
	 * @return The old alignment.
	 * @throws IllegalArgumentException
	 *             Thrown if an illegal value is specified as alignment.
	 */
	public Wom3HorizAlign setAlign(Wom3HorizAlign align) throws IllegalArgumentException;
}
