package com.neu.Array;

public class FindDuplicateInteger {
	
	/**
	 * find duplicate integer in array
	 * @param a array
	 * @return
	 */
	public static int duplicateInteger(int a[]){
		int len = a.length;
		if(a == null || len <= 0){
			return -1;
		}
		for(int i = 0; i < len; i++){
			while(a[i] != i){
				if(a[i] == a[a[i]]){
					return a[i];
				}
				// swap value
				int temp = a[i];
				a[i] = a[temp];
				a[temp] = temp;
			}		
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,0,2,5,3};
		int result  = duplicateInteger(a);
		System.out.println(result);
	}

}
