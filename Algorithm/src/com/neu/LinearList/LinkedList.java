package com.neu.LinearList;

import java.util.Stack;

public class LinkedList {
	
	/**
	 * create a linear list by a array
	 * @param a array
	 * @return
	 */
	public static ListNode create(int[] a){
		ListNode list = new ListNode(-1);
		for(int i=0; i < a.length; i++){
			ListNode node = new ListNode(a[i]);
			node.next = list.next;
			list.next = node;
		}
		return list;
	}
	
	/**
	 * delete duplicate node (not include itself)
	 * @param list
	 * @return list
	 */
	public static ListNode deleteDuplicateNode(ListNode list){
		ListNode prenode = list.next;
		ListNode curnode;
		while(prenode != null){
			curnode = prenode.next;
			if(curnode != null && curnode.getData() == prenode.getData()){
				prenode.next = curnode.next;
			}else{
				prenode = curnode;
			}
		}
		return list;		
	}
	
	/**
	 * delete duplicate node (include itself)
	 * @param list
	 * @return
	 */
	public static ListNode deleteDuplicateNode2(ListNode list){
		ListNode prenode = list;
		ListNode curnode = prenode.next;
		ListNode nextnode;
		boolean flag;
		while(curnode != null){
			nextnode = curnode.next;
			flag = false;
			// delete from right to left
			while(nextnode != null && curnode.getData()== nextnode.getData()){
				prenode.next = nextnode;
				curnode = nextnode;
				nextnode = curnode.next;
				flag = true;
			}
			if(flag){
				prenode.next = nextnode;
			}else{
				prenode = curnode;
			}
			curnode = nextnode;
		}
		return list;
	}
	
	/**
	 * sum two lists
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static ListNode sum(ListNode list1, ListNode list2){
		ListNode listsum = new ListNode(-1);
		ListNode psum = listsum;
		ListNode p1 = list1.next;
		ListNode p2 = list2.next;
		ListNode temp;
		
		int carry = 0;  
		int value;
		while(p1 != null && p2 != null){
			value = p1.getData() + p2.getData() + carry;
			carry = value / 10;  // >10
			value %= 10;
			temp = new ListNode(value);
			psum.next = temp;
			
			p1 = p1.next;
			p2 = p2.next;
			psum = temp;
		}
		ListNode p = p1 != null? p1: p2; // get the longer list
		
		// rest list
		while(p != null){
			value = p.getData() + carry;
			carry = value / 10;
			value %= 10;
			temp = new ListNode(value);
			psum.next = temp;
			psum = temp;
			p = p.next;
		}	
		
		// handle carry
		if(carry != 0){
			psum.next = new ListNode(carry);
		}
		return listsum;
	}
	
	/**
	 * reverse a part of list
	 * @param list
	 * @param m
	 * @param n
	 * @return
	 */
	public static ListNode partReverse(ListNode list, int m, int n){
		if(m < 1 || m > n || n > len(list)){
			return null;
		}
		ListNode curNode = list;
		ListNode headNode = new ListNode(-1); 
		int i = 0;
		while(i < m){
			headNode = curNode;
			curNode = curNode.next;
			i++;
		}
		ListNode preNode = curNode;
		curNode = curNode.next;
		ListNode tempNode;
		for(;i < n; i++){
			tempNode = curNode.next;
			curNode.next = headNode.next;
			headNode.next = curNode;
			preNode.next = tempNode;
			curNode = tempNode;
		}
		return list;
	}
	
	/**
	 * split list into two part by a value, one part is smaller that value, the other is 
	 * bigger than value
	 * @param list
	 * @param value
	 * @return
	 */
	public static ListNode partition(ListNode list, int value){
		// create two list
		ListNode list1 = new ListNode(-1);
		ListNode list2 = new ListNode(-1);
		
		ListNode curnode = list.next;
		ListNode p1 = list1;
		ListNode p2 = list2;
		
		while(curnode != null){
			if(curnode.getData() < value){
				p1.next = curnode;
				p1 = curnode;
			}else{
				p2.next = curnode;
				p2 = curnode;
			}
			curnode = curnode.next;
		}
		p1.next = list2.next;
		p2.next = null;  // set null
		return list1;
		
	}
	
	public static ListNode findFirstSameNode(ListNode list1, ListNode list2){
		int lenlist1 = len(list1);
		int lenlist2 = len(list2);
		
		ListNode p1;
		ListNode p2;
		int temp = 0;
		if(lenlist1 > lenlist2){
			p1 = list2.next;
			p2 = list1.next;
			temp = lenlist2;
			lenlist2 = lenlist1;
			lenlist1 = temp;
		}else{
			p1 = list1.next;
			p2 = list2.next;
		}
		
		// move longer list
		for(int i=0; i < lenlist2-lenlist1; i++){
			p2 = p2.next;
		}
		while(p1 != null){
			if(p1.getData() == p2.getData()){
				return p1;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return null;
	}
	
	/**
	 * get the length of list
	 * @param list
	 * @return
	 */
	public static int len(ListNode list){
		ListNode p = list.next;
		int length = 0;
		while(p != null){
			length ++;
			p = p.next;
		}
		return length;
	}
	/**
	 * print list
	 * @param list
	 */
	public static void print(ListNode list){
		ListNode p = list.next; // not include head node
		while(p != null){
			System.out.print(p + " ");
			p = p.next;
		}
		System.out.println("");
	}
	
	/**
	 * reverse print list
	 * @param list
	 */
	public static void reverseprint(ListNode list){
		ListNode p = list.next; // not include head node
		Stack<ListNode> stack = new Stack<ListNode>();
		while(p != null){
			stack.push(p);
			p = p.next;
		}
		while(!stack.isEmpty()){
			ListNode node = (ListNode) stack.pop();
			System.out.print(node + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
//		int[] a = {1,7,4,0,9,4}; // 174094
//		int[] b = {8,2,4,5,5,1,7,1}; // 82455171
//		ListNode list1 = create(a);
//		ListNode list2 = create(b);
//		ListNode result = sum(list1,list2);
//		print(result);
//		reverseprint(result);
		/*****************Test 1********************/
//		int length = len(result);
//		System.out.println(length);
		/*****************Test 2********************/
//		int[] c = {64,62,58,78,24,69,0,34,67,41};
//		int[] c = {41,67,34,0,69,24,78,58,62,64};
//		ListNode list = create(c);
//		print(list);
//	    ListNode result = partReverse(list,4,8);
//		print(result);
		/*****************Test 2********************/
//		int[] c = {2,3,3,5,7,8,8,8,9,9,10};
//		ListNode list = create(c);
//		print(list);
//		ListNode result = deleteDuplicateNode(list);
//		print(result);
//		ListNode result2 = deleteDuplicateNode2(list);
//		print(result2);
		
		/*****************Test 3********************/
//		int[] c = {2,5,2,3,4,1};
//		int x = 3;
//		ListNode list = create(c);
//		print(list);
//		ListNode result = partition(list,x);
//		print(result);
		
		/*****************Test 4********************/
		int[] A = {8,6,4,3};
		int[] B = {8,6};
		ListNode alist = create(A);
		ListNode blist = create(B);
		print(alist);
		print(blist);
		ListNode result = findFirstSameNode(alist,blist);
		System.out.println(result);		
	}
}
