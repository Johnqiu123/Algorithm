package com.neu.Array;

/**
 *  The <tt>FindMinRotateArray</tt> Java  provides a Binary search  method for 
 *  finding the min Integer of the rotation  array
 *  <p>
 *  <tt>Question:</tt>Given a rotation array A[0...N-1] , then
 *   find the min Integer of the rotation  array
 *  
 *  @author Johnqiu
 */
public class FindMinRotateArray {
	
	/**
	 * Find the min Integer of the rotation  array
	 * @param a   Array
	 * @param size   the size of array
	 * @return  the first miss number
	 */
	    public static int findMin(int[]A, int size){
        	     int low = 0;
        	     int high = size-1;
        	     int mid;
        	     
        	     while(low < high){
        	    	 mid = (low + high) /2;
        	    	 if (A[mid] < A[high]){
        	    		 high = mid;
        	    	 }else if(A[mid] > A[high]){
        	    		 low = mid +1;
        	    	 }
        	     }
        	     return A[low];
           }

		/**
		 * Unit Test
		 * @param args
		 */
	    public static void main(String[] args) {
			   int[] a = {4,5,6,7,0,1,2};
			   int m = findMin(a, a.length);
			   System.out.println(m);
		}
}
