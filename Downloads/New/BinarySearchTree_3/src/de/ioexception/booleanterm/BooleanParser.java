package de.ioexception.booleanterm;

import java.text.ParseException;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Parser takes correctly formatted boolean terms (infix) and builds a tree
 * 
 * @author Benjamin Erb
 * 
 */
public class BooleanParser
{

	/**
	 * Parses and returns infix term
	 * 
	 * @param infixExpression
	 *            Term (infix notation)
	 * @return Textual term (infix)
	 * @throws ParseException
	 */
	public static String parseToString(String infixExpression) throws ParseException
	{
		return parseToTree(infixExpression).toString();
	}

	/**
	 * Validates if term is an correctly formatted infix term.
	 * 
	 * @param infixExpression
	 *            Term (infix)
	 * @return validity
	 */
	public static boolean isValidExpression(String infixExpression)
	{
		try
		{
			parseToTree(infixExpression);
		}
		catch (ParseException e)
		{
			return false;
		}
		return true;
	}

	/**
	 * Calculates the value of an infix term
	 * 
	 * @param infixExpression
	 *            term (infix)
	 * @return the boolean result
	 * @throws ParseException
	 */
	public static boolean calculate(String infixExpression) throws ParseException
	{
		return parseToTree(infixExpression).evaluate();
	}

	/**
	 * Internal parsing method. First converts textual term into postfix
	 * notation and eventually into a tree.
	 * 
	 * @param infixExpression
	 *            Term (infix)
	 * @return Term (as tree)
	 * @throws ParseException
	 */
	private static Node parseToTree(String infixExpression) throws ParseException
	{
		// Expression tidying
		infixExpression = infixExpression.toUpperCase().replaceAll("TRUE", "1").replaceAll("FALSE", "0").replaceAll("WAHR", "1").replaceAll("FALSCH", "0").replaceAll("AND", "&").replaceAll("OR", "|")
				.replaceAll("XOR", "^").replaceAll("NOT", "!").replaceAll("UND", "&").replaceAll("ODER", "|").replaceAll("NICHT", "!").replaceAll("[^()10&|!\\^]", "");

		if(infixExpression.length() == 0)
		{
			throw new ParseException("Invalid expression!", -1);
		}

		// Infix to postfix
		StringBuffer postfixExpression = new StringBuffer();
		Stack<String> stack = new Stack<String>();
		try
		{
			INFIX_PARSE: for (char c : infixExpression.toCharArray())
			{
				for (Operator op : UnaryOperator.values())
				{
					if(c == op.getSymbol())
					{
						stack.push(Character.toString(c));
						continue INFIX_PARSE;

					}
				}
				for (Operator op : BinaryOperator.values())
				{
					if(c == op.getSymbol())
					{
						stack.push(Character.toString(c));
						continue INFIX_PARSE;

					}
				}
				if(c == ')')
				{
					postfixExpression.append(stack.pop());
				}
				else if(c == '(')
				{
					// ignore
				}
				else
				{
					postfixExpression.append(Character.toString(c));
				}
			}
		}
		catch (EmptyStackException e)
		{
			throw new ParseException("Invalid expression!", -1);
		}
		if(!stack.empty())
		{
			throw new ParseException("Invalid expression!", -1);
		}

		// Postfix to tree
		Stack<Node> nodeStack = new Stack<Node>();
		try
		{
			POSTFIX_PARSE: for (char c : postfixExpression.toString().toCharArray())
			{
				for (Operator op : UnaryOperator.values())
				{
					if(c == op.getSymbol())
					{
						OperatorNode node = new OperatorNode(op);
						node.setNode(0, nodeStack.pop());
						nodeStack.push(node);
						continue POSTFIX_PARSE;

					}
				}
				for (Operator op : BinaryOperator.values())
				{
					if(c == op.getSymbol())
					{
						OperatorNode node = new OperatorNode(op);
						node.setNode(1, nodeStack.pop());
						node.setNode(0, nodeStack.pop());
						nodeStack.push(node);
						continue POSTFIX_PARSE;
					}
				}
				nodeStack.push(new BooleanNode(c == '1' ? true : false));
			}
		}
		catch (EmptyStackException e)
		{
			throw new ParseException("Invalid expression!", -1);
		}
		if(nodeStack.size() != 1)
		{
			throw new ParseException("Invalid expression!", -1);
		}
		return nodeStack.pop();
	}
}
