package com.neu.Array;

public class MultiplyArray {
	
	/**
	 * construct a multiple array
	 * @param a
	 * @return
	 */
	public static int[] multiply(int[] a){
		int len = a.length;
		int[] b = new int[len];
		int[] a1 = new int[len];
		int[] a2 = new int[len];
		
		for(int i=0; i < len; i++){
			if(i == 0){
				a1[i] = 1;
				continue;
			}
			a1[i] = a1[i-1] * a[i-1];
		}
		
		for(int i=len-1; i >=0; i--){
			if(i == len-1){
				a2[i] = 1;
				b[i] = a1[i] * a2[i];
				continue;
			}
			a2[i] = a2[i+1] * a[i+1];
			b[i] = a1[i] * a2[i];
		}
		return b;
	}
	
	public static void main(String[] args) {
		int a[] = {1,2,3};
		int b[] = multiply(a);
		for(int i : b){
			System.out.println(i);
		}
	}

}
