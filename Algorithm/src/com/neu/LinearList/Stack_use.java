package com.neu.LinearList;

import java.io.EOFException;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *  The <tt>Stack_use</tt> Java  provides a Binary search  method for 
 *  finding the min Integer of the rotation  array
 *  <p>
 *  <tt>Question:</tt>Given a rotation array A[0...N-1] , then
 *   find the min Integer of the rotation  array
 *  
 *  @author Johnqiu
 */
public class Stack_use {

	/**
	 * return the longest parentheses
	 * @param p
	 * @return
	 */
	public static int getLongestParenthese(char[] p){
		int start = -1;   // key step
		int maxLen = 0;
		int size = p.length;
		
		Stack<Integer> stack = new Stack<Integer>(); // create size 10 of stack
		for(int i = 0; i < size; i++){
			char c = p[i];
			if(c == '('){
				stack.push(i);
			}else{
				if(stack.isEmpty()){
					start = i;
				}else{
					stack.pop();
					if(stack.isEmpty()){
						maxLen = Math.max(maxLen, i - start);
					}else{
						maxLen = Math.max(maxLen, i - stack.peek());
					}
					
				}
			}
		}
		return maxLen;
	}
	
	/**
	 *  compute value of reverse polish notation
	 * @param s  a set of character
	 * @return result
	 */
	public static int reversePolishNotation(char[] s){
		int size = s.length;
		Stack<Integer> stack = new Stack<Integer>();
		int temp = 0;
		
		int i;
		for(i=0; i<size; i++){
			if(!isOperator(s[i])){
				stack.push(Integer.parseInt(s[i]+""));
			}else{
				try{
					int a = stack.pop();
					int b = stack.pop();
					
					if(s[i] == '+'){
						temp = a + b;
					}else if(s[i] == '-'){
						temp = a - b;
					}else if(s[i] == '*'){
						temp = a * b;
					}else if(s[i] == '/'){
						temp = a / b;
					}
					
					stack.push(temp);
				}catch(EmptyStackException e){
					System.out.println("input wrong");
					return 0;
				}
			}
		}
		int answer = stack.pop();
		return answer;
	}
	
	/**
	 * judge a char whether is operator
	 * @param c
	 * @return
	 */
	public static boolean isOperator(char c){
		if(c=='+'||c=='-'||c=='*'||c=='/'){
			return true;
		}
		return false;
	}
	
	/**
	 * find the largest rectangle area
	 * @param height
	 * @return
	 */
	public static int largestRectangleArea(int[] height){
		int[] heights = new int[height.length+1];
		int i;
		for(i = 0; i < height.length; i++){
			heights[i] = height[i];
		}
		heights[height.length] = 0;
		int result = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(i=0; i < heights.length; ){
			if(stack.isEmpty()|| heights[i] > heights[stack.peek()]){
				stack.push(i);
				i++;
			}else{
				int temp = stack.pop();
			    result = Math.max(result, heights[temp] * (stack.isEmpty()? i: i-stack.peek()-1));	
			}
		}
		return result;
	}
	
	/**
	 * simulate queue push operation by stack
	 * @param stack
	 * @param data
	 * @return
	 */
	public static Stack<Integer> queue_push(Stack<Integer> stack, int data){
		stack.push(data);
		return stack;
	}
	
	/**
	 * simulate queue pop operation by stack
	 * @param stack
	 * @return
	 */
	public static int queue_pop(Stack<Integer> stack){
		if(stack.size() < 0){
			return 0;
		}
		Stack<Integer> stack2 = new Stack<Integer>();
		while(stack.size()> 0){
			stack2.push(stack.pop());
		}
		if(stack2.size() == 0){
			try {
				throw new EOFException("queue is empty");
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int result = stack2.pop();
		return result;
	}
	
	
	public static void main(String[] args) {
//		char[] c ={'(','(',')',')'};
//		int ans = getLongestParenthese(c);
//		System.out.println(ans);
		
		/*****************Test 2********************/
//		char[] s = {'2','1','+','3','*'};
//		int ans = reversePolishNotation(s);
//		System.out.println(ans);
		/*****************Test 3********************/
//		int[] height = {2,7,5,6,4};
//		int result = largestRectangleArea(height);
//		System.out.println(result);
		
		/*****************Test 4********************/
		int[] a = {2,7,5,6,4};
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0 ; i < a.length; i++){
			stack.add(a[i]);
		}
		int result = queue_pop(stack);
		System.out.println(result);
 	}
}
