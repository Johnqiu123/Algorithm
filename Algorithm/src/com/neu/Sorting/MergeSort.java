package com.neu.Sorting;

public class MergeSort {
	
	  /**
	   * merge sort algorithm
	   * @param R  array
	   * @param l  left index
	   * @param r  right index
	   */
	  public static void mergeSort(int R[], int l ,int r){
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
	  public static void merge(int R[], int l, int center, int r){
		   int[] tempR = new int[R.length];
		   int rbegin = center + 1; // 右边数组第一位
		   int tmpIndex = l;  // 临时数组索引
		   int newIndex  = l;  // 新数组索引

		   while(l <= center && rbegin <= r){
		       // 获取两个数组最小值放入临时数组
		        if(R[l] < R[rbegin]){
		            tempR[tmpIndex++] = R[l++];
		        }else{
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

 
		public static void main(String[] args) {
			 int R[] = {0,6,4,5,7,8};
			 mergeSort(R, 0, R.length-1);
			 for (int i : R){
				 System.out.println(i);
			 }	
	}
}
