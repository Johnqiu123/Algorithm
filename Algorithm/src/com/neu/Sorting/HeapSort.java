package com.neu.Sorting;
public class HeapSort {

		/*调整每个非叶子结点*/
		public void Sift(int R[], int low, int high)
		{
	       System.out.println("Sift");
		    int i=low,j=2*i+1; // 左孩子结点位置
		    int temp=R[i];
		    while(j <= high)
		    {
		        if(j<high && R[j]<R[j+1]) ++j; // 比较左右孩子结点
		        if(temp<R[j])  // 交换
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
		
		/*大顶堆：无需建树，直接用数组就可以排*/
		public void heapSort(int R[],int n)
		{
		    int i,temp;
		    for (i=n/2-1;i>=0;i--)
		        Sift(R,i,n-1);
		    System.out.println("sort heap");

		    for(i=n-1; i >=1; i--)
		    {
		       temp=R[0];
		       R[0]=R[i];
		       R[i]=temp;
		       Sift(R,0,i-1);
		    }
		}
		
		public static void main(String[] args) {
			 HeapSort sort =new HeapSort();
			 int R[] = {4,1,3,16,9,10,14,8,7};
			 int n = 9;
			 sort.heapSort(R, n);
			 for (int i : R){
				 System.out.print(i + " ");
			 }	
			 System.out.println("");
	    }

}
