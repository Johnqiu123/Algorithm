package com.neu.Array;

import java.math.BigInteger;
import java.util.Scanner;

public class Yuanzhou {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
//		long result = 1+num*(num-1)/2+num*(num-1)*(num-2)*(num-3)/24 - num;

		BigInteger one = new BigInteger(1 + "");
		BigInteger two = new BigInteger(2 + "");
		BigInteger three = new BigInteger(3 + "");
		BigInteger twoFour = new BigInteger(24 + "");	
		BigInteger tempnum = new BigInteger(num+"");
		
		BigInteger result = one.add(tempnum.multiply(tempnum.subtract(one)).divide(two))
				            .add(tempnum.multiply(tempnum.subtract(one)).multiply(tempnum.subtract(two))
				            		.multiply(tempnum.subtract(three)).divide(twoFour)).subtract(tempnum);
		System.out.println(result);
	}
}
