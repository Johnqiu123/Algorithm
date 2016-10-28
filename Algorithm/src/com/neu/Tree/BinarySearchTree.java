package com.neu.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *  The <tt>BinarySearchTree</tt> Java  provides a structure for search
 *  <p>
 *  <tt>The characteristics of the tree</tt>:
 *  1. all node in its left tree are smaller than its root;
 *  2. all node in its right tree are not smaller that its root;
 *  
 *  @author Johnqiu
 */
public class BinarySearchTree {

    private TreeNode root;
    
    public BinarySearchTree() {
		// TODO Auto-generated constructor stub
    	   root = null;
	}
    
    /**
     * add Tree Node by stack(no recursion)
     * @param root
     * @param value
     * @return
     */
    public static boolean addByStack(TreeNode root, int value){
	    TreeNode node = new TreeNode(value);
	    if(root == null){
    	   root = node;
    	   return true;
	    }
	    else{  
    	   Stack<TreeNode> stack = new Stack<TreeNode>();
    	   TreeNode treenode = root;
    	   stack.push(treenode);
    	   while(!stack.isEmpty()){
		      treenode = (TreeNode) stack.pop();
		      if(value < treenode.getData()){
	    	       if(treenode.left == null){
		    	   		treenode.left = node;
		    	   		return true;
	    	       }else{
		    	        stack.push(treenode.left);
	    	       }
		      }else{
		    	  if(treenode.right == null){
    	    	   		treenode.right = node;
    	    	   		return true;
		    	  }else{
	    		  		stack.push(treenode.right);
                  }
		      }
    	   }
	    }
	    return false;
    }
    
    /**
     * add Tree Node(recursion)
     * @param node
     * @param value
     * @return
     * Question：How to write recursion?
     */
    public static TreeNode add(TreeNode node, int value){
    	if(node == null){
    		node = new TreeNode(value);
    	}else if(node.getData() > value){
    		node.left = add(node.left, value);
    	}else if(node.getData() < value){
    		node.right = add(node.right, value);
    	}
    	return node;  // return new pointer
    }
    
    /**
     * delete a childless node 
     * @param root
     * @param pParent
     * @param pNode
     */
    public static void deleteChildless(TreeNode root, TreeNode pParent, TreeNode pNode){
    	if(root == pNode){
    		root = null;
    	}else if(pParent.left == pNode){
    		pParent.left = null;
    	}else{
    		pParent.right = null;
    	}
    }
    
    /**
     * delete a single son node
     * @param root
     * @param pParent
     * @param pNode
     */
    public static void deleteSingleson(TreeNode root, TreeNode pParent, TreeNode pNode){
    	TreeNode grandson = pNode.left != null? pNode.left:pNode.right;  // get grandson
    	if(root == pNode){
    		root = grandson;
    	}else if(pParent.left == pNode){
    		pParent.left = grandson;
    	}else{
    		pParent.right = grandson;
    	}    	 	
    }
    
    /**
     * delete a node
     * @param root
     * @param value
     * @return
     */
    public static boolean delete(TreeNode root, int value){
    	if(root == null){
    		return false;
    	}
    	TreeNode pNode = root;
    	TreeNode pParent = null;
    	
    	// find node
    	while(pNode != null){
    		if(pNode.getData() > value){
    			pParent = pNode;
    			pNode = pNode.left;
    		}else if(pNode.getData() < value){
    			pParent = pNode;
    			pNode = pNode.right;
    		}else{  // find value
    			break;
    		}
    	}
    	
    	// find fail
    	if(pNode == null){
    		return false;
    	}
    	
    	// delete : three conditions
    	if(pNode.left == null && pNode.right == null){ // delete childless node
    		deleteChildless(root,pParent,pNode);
    	}else if (pNode.left == null || pNode.right == null){// delete singleson node
    		deleteSingleson(root,pParent,pNode);
    	}else{// delete two children snode
    		TreeNode pCur = pNode; // waiting delete
    		pParent = pNode;
    		pNode = pNode.right;
    		while(pNode.left != null){
    			pParent = pNode;
    			pNode = pNode.left;
    		}
    		pCur.setData(pNode.getData());
    		System.out.println(pNode.getData());
    		if(pNode.right == null){
    			System.out.println("Childless");
    			deleteChildless(root, pParent, pNode);
    		}else{
    			System.out.println("Singleson");
    			deleteSingleson(root, pParent, pNode);
    		}
    	}
        return true;
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
    		Stack<TreeNode> stack = new Stack<TreeNode>();
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
    		Stack<TreeNode> stack = new Stack<TreeNode>();
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
    		Stack<TreeNode> stack = new Stack<TreeNode>();
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
    		Stack<TreeNode> stack = new Stack<TreeNode>();
    		Stack<TreeNode> stack2 = new Stack<TreeNode>();
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
     * levelorder traversal(no recursion)
     * level by level
     * @param root
     */
    public static void levelorder(TreeNode root){
    	if(root != null){
    		Queue<TreeNode> queue = new LinkedList<TreeNode>();
    		TreeNode node = root;
    		queue.offer(node);
    		while(!queue.isEmpty()){
    			node = queue.poll();
    			System.out.print(node + " ");
    			if(node.left != null){
    				queue.offer(node.left);
    			}
    			if(node.right != null){
    				queue.offer(node.right);
    			}
    		}
    	}
    }
    
    public static TreeNode generateByList(List<Integer> data){
    	if(data == null){
    		return null;
    	}
    	TreeNode root = createTree(data, 0);
    	return root;
    }
    
    private static TreeNode createTree(List<Integer> data, int index){
    	TreeNode tn = null;
		if (index<data.size()) {
			    if(data.get(index)!= null){
			    	int value = data.get(index);
					tn = new TreeNode(value);
					tn.left = createTree(data, 2*index+1);
					tn.right = createTree(data, 2*index+2);
					return tn;
			    }	    
		}		
		return tn;
    }
    /**
     * 
     * @param root
     * @param value
     * @return
     */
    public static TreeNode find(TreeNode root, int value){
    	if(root == null){
    		return null;
    	}
    	TreeNode tempnode = root;
    	while(tempnode != null){
    		if(tempnode.getData() > value){
    			tempnode = tempnode.left;
    		}else if(tempnode.getData() < value){
    			tempnode = tempnode.right;
    		}else{
    			return tempnode;
    		}
    	}
    	return null;
    }

    /**
     * print a tree
     * @param root
     */
    public static void printTree(TreeNode root){
	   Queue<TreeNode> queue = new LinkedList<TreeNode>();
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

	public static void main(String[] args) {
//		int[]  b = {15,5,3,12,16,20,23,13,18,10,6,7};
//		BinarySearchTree bst = new BinarySearchTree();
//		TreeNode root = bst.getRoot();
////		addTNode(root, b[1]);
//		for(int i = 0;  i < b.length; i++){
////			bst.addByStack(root, b[i]);
//			root = add(root, b[i]);
//		}
//		TreeNode result = find(root,7);
//		System.out.println(result);
//		bst.printTree(root);
//		System.out.println(" ");
//		bst.delete(root, 5);
//		bst.printTree(root);
		/*****************Test 2********************/
//		bst.preorder(root);
//		System.out.println("");
//		bst.inorder(root);
//		System.out.println("");
//		postorder(root);
		
		/*****************Test 3********************/
//		bst.preorderBystack(root);
//		System.out.println("");
//		bst.inorderBystack(root);
//		System.out.println("");
//		postorderBystack(root);
//		System.out.println("");
//		levelorder(root);
		
		/*****************Test 3********************/
		int[]  b = {15,5,3,12,16,20,23,13,18,10,6,7};
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < b.length; i++){
			list.add(b[i]);
		}
		TreeNode root = generateByList(list);
		printTree(root);
	}
}
