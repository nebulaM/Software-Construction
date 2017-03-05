import java.util.Stack;

/**
 * 
 * @author Sathish Gopalakrishnan
 * 
 * This class contains a method to evaluate an arithmetic expression
 * that is in Postfix notation (or Reverse Polish Notation).
 * See <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Wikipedia</a>
 * for details on the notation.
 *
 */
public class PostfixEvaluator {
	
	private String arithmeticExpr;
	
	/**
	 * This is the only constructor for this class.
	 * It takes a string that represents an arithmetic expression
	 * as input argument.
	 * 
	 * @param expr is a string that represents an arithmetic expression 
	 * <strong>in Postfix notation</strong>.
	 */
	public PostfixEvaluator( String expr ) {
		arithmeticExpr = expr;
	}
	/**
	 * This method evaluates the arithmetic expression that 
	 * was passed as a string to the constructor for this class.
	 * 
	 * @return the value of the arithmetic expression
	 * @throws MalformedExpressionException if the provided expression is not
	 * 	a valid expression in Postfix notation
	 */
	static double eval(String expr) throws MalformedExpressionException {
		// TODO: Implement this method.
		// The code provided here is for illustration only, and
		// can be deleted when you write your implementation.

		// Using a stack makes it very simple to evaluate the
		// arithmetic expression.
		// See http://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
		
		// Use the Scanner to get the elements (tokens) in the
		// arithmetic expression.
		
		Scanner scanner = new Scanner(expr);
		Token currToken = scanner.getToken();
		Stack<Double> s=new Stack<>();
		// now process the token, etc.
		// You should read the implementation of the Token class
		// to determine what methods you can and should use.
		
		// It is sufficient to support the four basic operations:
		// addition, subtraction, multiplication & division.

		while(!scanner.isEmpty()) {
            if (currToken.isDouble()) {
                s.push(currToken.getValue());
                System.out.println("push " + s.peek() + " to stack");
            } else if (currToken.isVariable()) {
                String operator = currToken.getName().trim();
                Double num1;
                switch (operator) {
                    case "+":
                        num1 = s.pop();
                        s.push(s.pop() + num1);
                        break;
                    case "-":
                        num1 = s.pop();
                        s.push(s.pop() - num1);
                        break;
                    case "*":
                        num1 = s.pop();
                        s.push(s.pop() * num1);
                        break;
                    case "/":
                        num1 = s.pop();
                        s.push(s.pop() / num1);
                        break;
                    default:
                        throw new MalformedExpressionException("operator should be one of: + = * / ");
                }
            }else{
                System.out.println("@eval: Warning, unexpected expression "+currToken.getName());
            }
            scanner.eatToken();
            currToken=scanner.getToken();

        }
        if(s.empty()){
		    throw new MalformedExpressionException("stack is empty after calculation");
        }
        if(s.size()>1){
            throw new MalformedExpressionException("stack size should be 1 after calculation");
        }
		Double result=s.pop();
        System.out.println("result is "+result);
		return result;
	}
	
}