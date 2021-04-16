package de.ioexception.booleanterm;


/**
 * Klasse fuer Knoten mit Operatoren
 * 
 * @author Benjamin Erb
 *
 */
public class OperatorNode implements Node
{
	Node[] siblings;
	final Operator operator;
	
	public OperatorNode(Operator op)
	{
		this.operator = op;
		siblings = new Node[op.getOperands()];
		
	}

	@Override
	public boolean evaluate()
	{
		return operator.eval(getBooleanSiblings());
	}
	
	/**
	 * Gibt die boolschen Werte der Kindknoten zurueck.
	 * @return Array der Kindwerte  
	 */
	private boolean[] getBooleanSiblings()
	{
		boolean[] args = new boolean[operator.getOperands()];
		for(int i = 0;i<args.length;args[i] = siblings[i++].evaluate());
		return args;
	}
	
	@Override
	public String toString()
	{
		if(operator instanceof UnaryOperator)
		{
			return "("+operator+" "+siblings[0]+")";
		}
		else if(operator instanceof BinaryOperator)
		{
			return "("+siblings[0]+" "+operator+" "+siblings[1]+")";
		}
		else
		{
			throw new IllegalArgumentException("Unkown operator");	
		}			
	}
	
	/**
	 * Setzt den uebergeben Knoten als Kindknoten am uebergebenen Index
	 * @param index Index (Start bei 0)
	 * @param node Knoten
	 */
	public void setNode(int index, Node node)
	{
		if(index < 0 || index > siblings.length -1)
		{
			throw new IndexOutOfBoundsException();
		}
		siblings[index] = node;
	}	
}
