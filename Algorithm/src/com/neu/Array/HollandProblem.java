package com.neu.Array;


/**
 *  The <tt>HollandProblem</tt> Java  provides a static method for 
 *  solving  Holland Problem
 *  <p>
 *  <tt>Question:</tt>Given a disorderly array A[0...N-1] , then
 *   find the fist miss Integer of the array
 *  
 *  @author Johnqiu
 */
public class HollandProblem {

	/**
	 * Solving  Holland Problem
	 * @param a   Array
	 * @param size   the size of array
	 * @return  the first miss number
	 */
	    public static int[] holland(int[]A, int size){
	    	    int begin =0;
	    	    int current = 0;
	    	    int end = size -1;
	    	    
	    	    while(current <=end){
	    	    	    if(A[current] == 2){   // A[current] == 2
	    	    	    	   int temp = A[end];
	    	    	    	   A[end] = A[current];
	    	    	    	   A[current] = temp;
	    	    	    	   end--;
	    	    	    }else if(A[current] == 1){
	    	    	    	    current++;
	    	    	    }else{
	    	    	    	     if (begin != current){
	    	    	    	    	 int temp = A[begin];
	    	    	    	    	 A[begin] = A[current];
	    	    	    	    	 A[current] = temp;
	    	    	    	     }
	    	    	    	     begin++;
    	    	    	    	 current++;
	    	    	    }
	    	    }
	    	    return A;
	    }

		/**
		 * Unit Test
		 * @param args
		 */
		public static void main(String[] args) {
			   int[] a = {0,1,2,0,1,1,0,2,2};
			   int[] m = holland(a, a.length);
			   for(int k: m){
				   System.out.print(k+",");
			   }
			  
		}
}
