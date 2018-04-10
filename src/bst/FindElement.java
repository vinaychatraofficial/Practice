package bst;

import trees.Node;

public class FindElement {

	public static void main(String[] args) {
		BinarySearchTree tree = BinarySearchTree.initialize();
		Node node = findElem(tree.root,5);
		System.out.println(node.data);
		node = findElem(tree.root,5);
		System.out.println(node.data);
	}
	
	private static Node findElem(Node root, int data) {
		if(root==null)
			return null;
		
		if(data<root.data)
			return findElem(root.left,data);
		else if(data>root.data)
			return findElem(root.right,data);
		
		return root;
	}
	
	private static Node findElemIt(Node root, int data) {
		if(root==null)
			return null;
		
		while(root!=null) {
			if(data<root.data)
				root=root.left;
			else if(data>root.data)
				root=root.right;
			else
				break;
		}
		return root;
	}

}
