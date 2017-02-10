package fibonacciTransform;

public class FibTransform {

	/**
	 * Transform a number into a Fibonacci number using at most m steps: Of
	 * these steps, one can be a doubling step, and the other steps increase
	 * the number at hand by adding 1.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible_onlyOneDoubling(int n, int m) {
		return n>=0 && isPossible_onlyOneDoublingHelper(n,m,false);
	}

	private static boolean isPossible_onlyOneDoublingHelper(int n, int m, boolean doubled){
	    if(m<=0){
	        return isFib(n);
        }
        if(doubled) {
            return isFib(n) || isPossible_onlyOneDoublingHelper(n+1,m-1,doubled);
        }
        return isFib(n) || isPossible_onlyOneDoublingHelper(n+1,m-1,doubled) || isPossible_onlyOneDoublingHelper(n<<1,m-1,true);
    }
    //http://stackoverflow.com/questions/13336593/java-check-if-number-belongs-to-fibonacci-sequence
    public static boolean isFib(int n) {
        if(n==0){
            return true;
        }
        int fib1 = 0;
        int fib2 = 1;
        while (fib2 < n){
            int saveFib1 = fib1;
            fib1 = fib2;
            fib2 = saveFib1 + fib2;
        }
        return fib2 == n;
    }

	/**
	 * Transform a number into a Fibonacci number using at most m steps: One can
	 * use any sequence of doubling (*2) or addition (+1) steps as long as the
	 * total number of steps used is no more than m.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible(int n, int m) {
		if(n<0){
		    return false;
        }
        if(m<=0){
            return isFib(n);
        }
		return isFib(n) || isPossible(n+1,m-1) || isPossible(n<<1,m-1);
	}

}
