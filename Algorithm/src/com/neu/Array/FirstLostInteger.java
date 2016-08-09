package com.neu.Array;

/**
 *  The <tt>FirstLostInteger</tt> Java  provides a static method for 
 *  finding the fist miss Integer of the array
 *  <p>
 *  <tt>Question:</tt>Given a disorderly array A[0...N-1] , then
 *   find the fist miss Integer of the array
 *  
 *  @author Johnqiu
 */
public class FirstLostInteger {
	
	/**
	 * Find the fist miss Integer of the array
	 * @param a   Array
	 * @param size   the size of array
	 * @return  the first miss number
	 */
	public static int firstMissNumber(int[]a, int size){
		 int[] temp = new int[size+1];
		 for (int i=0; i < size; i++){
			 temp[i+1] = a[i];
		 }
		 
		 int j = 1;
		 while(j <= size){
			 // three conditions
			  if (temp[j] == j){   
				  j++;
			  }else if((temp[j] < j) || (temp[j] > size) || (temp[j] == temp[temp[j]])){
				  temp[j] = temp[size];
				  size--;
			  }else{ // temp[j] > j
				  // swap value
				  int tempV =  temp[temp[j]];
				  temp[temp[j]] =  temp[j];
				  temp[j] = tempV;
			  }
			  
			  for (int k=0; k <= size; k++){
				  System.out.print(temp[k]+",");
			  }
			  System.out.println(" ");
		 }
		 return j;
	}
	
	/**
	 * Unit Test
	 * @param args
	 */
	public static void main(String[] args) {
		   int[] a = {3,5,1,2,-3,7,14,8};
		   int m = firstMissNumber(a, a.length);
		   System.out.println(m);
	}
}
