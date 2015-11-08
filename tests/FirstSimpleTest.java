import com.mydevelopedworld.core.grammar.Context;
import com.mydevelopedworld.core.grammar.symbols.Constant;
import com.mydevelopedworld.core.grammar.symbols.Operator;
import com.mydevelopedworld.core.grammar.symbols.Variable;
import com.mydevelopedworld.core.grammar.visitors.InfixVisitor;
import com.mydevelopedworld.core.grammar.visitors.PostfixVisitor;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FirstSimpleTest {

    @Test
    public void test_MultiplicationWithTwoVariables() {
        /* 3+x * 5-y */
        Operator add = new Operator(new Constant(3), new Variable("x"), Operator.Operators.ADD);
        Operator min = new Operator(new Constant(5), new Variable("y"), Operator.Operators.MINUS);
        Operator mul = new Operator(add, min, Operator.Operators.MUL);

        /* x, y = 1 */
        Context c = new Context();
        c.assign("x", 1);
        c.assign("y", 1);

        assertThat(mul.evaluate(c), is(16d));
    }

    @Test
    public void test_DivisionWithTwoVariables() {
        /* 10+x * 12-y / 5+x */
        Operator add = new Operator(new Constant(10), new Variable("x"), Operator.Operators.ADD);
        Operator min = new Operator(new Constant(12), new Variable("y"), Operator.Operators.MINUS);
        Operator mul = new Operator(add, min, Operator.Operators.MUL);
        Operator add2 = new Operator(new Constant(5), new Variable("x"), Operator.Operators.ADD);
        Operator div = new Operator(mul, add2, Operator.Operators.DIV);

		/* x = 3 y = 2 */
        Context c = new Context();
        c.assign("x", 3);
        c.assign("y", 2);

        assertThat(div.evaluate(c), is(16.25));
    }
}
