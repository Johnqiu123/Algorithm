package com.neu.String;

import java.util.Scanner;

public class Palindrome {
	
	/**
	 * given a string , judge it whether is palindrome or not
	 * @param s
	 * @return
	 */
	public static boolean isPalindromeByBuffer(String s){
		StringBuffer  newStr = new StringBuffer(s);
		if(s.equals(newStr.reverse().toString())){
			return true;
		}else{
			return false;
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String A = in.next();
		String B = in.next();
		
		int count = 0;
		int i=0;
		int end = A.length();
		String str = null;
		for(i=0; i < end + 1; i++){
			if(i == 0){
				str = B + A;	
			}else if(i == end){
				str = A + B;	
			}else{
				str = A.substring(0,i)+ B + A.substring(i,end);
			}
			if(isPalindromeByBuffer(str)){
				count++;
			}
		}
		System.out.println(count);
	}

}
