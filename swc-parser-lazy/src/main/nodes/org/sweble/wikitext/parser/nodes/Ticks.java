/* 
 * This file is auto-generated.
 * DO NOT MODIFY MANUALLY!
 * 
 * Generated by AstNodeGenerator.
 * Last generated: 2012-09-26 11:07:49.
 */

package org.sweble.wikitext.parser.nodes;

import de.fau.cs.osr.ptk.common.ast.AstNodePropertyIterator;

/**
 * <h1>Ticks</h1> <h2>Grammar</h2>
 * <ul>
 * <li>
 * <p>
 * "''" "'"*
 * </p>
 * </li>
 * </ul>
 */
public class Ticks
		extends
			WtLeafNode

{
	private static final long serialVersionUID = 1L;
	
	// =========================================================================
	
	public Ticks()
	{
		super();
		
	}
	
	public Ticks(int tickCount)
	{
		super();
		setTickCount(tickCount);
		
	}
	
	@Override
	public int getNodeType()
	{
		return org.sweble.wikitext.parser.AstNodeTypes.NT_TICKS;
	}
	
	// =========================================================================
	// Properties
	
	private int tickCount;
	
	public final int getTickCount()
	{
		return this.tickCount;
	}
	
	public final int setTickCount(int tickCount)
	{
		int old = this.tickCount;
		this.tickCount = tickCount;
		return old;
	}
	
	@Override
	public final int getPropertyCount()
	{
		return 1;
	}
	
	@Override
	public final AstNodePropertyIterator propertyIterator()
	{
		return new AstNodePropertyIterator()
		{
			@Override
			protected int getPropertyCount()
			{
				return 1;
			}
			
			@Override
			protected String getName(int index)
			{
				switch (index)
				{
					case 0:
						return "tickCount";
						
					default:
						throw new IndexOutOfBoundsException();
				}
			}
			
			@Override
			protected Object getValue(int index)
			{
				switch (index)
				{
					case 0:
						return Ticks.this.getTickCount();
						
					default:
						throw new IndexOutOfBoundsException();
				}
			}
			
			@Override
			protected Object setValue(int index, Object value)
			{
				switch (index)
				{
					case 0:
						return Ticks.this.setTickCount((Integer) value);
						
					default:
						throw new IndexOutOfBoundsException();
				}
			}
		};
	}
	
	// =========================================================================
	// Children
	
	// =========================================================================
	
}
