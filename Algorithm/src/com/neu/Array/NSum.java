package com.neu.Array;

/**
 *  The <tt>NSum</tt> Java  provides a Binary search  method for 
 *  finding the sum of sub array which  is close to zero
 *  <p>
 *  <tt>Question:</tt>Given a diorderly array A[0...N-1] , then
 *   find the sum of sub array which  is close to zero
 *  
 *  @author Johnqiu
 */
public class NSum {
	
			public static void findNnumbers(int[] A, int size,  int sum){
						int[][] dp =new int[size][sum+1];
						
				        for (int i=1; i < size; i++){
				        	 dp[i][0]= 1;
				        	 for(int j=1; j <= sum; j++){
				                     if (j >= A[i]){
				                    	 System.out.println(j);
				                    	 dp[i][j] = dp[i-1][j] + dp[i][j-A[i]];
				                     }else if(j < A[i]){
				                    	 dp[i][j] = dp[i-1][j];
				                     }
				        	 }
				        }
				        
				        int result = dp[size-1][sum];
				        for(int i =0 ; i < size; i++){
				        	for (int j =0 ; j < sum+1; j++){
				        		    System.out.print(dp[i][j] + ",");
				        	}
				        	System.out.println(" ");
				        }
				        System.out.println(result);
			}
			
			public static void main(String[] args) {
				        int[] a = {1,2,3,4,5};
				        int sum = 10;
				        findNnumbers(a,a.length,sum);
			}
			

}
