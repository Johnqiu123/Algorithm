package com.neu.Array;

import java.util.Arrays;
import java.util.Hashtable;

/**
 *  The <tt>TwoSum</tt> Java  provides a Binary search  method for 
 *  finding the sum of sub array which  equals to given number
 *  <p>
 *  <tt>Question:</tt>Given a diorderly array A[0...N-1] , then
 *   find the sum of sub array which  equals to given number
 *  
 *  @author Johnqiu
 */

public class TwoSum {
	
	/**
	 * First sort a array, then use binary search method to sum two number
	 * @param a array
	 * @param value sum
	 * @return
	 */
	public static boolean twoSum(int[] a, int value){
		if(a == null){
			return false;
		}
		Arrays.sort(a);
		int i = 0;
		int j = a.length -1;
		int result = 0;
		while(i < j){
			result = a[i] + a[j];
			if(result > value){
				j--;
			}else if(result < value){
				i++;
			}else{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * create hashtable by array
	 * @param a
	 * @param value
	 * @return
	 */
	public static boolean twoSumByHash(int[] a, int value){
		if(a == null){
			return false;
		}
		Hashtable<Integer,Integer> hashtable = new Hashtable<Integer,Integer>();
		for(int i=0; i<a.length; i++){
			hashtable.put(a[i], a[i]);
		}
		for(int i=0; i<a.length; i++){
			Integer n = hashtable.get(value - a[i]);
		    if (n != null) {
		      return true;
		    }
		}
		return false;
	}
	public static void main(String[] args) {
		int[] a = {2,5,1,3,8,9};
		int value = 17;
		boolean flag = twoSum(a, value);
		boolean flag2 = twoSumByHash(a, value);
		System.out.println(flag);
		System.out.println(flag2);
	}
}
