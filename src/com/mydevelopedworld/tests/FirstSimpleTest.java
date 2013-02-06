package com.mydevelopedworld.tests;

import com.mydevelopedworld.core.grammar.Context;
import com.mydevelopedworld.core.grammar.symbols.Constant;
import com.mydevelopedworld.core.grammar.symbols.Operator;
import com.mydevelopedworld.core.grammar.symbols.Variable;
import com.mydevelopedworld.core.grammar.visitors.InfixVisitor;
import com.mydevelopedworld.core.grammar.visitors.PostfixVisitor;

public class FirstSimpleTest {

	public static void main(String args[]){
		
		/* 3+x * 5-y */
		Operator add = new Operator(new Constant(3), new Variable("x"), Operator.Operators.ADD);		
		Operator min = new Operator(new Constant(5), new Variable("y"), Operator.Operators.MINUS);		
		Operator mul = new Operator(add, min, Operator.Operators.MUL);
		
		/* Postfix Print */
		System.out.print("Postfix: ");
		mul.accept(new PostfixVisitor());
		System.out.println();
		
		/* Infix Print */
		System.out.print("Infix: ");
		mul.accept(new InfixVisitor());
		System.out.println();
		
		/* x, y = 1 */
		Context c = new Context();
		c.assign("x", 1);
		c.assign("y", 1);
		
		System.out.println();
		assert mul.evaluate(c) == 16;
		System.out.println("Result: ["+mul.evaluate(c)+"] - Context: "+c+"\n");
		
		c.assign("x", 4);
		c.assign("y", 5);
		
		assert mul.evaluate(c) == 0;
		System.out.println("Result: ["+mul.evaluate(c)+"] - Context: "+c+"\n");		
		
		/* 10+x * 12-y / 5+x */
		add = new Operator(new Constant(10), new Variable("x"), Operator.Operators.ADD);		
		min = new Operator(new Constant(12), new Variable("y"), Operator.Operators.MINUS);		
		mul = new Operator(add, min, Operator.Operators.MUL);
		Operator add2 = new Operator(new Constant(5), new Variable("x"), Operator.Operators.ADD);
		Operator div = new Operator(mul, add2, Operator.Operators.DIV);
		
		/* Postfix Print */
		System.out.print("Postfix: ");
		div.accept(new PostfixVisitor());
		System.out.println();
		
		/* Infix Print */
		System.out.print("Infix: ");
		div.accept(new InfixVisitor());
		System.out.println();
		
		/* x = 3 y = 2 */
		c.assign("x", 3);
		c.assign("y", 2);
		
		System.out.println();
		assert div.evaluate(c) == 16.25;
		System.out.println("Result: ["+div.evaluate(c)+"] - Context: "+c+"\n");	
		
	}

}
