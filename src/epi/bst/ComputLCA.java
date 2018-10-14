package epi.bst;

import epi.binarytree.BinaryTreeNode;

/**
 * @author vcpaks
 * 14.4 Compute the LCA in a BST
 */
public class ComputLCA {

	public static void main(String[] args) {
		BinaryTreeNode root = BST.initialize1();
		BinaryTreeNode lca = computeLCA(root, 43, 31);
		System.out.println(lca.data);
	}
	
	private static BinaryTreeNode computeLCA(BinaryTreeNode root, int value1, int value2) {
		if(root==null)
			return null;
		
		if(root.data==value1 || root.data==value2)
			return root;
		
		if((root.data>value1 && root.data<value2)||(root.data>value2 && root.data<value1))
			return root;
		
		if(root.data>value1 && root.data>value2)
			return computeLCA(root.left, value1, value2);
		
		if(root.data<value1 && root.data<value2)
			return computeLCA(root.right, value1, value2);
		return null;
	}

}
