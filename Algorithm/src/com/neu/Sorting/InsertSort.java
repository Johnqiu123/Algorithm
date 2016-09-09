package com.neu.Sorting;

public class InsertSort {

		public void insertSort(int R[],int n){
			    int i,j;
			    int temp;
			    for (i=1; i < n; i++){
			        temp = R[i];
			        j = i-1;
			        while(j>=0 && temp < R[j]){
			            R[j+1] = R[j];
			            --j;
			        }
			        R[j+1]=temp;
			    }
		}
		
		public static void main(String[] args) {
			 InsertSort sort =new InsertSort();
			 int R[] = {2,6,4,5,7,8};
			 int n = 6;
			 sort.insertSort(R, n);
			 for (int i : R){
				 System.out.println(i);
			 }			 
		}
}
