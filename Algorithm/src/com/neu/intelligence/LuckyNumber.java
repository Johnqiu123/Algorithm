package com.neu.intelligence;

import java.util.*;

public class LuckyNumber{
	
      /**
       * 求出十进制整数的每位之和	
       * @param a
       * @return
       */
      public int f(int a){
            int s = 0;
            while(a > 0){
                  s = s + a % 10;
                  a = a / 10;
            }
            return s;
      }
      
//      public int g(int a){
//         int s = 0;
//         String b = Integer.toBinaryString(a);
//         char[] binary = b.toCharArray();
//         for(int i=0; i < binary.length; i++){
//               s = s + Integer.parseInt(String.valueOf(binary[i]));
//         }
//         return s;
//      }
      
      /**
       * 
       * @param n
       * @return
       */
      public int g(int n){
    	  int count = 0;
    	  while(n != 0){
    		  ++count;
    		  n = (n-1)&n;
    	  }
    	  return count;
      }
       
      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            while(scan.hasNext()){
                  int n = scan.nextInt();
                  LuckyNumber main = new LuckyNumber();
                  while(n --> 0){
                        int a = scan.nextInt();
                        int sum = 0;    
                        long starTime=System.currentTimeMillis();
                        for(int i=1; i <= a; i++){
                            if(main.f(i) == main.g(i)){
                              sum++;
                            }
                        }
                        System.out.println(sum);
                        long endTime=System.currentTimeMillis();
//                        System.out.println(starTime);
//                        System.out.println(endTime);
              		    long Time=endTime-starTime;
              		    System.out.println(Time);
                   }
            }
    	  
//    	  Main main = new Main();
//    	  System.out.println(main.g(123));
      }
}           