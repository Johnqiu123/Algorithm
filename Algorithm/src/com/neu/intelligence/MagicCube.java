package com.neu.intelligence;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * <tt>Question:</tt>Magic cube is a cube(M * M * M) which contains a integer number(0 <= number < P) in each cell(So you know there are M ^ 3 numbers).
 *Alice have one big cube and N smaller cubes(each small cube is unique).
 *The cube is magic since when you put a small cube in bigger one, the number in the same location will add up and mod P.
 *Your job is to determine the location of each small cube, so that we can make every number in big cube equal 0 after putting all the small cubes.
 * @author Johnqiu
 */
public class MagicCube {

	final static char[] digits = {
			  '0' , '1' , '2' , '3' , '4' , '5' ,
			  'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
			  'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
			  'o' , 'p' , 'q' , 'r' , 's' , 't' ,
			  'u' , 'v' , 'w' , 'x' , 'y' , 'z'
	};
	
	public static String addZeroForNum(String str, int strLength) {
	     int strLen = str.length();
	     StringBuffer sb = null;
	     while (strLen < strLength) {
	           sb = new StringBuffer();
	           sb.append("0").append(str);// add zero
	           str = sb.toString();
	           strLen = str.length();
	     }
	     return str;
	 }
	public static String toCustomNumericString(int i, int system) {
		  long num = 0;
		  if (i < 0) {
		   num = ((long)2 * 0x7fffffff) + i + 2;
		  } else {
		   num = i;
		  }
		  char[] buf = new char[32];
		  int charPos = 32;
		  while ((num / system) > 0) {
		   buf[--charPos] = digits[(int)(num % system)];
		   num /= system;
		  }
		  buf[--charPos] = digits[(int)(num % system)];
		  return new String(buf, charPos, (32 - charPos));
	} 
	
	public static ArrayList getPoi(int m, int n, int p, int[] cube, ArrayList lists){
		ArrayList result = new ArrayList();
		for(int i =0; i < lists.size(); i++){
			ArrayList list = (ArrayList) lists.get(i);
			for(int j = 1;  j < list.size(); j++){
				int tmp = (int) list.get(j);
				for(int k = 0; k < cube.length; k++){
					if(cube[k] != 0){
						int value = (tmp + cube[k]) % p;
						if(value != 0){
							continue;
						}else{
							String res = toCustomNumericString(k,m);
							res = addZeroForNum(res,3);
							result.add(res);
							break;
						}
					}		
				}
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int m = cin.nextInt();
		int n = cin.nextInt();
		int p = cin.nextInt();
		
		int len = m*m*m;
		int[] cube = new int[len];
		
		// store cube number
		for(int i = 0; i < len; i++){
			cube[i] = cin.nextInt();
		}
		
		// store small cube
		ArrayList lists = new ArrayList();
		for(int j = 0; j < n; j++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			int msmall = cin.nextInt();
			int lensmall = msmall*msmall*msmall;
			list.add(msmall);
			for(int k = 0; k < lensmall; k++){
				list.add(cin.nextInt());
			}
			lists.add(list);
		}
		
		ArrayList result = getPoi(m,n,p,cube,lists);
		for(int k = 0; k < result.size(); k++){
			String anw = (String) result.get(k);
			for(int i=0; i < anw.length(); i++){
				System.out.print(anw.charAt(i)+" ");
			}
			System.out.println("");
		}
		
		/****************************************/
//		String res  = toCustomNumericString(2,3);
//		System.out.println(res);
		
//		int i = 1;
//		String k = String.format("%03d", i+"");
//		System.out.println(k);
	}
}
