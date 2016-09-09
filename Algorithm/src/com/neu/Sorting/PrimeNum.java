package com.neu.Sorting;

import java.util.Vector;
public class PrimeNum {

	private boolean[] a;
	
	public PrimeNum(){
		a = null;
	}
	
	public void eratosthenes(){
		int len = a.length;
		a[1] = false; // not use a[0]
		int i;
		for(i=2; i<len; i++){
			a[i] = true;
		}
		int p = 2; // first sieve
		int j = p*p;
		while(j < len){
			while(j <  len){
				a[j] = false;
				j += p;
			}
			p++;
			while(!a[p]){ // find next prime number
				p++;
			}
			j = p*p;
		}
	}
	
	public int find(int[] array, int value){
		int low = 0;
		int high = array.length -1;
		int mid = 0;
		while(low <= high){
			mid = (low + high) / 2;
			if(array[mid] == value){
				return mid;
			}
			if(array[mid] > value){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return low;
	}
	
	public int twoSum(int[] array, int index, int sum){
		int low = 0;
		int high = index - 1;
		int result;
		int times = 0;
		
		while(low < high){
			result = array[low] + array[high];
			if(result == sum){
				times++;
				low++;
				high--;
			}else if(result > sum){
				high--;
			}else{
				low++;
			}
		}
		return times;
	}
	
	public static void main(String[] args) {
		boolean[] b = new boolean[1000001];
//		boolean[] b = new boolean[11];
		PrimeNum pn = new PrimeNum();
		pn.a = b;
		pn.eratosthenes();
		Vector<Integer>  vec = new Vector<Integer>();
		
		// get all prime numbers in 1000000
		for(int i=0; i < pn.a.length; i++){
			if(pn.a[i]){
				vec.add(i);
			}
		}
		
		// change vector to array
		int[] k = new int[vec.size()];
		for(int i = 0; i < vec.size(); i++){
			k[i] = vec.get(i);
//			System.out.print(k[i] + " ");
		}
//		System.out.println("");
		
		int j;
		int m = 0;
		int f = 0;
		// use twosum method to find a number can be divided into 
		//how many pair numbers' sum 
		for(int i=2; i < pn.a.length; i++){
			j = pn.find(k, i);
			j = pn.twoSum(k, j, i);
			if(m < j){
				m = j;
				f = i;
			}
//			System.out.println(i + ":" + j);
		}
		System.out.println(f + " : " + m);
		
	}
	

	
}
