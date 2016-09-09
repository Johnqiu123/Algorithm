package com.neu.intelligence;

/**
 *  The <tt>JumpFloor</tt> Java  provides a method for 
 *  finding the min Integer of the rotation  array
 *  <p>
 *  <tt>Question:</tt>一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *  
 *  @author Johnqiu
 */
public class JumpFloor {

	/**
	 * 转换成Fibonacci数列来计算
	 * @param target
	 * @return
	 */
	public int jumpFloor(int target) {
		if(target <= 0){
			return 0;
		}
		if(target == 1){
			return 1;
		}
		if(target == 2){
			return 2;
		}
		
		int fibNMinusOne = 2;
		int fibNMinusTwo = 1;
		int fibN = 0;
		for(int i = 3; i <= target; i++){
			fibN = fibNMinusOne + fibNMinusTwo;
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		return fibN;
    }
	
	public static void main(String[] args) {
		JumpFloor jf = new JumpFloor();
		int result = jf.jumpFloor(4);
		System.out.println(result);
	}
}
