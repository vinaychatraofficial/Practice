package bst;

import trees.Node;

public class FindMinElem {

	public static void main(String[] args) {
		BinarySearchTree tree = BinarySearchTree.initialize();
		Node node = findMin(tree.root);
		System.out.println(node.data);
		node = findMinIt(tree.root);
		System.out.println(node.data);
	}
	
	private static Node findMin(Node root) {
		if(root==null)
			return null;
		
		if(root.left==null)
			return root;
		else
			return findMin(root.left);
	}
	
	private static Node findMinIt(Node root) {
		if(root==null)
			return null;
		
		while(root.left!=null) {
			root=root.left;
		}
		return root;
	}

}
