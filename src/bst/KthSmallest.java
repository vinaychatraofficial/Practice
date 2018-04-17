package bst;

import trees.Node;

public class KthSmallest {
	static int presentCount=0;

	public static void main(String[] args) {
		
		BinarySearchTree tree = BinarySearchTree.initialize();
		Node node = findKthSmallest(tree.root, 3);
		System.out.println(node.data);
	}
	
	private static Node findKthSmallest(Node root, int k) {
		if(root==null)
			return null;


		Node node = findKthSmallest(root.left, k);
		if(node!=null)
			return node;
		
		presentCount++;
		if(k==presentCount)
			return root;
		

		node = findKthSmallest(root.right, k);
		if(node!=null)
			return node;

		return null;
	}

}
