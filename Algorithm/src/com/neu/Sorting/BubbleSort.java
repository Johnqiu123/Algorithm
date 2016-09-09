package com.neu.Sorting;

public class BubbleSort {

	public void bubbleSort(int R[], int n)
	{
		    int i,j,flag,temp;
		    for(i=0; i<n-1; i++)
		    {
		        flag = 0;
		        for(j=0; j<n-1-i;j++)
		        {
		            if(R[j]>R[j+1])
		            {
		                temp = R[j];
		                R[j] = R[j+1];
		                R[j+1] = temp;
		                flag = 1;
		            }
		        }
		        if(flag==0)
		        {
		            break;
		        }
		    }
	}
	
	public static void main(String[] args) {
		BubbleSort sort =new BubbleSort();
		 int R[] = {9,6,4,5,7,8};
		 int n = 6;
		 sort.bubbleSort(R, n);
		 for (int i : R){
			 System.out.println(i);
		 }	
	}

}
