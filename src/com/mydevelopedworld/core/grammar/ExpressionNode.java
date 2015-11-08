package com.mydevelopedworld.core.grammar;

import com.mydevelopedworld.core.grammar.visitors.ExpressionVisitor;

public interface ExpressionNode {
    double evaluate(Context c);
    void accept(ExpressionVisitor visitor);
}
