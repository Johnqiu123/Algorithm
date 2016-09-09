package com.neu.intelligence;

public class JumpFloorII {

	/**
	 * compute the sum of jump floor by dp array
	 * @param target
	 * @return
	 */
	public int jumpFloorII(int target){		
		
		if(target <= 0){
			return 0;
		}
		if(target == 1){
			return 1;
		}
		if(target == 2){
			return 2;
		}
		int[] dp = new int[target+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= target; i++){
			int temp = 0;
			for(int j = i-1; j > 0; j--){
				temp = temp + dp[j];
			}
			dp[i] = temp + 1;
		}
		return dp[target];
	}
	
	/**
	 * compute the sum of jump floor by 2^(n-1)
	 * @param target
	 * @return
	 */
	public int jumpFloorII2(int target){
		if(target <= 0){
			return 0;
		}
		int result = 1;
		while((--target)!=0){
			result *= 2;
		}
		return result;
	}
	
	/**
	 * compute the sum of jump floor by 1<<(n-1)
	 * @param target
	 * @return
	 */
	public int jumpFloorII3(int target){
		if(target <= 0){
			return 0;
		}
		return 1<<(target-1);
	}
	
	public static void main(String[] args) {
		JumpFloorII jf = new JumpFloorII();
//		int result = jf.jumpFloorII(3);
//		int result = jf.jumpFloorII2(4);
		int result = jf.jumpFloorII3(4);
		System.out.println(result);
	}
}
