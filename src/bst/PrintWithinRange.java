package bst;

import trees.Node;

public class PrintWithinRange {

	public static void main(String[] args) {
		BinarySearchTree bst = BinarySearchTree.initialize();
		printWithinRange(bst.root, 2, 7);
	}
	
	private static void printWithinRange(Node root, int k1, int k2){
		if(root==null)
			return;
		
		if(root.data>=k1)
			printWithinRange(root.left, k1, k2);
		
		if(root.data>=k1 && root.data<=k2)
			System.out.println(root.data);
		
		if(root.data<=k2)
			printWithinRange(root.right, k1, k2);
	}

}
