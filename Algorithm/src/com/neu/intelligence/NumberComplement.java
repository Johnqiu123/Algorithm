package com.neu.intelligence;

public class NumberComplement {

	public static int getIntegerComplement(int n){
		String tempWait = Integer.toBinaryString(n);
	    StringBuffer compTmp = new StringBuffer();
	    for(int i = 0; i < tempWait.length(); i++){
	    	if(tempWait.charAt(i) == '0'){
	    		compTmp.append("1");
	    	}else{
	    		compTmp.append("0");
	    	}
	    }
	    int result = Integer.parseInt(compTmp.toString(),2);
		return result;
	}
	
	public static void main(String[] args) {
		int n = 50;
		int r = getIntegerComplement(50);
		System.out.println(r);
	}
}
