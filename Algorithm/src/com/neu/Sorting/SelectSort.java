package com.neu.Sorting;

public class SelectSort {

	public void selectSort(int R[], int n)
	{
	    int i,j,k; //i表示当前位置，k表示最小值的位置
	    int temp;
	    for(i=0; i<n; i++)
	    {
	        k=i;
	        for(j=i+1; j<n; j++)
	        {
	            if(R[k]>R[j])
	            {
	                k = j;
	            }
	        }
	        temp=R[i];
	        R[i]=R[k];
	        R[k]=temp;
	    }
	}
	
	public static void main(String[] args) {
		     SelectSort sort =new SelectSort();
			 int R[] = {0,6,4,5,7,8};
			 int n = 6;
			 sort.selectSort(R, n);
			 for (int i : R){
				 System.out.println(i);
			 }	
	}

}
