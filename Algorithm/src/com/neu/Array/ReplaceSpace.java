package com.neu.Array;

public class ReplaceSpace {

	/**
	 * replace spaces of a string by '%20'
	 * @param str
	 * @return
	 */
	public static String replaceSpace(StringBuffer str) {
		if(str == null || str.length()<= 0){
			return "";
		}
		int originLen = str.length();
		int spacenum = 0;
		for(int i = 0 ; i < originLen; i++){
			if(str.charAt(i) == ' '){
				spacenum++;
			}
		}
		int newLen = originLen + spacenum * 2; // the length of new string 
		str.setLength(newLen); // enlarge the length of string
		
		int indexOfOriginal = originLen - 1;
		int indexOfNew = newLen - 1;
		while(indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){
			if(str.charAt(indexOfOriginal) == ' '){ // meet " "
				str.setCharAt(indexOfNew--, '0');
				str.setCharAt(indexOfNew--, '2');
				str.setCharAt(indexOfNew--, '%');
			}else{
				str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
			}
			--indexOfOriginal;
		}
    	return str.toString();
    } 
	
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("We are happy.");
		String result = replaceSpace(str);
		System.out.println(result);
	}
}
