package com.neu.Array;

import java.util.ArrayList;

/**
 *  The <tt>CalcMaxGap</tt> Java  provides a Binary search  method for 
 *  finding the min Integer of the rotation  array
 *  <p>
 *  <tt>Question:</tt>Given a rotation array A[0...N-1] , then
 *   find the min Integer of the rotation  array
 *  
 *  @author Johnqiu
 */
public class Cantor {

	    /**
	     * Create a cantor array
	     * @param a    original array
	     * @param b    cantor array
	     * @param size  the size of array
	     */
	    public static void createCantor(int[] a, int[] b, int size){
	    	    int i,j;
	    	    for (i = 0; i < size; i++){
	    	    	   b[i] = 0;
	    	    	   for (j =i+1; j <size; j++){
	    	    		       if (a[j] < a[i]){
	    	    		    	     b[i] ++;
	    	    		       }
	    	    	   }
	    	    }
	    }
	    
	    /**
	     * Resume cantor to the orginal array
	     * @param a   cantor array
	     * @param b  original array
	     * @param size  the size of array
	     */
	    public static void cantorResume(int[] a, int[]b, int size){
	    	     ArrayList<Integer> list =new ArrayList<Integer>();
	    	     for (int i=1; i <= size; i++){
	    	    	     list.add(i);
	    	     }
	    	     for (int j=0; j < size; j++){
	    	    	     int index = a[j];
	    	    	     int num = list.remove(index);
	    	    	     b[j] = num;
	    	     }
	    	     
	    }

	    /**
	     * Resume cantor to the orginal array
	     * @param a   cantor array
	     * @param b  original array
	     * @param size  the size of array
	     */
	    public static void cantorResume2(int[] a, int[]b, int size){
	    	    int i,j;
	    	    for( i = 0; i < size ; i++){
	    	    	     for (j=0; j < size; j++){
	    	    	    	     if(b[j] !=0)
	    	    	    	    	 continue;
	    	    	    	     if(a[j] == 0)
	    	    	    	    	 break;
	    	    	    	     a[j]--;
	    	    	     }
	    	    	     System.out.println(j);
	    	    	     b[j] = i+ 1;
	    	    }
	    }

		/**
		 * Unit Test
		 * @param args
		 */
	    public static void main(String[] args) {
			    int[] p = {4,6,2,5,3,1};
			    int[] a = new int[p.length];
			    createCantor(p,a,p.length);
			    for(int i:a){
//			    	    System.out.println(i);
			    }
			    int[] result = new int[p.length];
//			    cantorResume(a, result, p.length);
			    cantorResume2(a, result, p.length);
			    for(int i: result){
//			    	    System.out.println(i);
			    }
		}
	    
	    
}
