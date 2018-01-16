package net.mrpaul.pb050.ps09;
/**
 * Recursive and Dynamic fibonacci calculations
 * For the recursive function, the amount of time it takes to run increases exponentially and takes a very long time when n > 25
 * For the dynamic function, the amount of time it takes increases linearly, and continues to run quick when n >= 45
 * @author 409351
 *
 */
public class Fibonacci {

	public static int recursiveFibonacci(int n) {
		//base cases
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}
		//recursive case
		else {
			return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
		}
	}
	
	public static int dynamicFibonacci(int n) {
		int[] fib = new int[n + 1];
		fib[0] = 0;
		if(n > 0) {
			fib[1] = 1;
			for(int i = 2; i<fib.length; i++) {
				fib[i] = fib[i-2] + fib[i-1];
			}
		}
		
		return fib[n];
	}
	
	public static void main(String[] args) {
		long nanoTime = System.nanoTime();
		dynamicFibonacci(45);
		nanoTime = System.nanoTime() - nanoTime;
		System.out.println(nanoTime);
	}
	
}
