package com.neu.Sorting;

public class BucketSort {

	  public static void bucketSort(int R[], int min, int max){
		    int n = R.length;
		    int[] tmp = new int[n];
		    // buckets数组相当于定义了max - min个桶
		    // buckets数组用于记录待排序元素的信息
		    int[] buckets = new int[max - min]; 
		    // 计算每个元素在序列出现的次数
		    for (int i=0; i < n; i++){
		    	 // buckets数组记录了R的数据出现的次数
		    	buckets[R[i] - min] ++;
		    }
		    // 计算“落入”各桶内的元素在有序序列中的位置
		    for(int i =1; i < max - min; i++){
		    	buckets[i] = buckets[i] + buckets[i-1];
		    }
		   System.arraycopy(R, 0, tmp, 0, n);  //复制数据
		   for(int k=n-1; k >= 0; k--){
			   R[--buckets[tmp[k]- min]] = tmp[k];
		   }
	  }
		public static void main(String[] args) {
			 int R[] = {0,6,4,5,7,8};
			 bucketSort(R, 0,9);
			 for (int i : R){
				 System.out.println(i);
			 }	
	}
}
