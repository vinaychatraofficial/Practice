package bst;

import trees.Node;

public class CheckBST {

	public static void main(String[] args) {
		BinarySearchTree bst = BinarySearchTree.wrongInitialize();
		System.out.println(checkBST(bst.root));
		System.out.println(checkBSTBetter(bst.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
	
	private static boolean checkBST(Node root){
			if(root==null)
				return true;
			
			if(root.left!=null && root.left.data>root.data)
				return false;
			
			if(root.right!=null && root.right.data<root.data)
				return false;
			
			if(!checkBST(root.left) || !checkBST(root.right))
				return false;
			
			Node max = findMax(root.left);
			Node min = findMin(root.right);
			if((max!=null && max.data>root.data) || (min!=null && min.data<root.data))
				return false;
			
			return true;
	}
	
	private static boolean checkBSTBetter(Node root, int min, int max){
		if(root==null)
			return true;
		
		return (root.data>min && root.data<max && checkBSTBetter(root.left, min, root.data) && checkBSTBetter(root.right, root.data, max));
		
	}
	


	private static Node findMax(Node root) {
		if(root==null)
			return null;
		
		if(root.right!=null)
			return findMax(root.right);
		else
			return root;
		
	}
	
	private static Node findMin(Node root){
		if(root==null)
			return null;
		
		if(root.left!=null)
			return findMin(root.left);
		else
			return root;
	}

}
