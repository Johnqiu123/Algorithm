package com.neu.DynamicProgramming;

import java.util.Arrays;

/**
 *  The <tt>TaskArrange</tt> Java  provides a method for 
 *  arranging tasks
 *  <p>
 *  
 *  @author Johnqiu
 */
public class TaskArrange {
	
	/**
	 * judge whether tasks can be arranged
	 * @param n task number
	 * @param m space size
	 * @param R compute size
	 * @param O store size
	 * @return flag
	 */
	public boolean isTaskAble(int n, int m, int[] R, int[] O){
		TagTask[] tagtasks = new TagTask[n];
		for(int i=0; i < n; i++){
			TagTask tagtask = new TagTask();
			tagtask.setId(i);
			tagtask.setRO(R[i] - O[i]);
			tagtasks[i] = tagtask;
		}
		Arrays.sort(tagtasks, new TagTaskComparator()); // array sort by descending order
		
		int occupy = 0;
		boolean bOK = true;
		int k = 0;
		for(int i = 0; i < n; i++){
			k  = tagtasks[i].getId();
			System.out.println(k);
			if(occupy + R[k] > m){  // bigger that all space
				bOK = false;
				break;
			}
			occupy += O[k];
		}
		return bOK;
	}
	
	public static void main(String[] args) {
		TaskArrange taskarg = new TaskArrange();
		int n = 2;
		int m = 14;
	    int[] R = {10,8};
		int[] O = {5,6};
		boolean flag = taskarg.isTaskAble(n, m, R, O);
		System.out.println(flag);
	}
}
