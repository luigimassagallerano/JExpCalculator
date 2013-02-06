package com.mydevelopedworld.core.grammar.visitors;

import com.mydevelopedworld.core.grammar.symbols.Operator;

public class PostfixVisitor extends ExpressionVisitor {

	@Override
	public void visit(Operator operator) {
		operator.getLeft().accept(this);
		operator.getRight().accept(this);
		System.out.print(operator.getOperator());
	}

	
}
