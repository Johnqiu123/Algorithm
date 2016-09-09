package com.neu.intelligence;

public class Power {

	static boolean g_InvalidInput = false;
	
	public static double power(double base, int exponent){
		g_InvalidInput = false;
		
		// 处理0的倒数次方
		if(equal(base, 0.0) && exponent < 0){
			g_InvalidInput = true;
			return 0.0;
		}
		
		int absExponent = exponent;
		if(exponent < 0){
			absExponent = -exponent;
		}
		
		double result = powerWithExponent(base, absExponent);
		if(exponent < 0){
			result = 1 / result;
		}
		return result;
	}

	/**
	 * compute power with exponent
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double powerWithExponent(double base, int exponent) {
		double result = 1.0;
		for(int i=0; i < exponent; i++){
			result *= base;
		}
		return result;
	}

	/**
	 * 判断double型的数据之间是否相等
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static boolean equal(double num1, double num2) {
		if((num1 - num2) > -0.0000001 && (num1 - num2) < 0.00000001){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		double result = power(2, 5);
		System.out.println(result);
	}
}
