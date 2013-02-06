package com.mydevelopedworld.core.grammar.visitors;

import com.mydevelopedworld.core.grammar.symbols.Constant;
import com.mydevelopedworld.core.grammar.symbols.Operator;
import com.mydevelopedworld.core.grammar.symbols.Variable;

public abstract class ExpressionVisitor {    

	public abstract void visit(Operator operator);
	
	public void visit(Variable variable) {
		System.out.print(variable.getName());
	}

	public void visit(Constant constant) {
		System.out.print(constant.getValue());
	}


}
