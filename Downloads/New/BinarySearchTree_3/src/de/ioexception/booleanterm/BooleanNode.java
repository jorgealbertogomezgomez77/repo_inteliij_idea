package de.ioexception.booleanterm;

/**
 * Class for (Leaf-)Nodes containing boolean values.
 * 
 * @author Benjamin Erb
 * 
 */
public class BooleanNode implements Node
{
	private final boolean value;

	public BooleanNode(boolean value)
	{
		this.value = value;
	}

	@Override
	public boolean evaluate()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return (value ? "1" : "0");
	}
}
