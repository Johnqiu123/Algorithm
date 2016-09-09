package com.neu.Array;

import java.util.Scanner;

/**
 *  The <tt>MaxSubArray</tt> Java  provides a Binary search  method for 
 *  finding the sum of sub array which  is the biggest
 *  <p>
 *  <tt>Question:</tt>Given a diorderly array A[0...N-1] , then
 *   find the sum of sub array which  is the biggest
 *  
 *  @author Johnqiu
 */
public class MaxSubArray {
	
	/**
	 * Find the sum of sub array which  is the biggest
	 * @param a   Array
	 * @param size   the size of array
	 * @return  the sum of subarray
	 */
	    public static int  maxSubarray(int[]A, int size){
	    	
	    	    if(A.length == 0 || size ==0){    // illegal input
	    	    	return -1;
	    	    }
	    	    
	    	    int sum = A[0]; // begin from the first value
	    	    int result = sum; // the current best answer
	    	    
	    	    for (int i=1; i < size; i++){
	    	    	 if (sum > 0){
	    	    		 sum  += A[i];
	    	    	 }else{
	    	    		 sum = A[i];
	    	    	 }
	    	    	 result = Math.max(sum, result);
	    	    }
	    	    return result;
	    }


		/**
		 * Find the sum of sub array which  is the biggest and mark array
		 * @param a   Array
		 * @param size   the size of array
		 * @return  the sum of subarray
		 */
	    public static int  maxSubarray2(int[]A, int size){
	    	
    	    if(A.length == 0 || size ==0){    // illegal input
    	    	return -1;
    	    }
    	    
    	    int from =0;
    	    int to = 0;
    	    int sum = A[0]; // begin from the first value
    	    int result = sum; // the current best answer
    	    int fromNew=0;
    	    
    	    for (int i=1; i < size; i++){
    	    	 if (sum > 0){
    	    		 sum  += A[i];
    	    	 }else{
    	    		 sum = A[i];
    	    		 fromNew = i; 		 
    	    	 }
    	    	 if(result < sum){
    	    		 result = sum;
    	    		 from = fromNew;
    	    		 to = i;
    	    	 }
    	    }
    	    System.out.println(fromNew);
    	    System.out.println(to);
    	    return result;
    }
	    

		/**
		 * Unit Test
		 * @param args
		 */
	    public static void main(String[] args) {
//			   int[] a = {1,-1,3,10,-4,7,2,-5};
//			   int m = maxSubarray(a, a.length);
////			   int m = maxSubarray2(a, a.length);
//			   System.out.println(m);
			   
			   Scanner scan = new Scanner(System.in);
			   int n = scan.nextInt();
			   scan.nextLine();
			   String[] stringArray = scan.nextLine().split(" ");
			   int[] array = new int[n];
			   for(int i=0; i < n; i++){
				  System.out.println(stringArray[i]);
				  array[i] = Integer.parseInt(stringArray[i]);
			   }
			   int result = maxSubarray(array, n);
			   System.out.println(result);
		}

}
