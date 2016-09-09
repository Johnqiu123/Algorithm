package com.neu.Sorting;

public class BInsertSort {

	public void bInsertSort(int R[],int n)
	{
		    int i,j;
		    int temp, high, low, mid;
		    for (i=1; i<n; ++i)
		    {
		    	System.out.println("i="+i);
		        temp=R[i];
		        high=i-1;
		        low=0;
		        mid=0;
		        while(low <=high)
		        {
		            mid = (high + low)/2;
		            if(R[mid]>temp)
		            {
		              high=mid-1;
		            }
		            else if(R[mid]<temp)
		            {
		                low=mid+1;
		            }
		        }
		        System.out.println("mid="+mid);
		        for (j=i-1; j >=mid; --j)
		        {
		            	R[j+1] = R[j];
		        }
		        R[low]=temp;
				 for (int k : R){
					 System.out.print(k);
				 }	
				 System.out.println(" ");
		    }
	}
	
	public static void main(String[] args) {
		BInsertSort sort =new BInsertSort();
		 int R[] = {0,6,4,5,7,8};
		 int n = 6;
		 sort.bInsertSort(R, n);
		 for (int i : R){
			 System.out.println(i);
		 }			 
	}
}
