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
package org.sweble.wom3.impl;

/**
 * Base class for classes which implement XHTML elements with universal
 * attributes. The only thing left to an implementing class is to implement the
 * getNodeName() method.
 */
public abstract class BackboneWomElemWithUnivAttrs
		extends
			BackboneWomElemWithCoreAttrs
{
	private static final long serialVersionUID = 1L;

	// =========================================================================

	public BackboneWomElemWithUnivAttrs(DocumentImpl owner)
	{
		super(owner);
	}

	// =========================================================================

	@Override
	protected AttributeDescriptor getAttributeDescriptor(
			String namespaceUri,
			String localName,
			String qualifiedName)
	{
		return getAttrDesc(namespaceUri, localName, qualifiedName, UniversalAttributes.getNameMap());
	}
}
