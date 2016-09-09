package com.neu.Sorting;

import java.util.Random;

public class GetTopK {

	/*调整每个非叶子结点*/
	public void Sift(int R[], int low, int high)
	{
       System.out.println("Sift");
	    int i=low,j=2*i+1; // 左孩子结点位置
	    int temp=R[i];
	    while(j <= high)
	    {
	        if(j<high && R[j]>R[j+1]) ++j; // 比较左右孩子结点
	        if(temp > R[j])  // 交换
	        {
	            R[i]=R[j];
	            i=j;
	            j=2*i+1;
	        }else{
	            break;
	        }

	    }
	    R[i]=temp;
		 for (int m : R){
			 System.out.print(m+",");
		 }	
		 System.out.println(" ");
	}
	
	/*小顶堆：无需建树，直接用数组就可以排*/
	public int[] heapSort(int R[],int n)
	{
	    int i,temp;
	    int[] tmp = new int[n];
	    for(i = 0; i < n; i++){
	    	tmp[i] = R[i];
	    }
	    for (i=n/2-1;i>=0;i--)
	        Sift(tmp,i,n-1);
	    System.out.println("sort heap");

	    for(i=n-1; i >=1; i--)
	    {
	       temp=tmp[0];
	       tmp[0]=tmp[i];
	       tmp[i]=temp;
	       Sift(tmp,0,i-1);
	    }
	    return tmp;
	}
	
	public void getTopK(int[]a, int k, int size){
		int[] heap = heapSort(a, k);
		for(int i = k; i < size; i++){
			if(heap[k-1] < a[i]){
				heap[k-1] = a[i];
				heap = heapSort(heap, k);
			}
		}
		for(int j : heap){
			System.out.print(j + " ");
		}
		System.out.println("");
	}
	
	public int[] getRandomData(int size){
		int[] a = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++){
			a[i] = random.nextInt(size);
		}
		return a;
	}
	
	public static void main(String[] args) {
		GetTopK topK = new GetTopK();
		int[] array = topK.getRandomData(10000); // generate 10000 numbers
//		for(int i=0; i < 10; i++){
//			System.out.println(array[i]);
//		}
		int R[] = {1, 0, 3, 5, 8, 2, 6, 7, 4, 9, 10, 26, 35, 20, 30, 40};
		int n = R.length;
//		topK.heapSort(R, n);
		topK.getTopK(R, 5, n);
	}
}
