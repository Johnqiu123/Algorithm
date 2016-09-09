package com.neu.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Consumption {
	
	/**
	 * create inner class comsumer
	 * @author Johnqiu
	 *
	 */
	class Comsumer{
		int num;
		int money;
		
		public Comsumer(int n, int v) {
			// TODO Auto-generated constructor stub
			this.num = n;
			this.money = v;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.money + "";
		}
	}
	
	/**
	 * Comsumer Comparator
	 * @author Johnqiu
	 *
	 */
	class ComsumerComparator implements Comparator<Comsumer>{

		@Override
		public int compare(Comsumer com1, Comsumer com2) {
			// TODO Auto-generated method stub
			return com1.money - com2.money;
		}
	}
	
	public static void main(String[] args) {
		Consumption con = new Consumption();
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt(); // table number
		int m = cin.nextInt(); // people number
		int[] tables = new int[n];
		ArrayList<Comsumer> comsumers = new ArrayList<Comsumer>();
		for(int i=0; i < n; i++){
			tables[i] = cin.nextInt();
		}
		for(int j=0; j < m; j++){
			int num = cin.nextInt();
			int money = cin.nextInt();
			Consumption.Comsumer c = con.new Comsumer(num, money);
			comsumers.add(c);
		}
		
		Arrays.sort(tables); // sort tables
		Collections.sort(comsumers, con.new ComsumerComparator()); // sort comsumers
		
		long count = 0L;
		for(int i=m-1; i >=0; i--){
			int j = 0;
			for(; j < n; j++){
				if(tables[j] >= comsumers.get(i).num){
					break;
				}
			}
			if(j < n){
			    count += comsumers.get(i).money;
			    tables[j] = 0;
			}
		}
		System.out.println(count);
	}
	
	

}
