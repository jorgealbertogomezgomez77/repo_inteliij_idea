package de.ioexception.booleanterm;

/**
 * Interface for nodes
 * 
 * @author Benjamin Erb
 * 
 */
public interface Node
{
	/**
	 * Evaluates a node value
	 * 
	 * @return result (true|false)
	 */
	public boolean evaluate();
}
