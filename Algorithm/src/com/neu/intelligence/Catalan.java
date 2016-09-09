package com.neu.intelligence;

import java.math.BigInteger;

/**
 *  The <tt>Catalan</tt> Java  provides a  method for 
 *  computing catalan number
 *  <p>
 *  <tt>Question:</tt>Given a rotation array A[0...N-1] , then
 *   find the min Integer of the rotation  array
 *   
 *   一个栈（无穷大）的进栈序列为1,2,3…,n，共多少种不同的出栈序列？
 *  
 *  @author Johnqiu
 */
public class Catalan {

	/**
	 * compute catalan number by (2*n)!/(n+1)!n!
	 * @param n
	 * @return
	 */
	public static BigInteger catalan(int n){
		if(n == 1|| n==0){
			return BigInteger.ONE;
		}
		BigInteger cat = new BigInteger(Integer.toString(2*n)); // 2*n
		BigInteger twice = new BigInteger(Integer.toString(2 * n)); // 2*n
		BigInteger i = new BigInteger("1");
		
		for(int j = 1; j < n; j++, i=i.add(BigInteger.ONE)){
			cat = cat.multiply(twice.subtract(i));  // (2*n)(2*n-1)(2*n-2)...(n+1)
		}
		
		i = i.add(BigInteger.ONE);
		for(int j = n+1; j >= 1; j--, i = i.subtract(BigInteger.ONE)){
			cat = cat.divide(i); // (2*n)!/(n+1)!n!
		}
		return cat;
	}
	
	public static void main(String[] args) {
		int n = 4;
		BigInteger result = catalan(n);
		System.out.println(result);
	}
}
