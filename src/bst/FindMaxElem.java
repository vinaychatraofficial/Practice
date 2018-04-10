package bst;

import trees.Node;

public class FindMaxElem {

	public static void main(String[] args) {
		BinarySearchTree tree = BinarySearchTree.initialize();
		Node node = findMax(tree.root);
		System.out.println(node.data);
		node = findMaxIt(tree.root);
		System.out.println(node.data);
	}
	
	private static Node findMax(Node root) {
		if(root==null)
			return null;
		
		if(root.right==null)
			return root;
		else
			return findMax(root.right);
	}
	
	private static Node findMaxIt(Node root) {
		if(root==null)
			return null;
		
		while(root.right!=null) {
			root=root.right;
		}
		
		return root;
	}

}
