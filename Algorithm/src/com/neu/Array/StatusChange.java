package com.neu.Array;

public class StatusChange {

	public int[] getStatus(int[] staArray, int day){
		if(staArray.length > 8 || staArray.length < 0 || day < 0){
			return null;
		}
		
		int len = staArray.length;
		int[] status = new int[8];
		for(int i = 0; i < day; i++){
			for(int j = 0; j < len; j++){
				if(j == 0){
					if(staArray[j+1] == 1){
						status[j] = 1;
					}else{
						status[j] = 0;
					}
				}else if(j == len-1){
					if(staArray[j-1] == 1){
						status[j] = 1;
					}else{
						status[j] = 0;
					}
				}else{
					if(staArray[j-1] == staArray[j+1]){
						status[j] = 0;
					}else{
						status[j] = 1;
					}
				}
			}
		}
		return status;
	}
	
	public static void main(String[] args) {
		StatusChange sc = new StatusChange();
		int[] staArray = {1,0,0,0,1,1,0,1};
		int[] result = sc.getStatus(staArray, 1);
		for(int i : result){
			System.out.print(i + " ");
		}
		System.out.println("");
	}
}
