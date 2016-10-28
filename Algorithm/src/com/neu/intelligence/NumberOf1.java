package com.neu.intelligence;

public class NumberOf1 {

	public int numberof1(int n){
		int count = 0;
		while(n != 0){
			++count;
			n = (n - 1) & n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int a = 50;
		String k = Integer.toBinaryString(50);
		System.out.println(k);
	}
}
