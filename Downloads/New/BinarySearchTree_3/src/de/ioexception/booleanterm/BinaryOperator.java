package de.ioexception.booleanterm;

/**
 * Enum for binary operators.
 * 
 * @author Benjamin Erb
 * 
 */
public enum BinaryOperator implements Operator
{
	AND("AND", '&')
	{

		@Override
		public boolean eval(boolean... args)
		{
			if(args.length != 2)
			{
				throw new IllegalArgumentException();
			}
			return (args[0] & args[1]);
		}

	},
	OR("OR", '|')
	{

		@Override
		public boolean eval(boolean... args)
		{
			if(args.length != 2)
			{
				throw new IllegalArgumentException();
			}
			return (args[0] | args[1]);
		}

	},
	XOR("XOR", '^')
	{

		@Override
		public boolean eval(boolean... args)
		{
			if(args.length != 2)
			{
				throw new IllegalArgumentException();
			}
			return (args[0] ^ args[1]);
		}

	};

	private String text;
	private char symbol;

	private BinaryOperator(String text, char symbol)
	{
		this.symbol = symbol;
		this.text = text;
	}

	@Override
	public String toString()
	{
		return text;
	}

	@Override
	public int getOperands()
	{
		return 2;
	}

	@Override
	public char getSymbol()
	{
		return symbol;
	}
}
