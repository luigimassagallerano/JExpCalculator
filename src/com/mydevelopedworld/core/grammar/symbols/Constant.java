package com.mydevelopedworld.core.grammar.symbols;

import com.mydevelopedworld.core.grammar.Context;
import com.mydevelopedworld.core.grammar.ExpressionNode;
import com.mydevelopedworld.core.grammar.visitors.ExpressionVisitor;

public class Constant implements ExpressionNode {

	private double value;
	
	public Constant(double value){
		this.value = value;
	}
	
	@Override
	public double evaluate(Context c) {
		return this.value;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);	
	}
	
	public double getValue(){
		return this.value;
	}

}
