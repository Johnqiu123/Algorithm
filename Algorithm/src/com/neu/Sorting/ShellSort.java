package com.neu.Sorting;
public class ShellSort {
	
		public static void sellSort(int R[], int n){
			int h = 1;// h 变量保存可变增量
			// 按h *３＋１得到增量序列的最大值
			while(h <= n/3)
			{
				h = h *3+1;
			}			
			while(h>0)
			{
				System.out.println(h);
				for(int i = h; i < n; i++)
				{
					// 当整体后移时，保证data[i]的值不会丢失
					int tmp = R[i];
					// i索引处的值已经比前面所有值都大，表明已经有序，无需插入
					// i-1索引之前的数据已经有序的，i-1索引出元素的值就是最大值
					if(R[i] < R[i-h])
					{
						int j = i-h;
						// 整体后移h格
						for(; j>=0 && R[j]>tmp;j-=h)
						{
							R[j+h] = R[j];
						}
						// 最后将tmp的值插入合适位置
						R[j+h] = tmp;
					}
				}
				h = (h-1)/3;
			}
		}
		public static void main(String[] args) {
			 int R[] = {49,38,65,97,76,13,27,49,55,04};
			 int n = 10;
			 sellSort(R, n);
			 for (int i : R){
				 System.out.println(i);
			 }	
		}
}
