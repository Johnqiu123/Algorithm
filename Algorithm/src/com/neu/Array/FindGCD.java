package com.neu.Array;

import java.util.Arrays;

public class FindGCD {

	public int gcd(int a, int b){
		while(b != 0){
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	public int findGCD(int[] array){
		Arrays.sort(array);
		int temp = array[0];
		for(int i = 1; i < array.length; i++){
			temp = gcd(array[i],temp);
		}
		return temp;
	}
	
	public static void main(String[] args) {
		int[] array = {2,4,6,8,10};
		FindGCD fg = new FindGCD();
		int result = fg.findGCD(array);
		System.out.println(result);
	}
}
