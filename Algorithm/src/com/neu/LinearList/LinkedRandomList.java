package com.neu.LinearList;

public class LinkedRandomList {

	public ListRandomNode deepCopy(ListRandomNode head){
		ListRandomNode p = head;
		ListRandomNode q = head.next;
		ListRandomNode newNode = null;
		
		// step1: 复制结点，如A-B-C 变成 A-A’-B-B’-C-C’
		while(p != null){
			int x = p.val;
			newNode = new ListRandomNode(x);
			newNode.next = p.next;
			p.next = newNode;
			
			p = q;
			q = q.next;
		}
		
		// step2: 依次遍历节点A,B,C，将这些节点的随机指针与A’B’C’一致
		p = head;
		q = p.next;
		while(q != null){
			if(p.random != null){
				q.random = p.random.next;
			}
			if(q.next == null){
				break;
			}
			p = q.next;
			q = p.next;
		}
		
		//step3:分离A-B-C和A’B’C’，A’B’C’便是需要求得链表
		newNode = head.next;
		p = head;
		q = p.next;
		while(q != null){
			p.next = q.next;
			if(q.next == null){
				break;
			}
			q.next = p.next.next;
			p = p.next;
			q = q.next;
		}
		return newNode;
	}
}
