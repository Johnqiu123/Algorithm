package com.neu.Sorting;

/**
 *  The <tt>InversionPair</tt> Java  provides a merge sort  method for 
 *  finding the number of inversion pairs
 *  <p>
 *  <tt>Question:</tt>Given a rotation array A[0...N-1] , then
 *   find the min Integer of the rotation  array
 *  
 *  @author Johnqiu
 */
public class InversionPair {

	  private int count;
	  
	  public InversionPair(){
		  count = 0;
	  }
	  /**
	   * merge sort algorithm
	   * @param R  array
	   * @param l  left index
	   * @param r  right index
	   */
	  public void mergeSort(int R[], int l ,int r){
		    if (l < r){
		    	  // 找出中间索引
		    	  int center = (l + r) / 2;
		    	  mergeSort(R, l, center);  // 左边数组排序
		    	  mergeSort(R, center+1, r);  // 右边数组排序
		    	  merge(R, l, center, r); // 合并
		    }
	  }
	  
	  /**
	   * 
	   * @param R array
	   * @param l left index
	   * @param center  middle index
	   * @param r right index
	   */
	  public void merge(int R[], int l, int center, int r){
		   int[] tempR = new int[R.length];
		   int rbegin = center + 1; // 右边数组第一位
		   int tmpIndex = l;  // 临时数组索引
		   int newIndex  = l;  // 新数组索引

		   while(l <= center && rbegin <= r){
		       // 获取两个数组最小值放入临时数组
		        if(R[l] < R[rbegin]){
		            tempR[tmpIndex++] = R[l++];
		        }else{
		        	count += center - l + 1;
		            tempR[tmpIndex++] = R[rbegin++];
		        }
		   }
		   // 将剩余的数放入临时数组
		   while(rbegin <= r){
		       tempR[tmpIndex++] = R[rbegin++];
		   }
		   while(l <= center){
		       tempR[tmpIndex++] = R[l++];
		   }
		   // 更新原数组
		   while(newIndex <= r){
		       R[newIndex] = tempR[newIndex];
		       newIndex++;
		   }
	 }
	  /**
	   * use bruteForce algorithm
	   * @param R
	   */
	  public void bruteForce(int[] R){
		 int len = R.length;
		 for(int i=0 ; i < len; i++){
			 for(int j = i+1; j < len; j++){
				 if(R[j] < R[i]){
					 count ++;
				 }
			 }
		 }
	  }
	  
	  
	public static void main(String[] args) {
		 InversionPair inpair = new InversionPair();
		 int R[] = {3,56,2,7,45,8,1};
		 inpair.mergeSort(R, 0, R.length-1);
		 for (int i : R){
			 System.out.print(i + " ");
		 }
		 System.out.println("");
		 System.out.println(inpair.count);
		 
		 /*****************Test 2********************/
//			 inpair.bruteForce(R);
//			 System.out.println(inpair.count);
    }
}
