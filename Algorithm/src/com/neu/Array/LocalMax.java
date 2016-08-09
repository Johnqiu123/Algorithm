package com.neu.Array;

/**
 *  The <tt>LocalMax</tt> Java  provides a static method for binary
 *  searching for a local max integer in a disorderly array of integers.
 *  <p>
 *  <tt>Question:</tt>Given a disorderly array A[0...N-1] without repeating elements, then
 *   find A local maximum of the array
 *  
 *  @author Johnqiu
 */

public class LocalMax {
	
    /**
     * This class should not be instantiated.
     */
    private LocalMax() { }
    
    /**
     *  Return  one of the local max values in the array
     *  
     * @param A  a disorderly array
     * @param size the size of A
     * @return the local max 
     */
    public static int  findLocalMax(int[] A , int size){
    	  int left = 0;
    	  int right = size-1;
    	  int mid;
    	  
    	  while(left < right){
    		     mid = (left + right) / 2;
    		     System.out.println("mid="+mid+",left="+left+",right="+right);
    		     if (A[mid] > A[mid + 1]){
    		    	 right = mid;
    		     }else{
    		    	 left = mid + 1;
    		     }
    	  } 	  
    	  return A[left];
    }
    
    /**
     * define a array to test method FindLocalMax()
     */
    public static void main(String[] args) {
		  int[] a = {1,2,13,6,7,8,11,9,10};
		  int value = LocalMax.findLocalMax(a, a.length);
		  System.out.println(value);
	}
}
