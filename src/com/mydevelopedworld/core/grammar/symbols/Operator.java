package com.mydevelopedworld.core.grammar.symbols;

import com.mydevelopedworld.core.grammar.ExpressionNode;
import com.mydevelopedworld.core.grammar.Context;
import com.mydevelopedworld.core.grammar.visitors.ExpressionVisitor;

public class Operator implements ExpressionNode {
	
	private Operators operator;
	private ExpressionNode left, right;

	public Operator(ExpressionNode left, ExpressionNode right, Operators o){
		this.left = left;
		this.right = right;
		this.operator = o;
	}

	@Override
	public double evaluate(Context c) {
		switch(this.operator){
		case DIV:
			return this.left.evaluate(c) / this.right.evaluate(c);
		case MUL:
			return this.left.evaluate(c) * this.right.evaluate(c);
		case ADD:
			return this.left.evaluate(c) + this.right.evaluate(c);
		default:
			return this.left.evaluate(c) - this.right.evaluate(c);
		}
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);	
	}

	public Operators getOperator() {
		return this.operator;
	}

	public ExpressionNode getLeft() {
		return this.left;
	}

	public ExpressionNode getRight() {
		return this.right;
	}
	
	public static enum Operators{ 
		DIV { 
			public String toString() {
				return "/";
			}	       
		},

		MUL{ 
			public String toString() {
				return "*";
			}
		}, 

		ADD{ 
			public String toString() {
				return "+";
			}
		},

		MINUS{ 
			public String toString() {
				return "-";
			}
		} 
	};

}
