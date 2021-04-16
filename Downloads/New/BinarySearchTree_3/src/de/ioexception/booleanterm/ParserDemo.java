package de.ioexception.booleanterm;

import java.text.ParseException;

public class ParserDemo
{
	public static void main(String[] args)
	{
		
		String validExpression = "((NOT TRUE) OR  ((TRUE aNd 1) OR FALSCH))";
		String invalidExpression = "((NEITHER 1 NOR 0) (NOT CORRECT ((TRUE aNd 1) OR 1))";
		
		try
		{
			System.out.println("Expression 1:");
			System.out.println("Valid:");
			System.out.println(BooleanParser.isValidExpression(validExpression));
			System.out.println("Infix:");
			System.out.println(BooleanParser.parseToString(validExpression));
			System.out.println("Result:");
			System.out.println(BooleanParser.calculate(validExpression));
			System.out.println("Expression 2:");
			System.out.println("Valid:");
			System.out.println(BooleanParser.isValidExpression(invalidExpression));
			System.out.println("Infix:");
			System.out.println(BooleanParser.parseToString(invalidExpression)); //oops..
			System.out.println("Result:");
			System.out.println(BooleanParser.calculate(invalidExpression));  //oops..
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}