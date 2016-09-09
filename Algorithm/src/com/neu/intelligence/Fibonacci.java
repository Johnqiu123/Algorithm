package com.neu.intelligence;

public class Fibonacci {
	
	/**
	 * compute n fibonacci by recursion
	 * Question: repeat compute too much
	 * @param n
	 * @return
	 */
	public int fibonacci(int n) {
		if(n < 0){  // n < 0
			return -1;
		}
		if(n == 0){ // n = 0
			return 0;
		}
		
		if(n == 1){  // n = 1
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n-2); // n > 1
    }
	
	/**
	 * 通过保存中间项的方法减少重复计算
	 * @param n
	 * @return
	 */
	public int fibonacciByDP(int n){
		if(n < 0){  // n < 0
			return -1;
		}
		if(n == 0){ // n = 0
			return 0;
		}
		
		if(n == 1){  // n = 1
			return 1;
		}
		
		int fibNMinusOne = 1;
		int fibNMinusTwo = 0;
		int fibN = 0;
		for(int i = 2; i <= n; i++){
			fibN = fibNMinusOne + fibNMinusTwo;
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		return fibN;
	}
	
	public static void main(String[] args) {
		Fibonacci fb = new Fibonacci();
//		int result = fb.fibonacci(39);
		int result = fb.fibonacciByDP(39);
		System.out.println(result);
	}
}
