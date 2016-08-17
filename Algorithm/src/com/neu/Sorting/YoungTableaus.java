package com.neu.Sorting;

import java.util.ArrayList;

public class YoungTableaus {
	
	private int row;
	private int col;
	private int[][] data;
	
	public YoungTableaus(int row, int col){
		this.row = row;
		this.col = col;
		data = new int[row][col];
		
		for(int i=0; i < row; i++){
			for(int j=0; j < col; j++){
				data[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	/**
	 * insert a value to the table
	 * @param value
	 * @return
	 */
	public boolean insert(int value){
		int tmprow = this.row - 1;
		int tmpcol = this.col - 1;

		// YoungTableaus is full
		if(data[tmprow][tmpcol] < Integer.MAX_VALUE){
			return false;   
		}
		
		data[tmprow][tmpcol] = value; 
		int r = tmprow;
		int c = tmpcol;
		while((tmprow >= 0) || (tmpcol >= 0)){
			print();
			System.out.println("");
			if((tmprow >= 1) && (data[tmprow-1][tmpcol] > data[r][c])){ // 按行走
				System.out.println("row");
				r = tmprow - 1;
				c = tmpcol;
			}
			if((tmpcol >= 1) && (data[tmprow][tmpcol - 1] > data[r][c])){ // 按列走
				System.out.println("col");
				r = tmprow;
				c = tmpcol - 1;
			}
			if((r == tmprow) && (c == tmpcol)) break;
			if(data[tmprow][tmpcol] < data[r][c]){
				int temp = data[r][c];
				data[r][c] = data[tmprow][tmpcol];
				data[tmprow][tmpcol] = temp;
			}
			tmprow = r;
			tmpcol = c;
		}
		return true;
	}
	
	/**
	 * find a value
	 * @param value
	 * @return
	 */
	public ArrayList<Integer> find(int value){
		if(data == null){
			return null;
		}
		int r = 0;
		int c = col - 1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while((r < row) && (c >=0)){
			if(data[r][c] == value){
				result.add(r);
				result.add(c);
				return result;
			}else if(data[r][c] < value){
				r++;
			}else{
				c--;
			}
		}
		return null;
	}
	
	/**
	 *  delete a data from array by its index
	 * @param r row index
	 * @param c column index
	 */
	public void delete(int r, int c){
		int tmpr = r;
		int tmpc = c;
		
		while((r < row) && (c < col)){
//			print();
//			System.out.println("");
			if(data[r][c] == Integer.MAX_VALUE){
				break;
			}
			if(r + 1 < row){
				tmpr = r + 1;
				tmpc = c;
			}
			if((c + 1 < col) && (data[r][c+1] < data[tmpr][tmpc])){
				tmpr = r;
				tmpc = c + 1;
			}
			if((tmpr == r) && (tmpc == c)){
				break;
			}
			data[r][c] = data[tmpr][tmpc];
			r = tmpr;
			c = tmpc;
		}
		data[row-1][col-1] = Integer.MAX_VALUE;
	}
	
	/**
	 * print a table
	 */
	public void print(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(data[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9, 16, 3, 2, 4, 8, 5, 14, 12};
		YoungTableaus ytable = new YoungTableaus(4,4);
		
		for(int i=0; i < a.length; i++){
			ytable.insert(a[i]);
		}
		ytable.insert(7);
//		ytable.print();
		
		/*****************Test 4********************/
//		ArrayList<Integer> result = ytable.find(12);
//		if(result != null){
//			for(int i=0; i < result.size(); i++){
//				System.out.print(result.get(i) + " ");
//			}
//			System.out.println("");
//		}
		/*****************Test 5********************/
		ytable.delete(0, 0);
		ytable.print();
	}
	

}
