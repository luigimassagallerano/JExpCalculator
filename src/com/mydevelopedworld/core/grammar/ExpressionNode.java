package com.mydevelopedworld.core.grammar;

import com.mydevelopedworld.core.grammar.visitors.ExpressionVisitor;

public interface ExpressionNode {		
	
	public double evaluate(Context c); 	
	public void accept(ExpressionVisitor visitor);
        	
}
