package epi.bst;

import epi.binarytree.BinaryTreeNode;

public class SearchBST {

	public static void main(String[] args) {
		BinaryTreeNode seven = new BinaryTreeNode(7);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode five = new BinaryTreeNode(5);
		BinaryTreeNode eleven = new BinaryTreeNode(11);
		BinaryTreeNode seventeen = new BinaryTreeNode(17);
		BinaryTreeNode thirteen = new BinaryTreeNode(13);
		seven.left=three;
		seven.right=eleven;
		three.left=two;
		three.right=five;
		eleven.right=seventeen;
		seventeen.left=thirteen;
		
		BinaryTreeNode node = searchBST(seven, 7);
		if(node!=null)
			System.out.println(node.data);
		else
			System.out.println("Data not present");
		
	}
	
	private static BinaryTreeNode searchBST(BinaryTreeNode root,int data) {
		if(root==null || root.data==data)
			return root;
		
		if(root.data>data)
			return searchBST(root.left,data);
		else
			return searchBST(root.right,data);
	}

}
