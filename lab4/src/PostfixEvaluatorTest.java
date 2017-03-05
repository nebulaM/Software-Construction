import static org.junit.Assert.*;

import org.junit.Test;

import java.net.MalformedURLException;

public class PostfixEvaluatorTest {

	// Implement a sufficient number of tests to have
	// reasonable confidence in the correctness of your
	// PostfixEvaluator implementation.
	
	@Test
	public void test() throws MalformedExpressionException{
	    Double delta=0.01;
        assertEquals(2.7,PostfixEvaluator.eval("5 1 2 + 4 * + 3.5 - 5 /"), delta);
        assertEquals(-3.5,PostfixEvaluator.eval("5 1 2 2.5 + 4 * + - 3.5 - 5 /"),delta);
        assertEquals(3,PostfixEvaluator.eval("3"),delta);
	}

}
