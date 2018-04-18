package bst;

import trees.Node;

public class CompareTree {

	public static void main(String[] args) {
		BinarySearchTree bst1 = BinarySearchTree.treeInitialize1();
		BinarySearchTree bst2 = BinarySearchTree.treeInitialize2();
		System.out.println(compareTree(bst1.root, bst2.root));
	}
	
	private static boolean compareTree(Node root1, Node root2){
		if(root1==null && root2==null)
			return true;
		
		if(root1==null||root2==null)
			return false;
		
		return (compareTree(root1.left, root2.left) && root1.data==root2.data && compareTree(root1.right,root2.right));
	}

}
