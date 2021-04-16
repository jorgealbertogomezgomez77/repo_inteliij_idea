package de.ioexception.booleanterm;

/**
 * Enum for unary operators.
 * 
 * @author Benjamin Erb
 * 
 */
public enum UnaryOperator implements Operator
{
	NOT("NOT", '!')
	{
		@Override
		public boolean eval(boolean... args)
		{
			if(args.length != 1)
			{
				throw new IllegalArgumentException();
			}
			return !args[0];
		}
	};

	private String text;
	private char symbol;

	private UnaryOperator(String text, char symbol)
	{
		this.symbol = symbol;
		this.text = text;
	}

	@Override
	public int getOperands()
	{
		return 1;
	}

	@Override
	public String toString()
	{
		return text;
	}

	@Override
	public char getSymbol()
	{
		return symbol;
	}
}
