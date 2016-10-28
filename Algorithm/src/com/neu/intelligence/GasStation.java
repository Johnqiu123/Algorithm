package com.neu.intelligence;

public class GasStation {

	/**
	 * find first gas station which satisfy content 
	 * @param gas 加油量
	 * @param cost 消耗量
	 * @return
	 */
	public int findStart(int[] gas, int[] cost){
		int n = gas.length;
		int sum = 0; // 统计相差值
		for(int i = 0; i < n; i++){
			sum += gas[i] - cost[i];
		}
		if(sum  <  0) return -1;
		int rest = 0; // 剩余油量
		for(int i= 0; i < n; i++){
			rest = gas[i] - cost[i];
			if(rest >= 0){
				int j = i+1;
				for(; j < n; j++){  // from i to n-1
					rest += gas[j] - cost[j];
					if(rest < 0) break;
				}
				if(j == n){ // fron 0 to i-1
					int k = 0;
					for(;k < i; k++){
						rest += gas[k] - cost[k];
						if(rest < 0) break;
					}
					if(k == i){
						return i;
					}
				}
			}else{
				continue;  // next start
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		GasStation gs = new GasStation();
		int[] gas = {1,2,3,4,5,6};
		int[] cost = {1,3,3,4,5,5};
		int result = gs.findStart(gas, cost);
		System.out.println(result);
	}
}
