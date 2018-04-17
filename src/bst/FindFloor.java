package bst;

import trees.Node;

public class FindFloor {

	public static void main(String[] args) {
		BinarySearchTree bst = BinarySearchTree.initialize1();
		Node node = findFloor(bst.root, 68);
		System.out.println(node.data);
	}
	
	private static Node findFloor(Node root,int key) {
		if(root==null)
			return null;
		
		if(root.data>key)
			return findFloor(root.left,key);
		
		else if(root.data<key) {
			Node node = findFloor(root.right,key);
			if(node!=null)
				return node;
			else
				return root;
		}
		
		else
			return root;
		
	}

	

}
