package com.neu.Array;

import java.util.Arrays;

/**
 *  The <tt>MinSubArray</tt> Java  provides a Binary search  method for 
 *  finding the sum of sub array which  is close to zero
 *  <p>
 *  <tt>Question:</tt>Given a diorderly array A[0...N-1] , then
 *   find the sum of sub array which  is close to zero
 *  
 *  @author Johnqiu
 */
public class MinSubArray {
	
	/**
	 * Find the sum of sub array which  is close to zero
	 * @param a   Array
	 * @param size   the size of array
	 * @return  the sum of subarray
	 */
	    public static int  minSubarray(int[]A, int size){
	    	    if(A.length == 0 || size ==0){    // illegal input
	    	    	return -1;
	    	    }
	    	    int[] sum = new int[size+1];  // sum[i]: the sum of A[0],A[1],...[i-1]
	    	    sum[0] = 0;
	    	    int i = 0;
	    	    
	    	    for (i = 0; i < size; i++){
	    	    	sum[i+1] = sum[i]+ A[i];
	    	    }
	    	    for(int k: sum){
	    	    	System.out.print(k+",");
	    	    }
	    	    System.out.println("");
	            Arrays.sort(sum); // sort
	    	    for(int k: sum){
	    	    	System.out.print(k+",");
	    	    }
	    	    System.out.println("");
	            int difference = Math.abs(sum[1]-sum[0]);
	            int minNum = difference;
	            int n = 0;
	            for (i = 1; i < size; i++){
	            	difference = Math.abs(sum[i+1]-sum[i]);
	            	if(minNum > difference){
	            		   n = i;
	            		   minNum = difference;
	            	}
	            }
	            System.out.println("i="+n);
	            return minNum;
	    }

		/**
		 * Unit Test
		 * @param args
		 */
	    public static void main(String[] args) {
			   int[] a = {1,-2,3,10,-4,7,2,-5};
			   int m = minSubarray(a, a.length);
			   System.out.println(m);
		}

}
