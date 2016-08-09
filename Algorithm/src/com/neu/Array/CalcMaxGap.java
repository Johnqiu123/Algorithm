package com.neu.Array;

/**
 *  The <tt>CalcMaxGap</tt> Java  provides a Binary search  method for 
 *  finding the min Integer of the rotation  array
 *  <p>
 *  <tt>Question:</tt>Given a rotation array A[0...N-1] , then
 *   find the min Integer of the rotation  array
 *  
 *  @author Johnqiu
 */
public class CalcMaxGap {

	/**
	 * Find the max gap of  a  array
	 * @param a   Array
	 * @param size   the size of array
	 * @return  the first miss number
	 */
	    public static int calcMaxGap(int[]A, int size){
	    	 	TagSBucket[] tBuckets = new TagSBucket[size];  	
	    	 	for (int i=0; i < size; i++){
	    	 		TagSBucket tBucket = new TagSBucket();
	    	 		tBuckets[i] = tBucket;
	    	 	}
	            int nMax = A[0];
	            int nMin = A[0];
	            int i ;
	            
	            // get max and min
	            for (i=0; i < size; i++){
	            	    if (nMax < A[i]){
	            	    	    nMax = A[i];
	            	    }else if (nMin > A[i]){
	            	    	    nMin = A[i];
	            	    }
	            }
	            
	            //add num
	            int delta = nMax - nMin;
	            int nBucket;
	            for ( i = 0; i < size; i++){
	            	    nBucket = (A[i] - nMin) * size / delta;
	            	    System.out.println(nBucket+"---nB");
	            	    System.out.println(A[i]+"--A[i]");
	            	    if (nBucket >= size){
	            	    	   nBucket = size -1;
	            	    }
	            	    tBuckets[nBucket].Add(A[i]);
	            }
	            
	            // compute gap
	            i = 0;
	            int nGap = delta / size;
	            int gap;
	            for (int j=1; j < size; j++){
	            	   if (tBuckets[j].isbValid()){
	            		      gap = tBuckets[j].getnMin() - tBuckets[i].getnMax();
	            		      if(nGap < gap){
	            		    	      nGap = gap;
	            		      }
	            		      i = j;
	            	   }
	            }
	            return nGap;
           }

		/**
		 * Unit Test
		 * @param args
		 */
	    public static void main(String[] args) {
			   int[] a = {1,7,14,9,4,13};
			   int m = calcMaxGap(a, a.length);
			   System.out.println(m);
		}	    
}
