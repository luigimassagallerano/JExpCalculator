package com.mydevelopedworld.core.grammar.symbols;

import com.mydevelopedworld.core.grammar.Context;
import com.mydevelopedworld.core.grammar.ExpressionNode;
import com.mydevelopedworld.core.grammar.visitors.ExpressionVisitor;

public class Variable implements ExpressionNode {

	private String name;
	
	public Variable(String name){
		this.name = name;
	}
	
	@Override
	public double evaluate(Context c) {
		return c.lookup(this.name);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);	
	}
	
	public String getName(){
		return this.name;
	}

}
