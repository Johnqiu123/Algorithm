package com.neu.Sorting;

public class QuickSort {

		public void quickSort(int R[],int l,int r)
		{
			    int temp;
			    int i=l, j=r;
			    if(l < r)
			    {
			        temp = R[l]; // 以左边的一个数作为枢轴
			        while(i!=j)
			        {
			            while(j > i && R[j] > temp) --j;
			            if(i < j)
			            {
			                R[i] = R[j];
			                ++i;
			            }
			            while(j > i && R[i] < temp) ++i;
			            if(i < j)
			            {
			                R[j] = R[i];
			                --j;
			            }
			        }
			        R[i] = temp;
			        quickSort(R, l,i-1);
			        quickSort(R,i+1,r);
			    }
		}
		
		public static void main(String[] args) {
				QuickSort sort =new QuickSort();
				 int R[] = {0,6,4,5,7,8};
				 sort.quickSort(R, 0, R.length-1);
				 for (int i : R){
					 System.out.println(i);
				 }	
		}

}
