package bst;

import trees.Node;

public class FindCeil {

	public static void main(String[] args) {
		BinarySearchTree bst = BinarySearchTree.initialize1();
		Node node = findCeil(bst.root, 60);
		System.out.println(node.data);
	}
	
	private static Node findCeil(Node root, int key) {
		if(root==null)
			return null;
		
		if(root.data<key)
			return findCeil(root.right,key);
		else if(root.data>key) {
			Node node = findCeil(root.left,key);
			if(node!=null)
				return node;
			else
				return root;
		}
		else
			return root;
	}

}
