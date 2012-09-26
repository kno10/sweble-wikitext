/* 
 * This file is auto-generated.
 * DO NOT MODIFY MANUALLY!
 * 
 * Generated by AstNodeGenerator.
 * Last generated: 2012-09-26 11:07:49.
 */

package org.sweble.wikitext.parser.nodes;

import de.fau.cs.osr.ptk.common.ast.NodeList;

/**
 * <h1>Link Title</h1> <h2>Grammar</h2>
 * <ul>
 * <li>
 * <p>
 * LinkTitle ::= LinkTitleContent{TITLE}*
 * </p>
 * </li>
 * </ul>
 * <h2>LinkTitleContent can contain</h2>
 * <ul>
 * <li>
 * <p>
 * Newline
 * </p>
 * <ul>
 * <li>
 * <p>
 * Tables
 * </p>
 * </li>
 * <li>
 * <p>
 * Headings
 * </p>
 * </li>
 * <li>
 * <p>
 * Horizontal rules
 * </p>
 * </li>
 * <li>
 * <p>
 * Block level elements
 * </p>
 * </li>
 * </ul>
 * </li>
 * <li>
 * <p>
 * Signature
 * </p>
 * </li>
 * <li>
 * <p>
 * InternalLink
 * </p>
 * </li>
 * <li>
 * <p>
 * ExternalLink
 * </p>
 * </li>
 * <li>
 * <p>
 * PlainExternalLink
 * </p>
 * </li>
 * <li>
 * <p>
 * Ticks
 * </p>
 * </li>
 * <li>
 * <p>
 * XmlReference
 * </p>
 * </li>
 * <li>
 * <p>
 * XmlElement
 * </p>
 * </li>
 * <li>
 * <p>
 * ParserEntity
 * </p>
 * </li>
 * </ul>
 * <h2>The LinkTitleContent cannot contain</h2>
 * <ul>
 * <li>
 * <p>
 * PageSwitch
 * </p>
 * </li>
 * </ul>
 */
public class LinkTitle
		extends
			WtContentNode

{
	private static final long serialVersionUID = 1L;
	
	// =========================================================================
	
	public LinkTitle()
	{
		super();
		
	}
	
	public LinkTitle(NodeList content)
	{
		super(content);
		
	}
	
	@Override
	public int getNodeType()
	{
		return org.sweble.wikitext.parser.AstNodeTypes.NT_LINK_TITLE;
	}
	
	// =========================================================================
	// Properties
	
	// =========================================================================
	// Children
	
	// =========================================================================
	
}
