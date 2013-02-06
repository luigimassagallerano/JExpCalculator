package com.mydevelopedworld.core.grammar.visitors;

import com.mydevelopedworld.core.grammar.symbols.Operator;

public class InfixVisitor extends ExpressionVisitor {

	@Override
	public void visit(Operator operator) {
		operator.getLeft().accept(this);
		System.out.print(operator.getOperator());
		operator.getRight().accept(this);
	}

}
