package com.neu.LinearList;

public class LinkedRandomList {

	public ListRandomNode deepCopy(ListRandomNode head){
		ListRandomNode p = head;
		ListRandomNode q = head.next;
		ListRandomNode newNode = null;
		
		// step1: ���ƽ�㣬��A-B-C ��� A-A��-B-B��-C-C��
		while(p != null){
			int x = p.val;
			newNode = new ListRandomNode(x);
			newNode.next = p.next;
			p.next = newNode;
			
			p = q;
			q = q.next;
		}
		
		// step2: ���α����ڵ�A,B,C������Щ�ڵ�����ָ����A��B��C��һ��
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
		
		//step3:����A-B-C��A��B��C����A��B��C��������Ҫ�������
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
