package de.ioexception.booleanterm;

/**
 * Interface for operators
 * 
 * @author Benjamin Erb
 * 
 */
public interface Operator
{
	/**
	 * Evaluates a (partial) term
	 * 
	 * @param args
	 *            Parameters
	 * @return Result
	 */
	public boolean eval(boolean... args);

	/**
	 * Returns the number of expected operands.
	 * 
	 * @return operand count
	 */
	public int getOperands();

	/**
	 * Returns the internal symbol for this operator.
	 * 
	 * @return Operator symbol
	 */
	public char getSymbol();
}
