package com.neu.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
    private TreeNode root;
    
    public BinaryTree() {
		// TODO Auto-generated constructor stub
    	   root = null;
	}	
    
    /**
     * preorder traversal(recursion)
     * middle --> left --> right
     * @param root
     */
    public static void preorder(TreeNode root){
    	if(root != null){
    		System.out.print(root + " ");
    		preorder(root.left);
    		preorder(root.right);
    	}
    }

    /**
     * preorder traversal(no recursion)
     * middle --> left --> right
     * @param root
     */
    public static void preorderBystack(TreeNode root){
    	if(root != null){
    		Stack stack = new Stack();
    		TreeNode node = root;
    		while(!stack.isEmpty()|| node != null){
    			while(node != null){
    				System.out.print(node + " ");
    				stack.push(node);
    				node = node.left;
    			}
    			node = (TreeNode) stack.pop();
    			node = node.right;
    		}
    	}
    }
 
    /**
     * preorder traversal(no recursion)
     * middle --> left --> right
     * @param root
     */
    public static void preorderBystack2(TreeNode root){
    	if(root != null){
    		Stack stack = new Stack();
    		TreeNode node = root;
    		stack.push(node);
    		while(!stack.isEmpty()){
    			TreeNode newnode = (TreeNode) stack.pop();
    			System.out.print(newnode + " ");
    			if(newnode.right != null){
    				stack.push(newnode.right);
    			}
    			if(newnode.left != null){
    				stack.push(newnode.left);
    			}		
    		}
    	}
    }
    
    /**
     * inorder traversal(recursion)
     * left --> middle --> right
     * @param root
     */
    public static void inorder(TreeNode root){
    	if(root != null){
    		inorder(root.left);
    		System.out.print(root + " ");
    		inorder(root.right);
    	}
    }

    /**
     * inorder traversal(no recursion)
     * left --> middle --> right
     * @param root
     */
    public static void inorderBystack(TreeNode root){
    	if(root != null){
    		Stack stack = new Stack();
    		TreeNode node = root;
    		while(!stack.isEmpty()|| node != null){
    			while(node != null){
    				stack.push(node);
    				node = node.left;
    			}
    			node = (TreeNode) stack.pop();
				System.out.print(node + " ");
    			node = node.right;
    		}
    	}
    }
    
    /**
     * postorder traversal(recursion)
     * left --> right --> middle
     * @param root
     */
    public static void postorder(TreeNode root){
    	if(root != null){
    		postorder(root.left);
    		postorder(root.right);
    		System.out.print(root+" ");
    	}
    }

    /**
     * postorder traversal(no recursion)
     * left --> right --> middle
     * @param root
     */
    public static void postorderBystack(TreeNode root){
    	if(root != null){
    		Stack stack = new Stack();
    		Stack stack2 = new Stack();
    		TreeNode node = root;
    		stack.push(node);
    		while(!stack.isEmpty()){
    			node = (TreeNode) stack.pop();
    			if(node.left != null){
    				stack.push(node.left);
    			}
    			if(node.right != null){
    				stack.push(node.right);
    			}
    			stack2.push(node);
    		}
    		while(!stack2.isEmpty()){
    			node = (TreeNode) stack2.pop();
    			System.out.print(node.getData()+" ");
    		}
    	}
    }
    /**
     * Given preorder and inorder traversal sequence, reconstruct a binary tree
     * @param root the root of new tree
     * @param pre  preorder traversal sequence
     * @param in   inorder traversal sequence
     */
    public static void reconstructTree(TreeNode root, int[] pre, int[] in){
        // middle
        int num = 0;
        int i = 0;
        for(i=0; i < in.length; i++){
            if (in[i] == pre[0]){
                break;
            }    
        }
        // split
        int[] leftin = new int[i];
        int[] rightin = new int[in.length-i-1];
        int[] leftpre = new int[i];
        int[] rightpre = new int[in.length-i-1];
        int k=0;
        for(int j=0; j < in.length; j++){
            if(j < i){
                leftin[j] = in[j];
                leftpre[j] = pre[j+1];
            }else if(j > i){
                rightin[k] = in[j];
                rightpre[k] = pre[j];
                k++;
            }
            
        }
        if(leftpre.length > 0 ){
    	   TreeNode leftnode = new TreeNode(leftpre[0]);
    	   root.left = leftnode; 
    	   reconstructTree(root.left, leftpre, leftin);
        }
        if(rightpre.length > 0 ){
//    	   System.out.println(rightpre[0]);
           TreeNode rightnode = new TreeNode(rightpre[0]);		            
           root.right = rightnode;  
           reconstructTree(root.right, rightpre, rightin);
        }
    }
    
    /**
     * print a tree
     * @param root
     */
    public static void printTree(TreeNode root){
	   Queue queue = new LinkedList();
	   TreeNode treenode = root;
	   queue.offer(treenode);
	   while(!queue.isEmpty()){
	      treenode = (TreeNode) queue.poll();
	      if(treenode == null){
    	      System.out.print("null" +"  ");
	      }else{
		      System.out.print(treenode.getData()+" ");   		      
		      if(treenode.left !=null){
	    	      queue.offer(treenode.left);
		      }else{
	    	      queue.offer(null);
		      }
		      if(treenode.right != null){
	    	       queue.offer(treenode.right);
		      }else{
	    	       queue.offer(null);
		      }
	      }
	   }
    }
    
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		BinaryTree bt = new BinaryTree();
		TreeNode root = new TreeNode(pre[0]);
		bt.reconstructTree(root, pre, in);
		printTree(root);
		System.out.println(" ");
		bt.postorder(root);
	}
}
