package bst;

import trees.Node;

public class InsertElement {

	public static void main(String[] args) {
		BinarySearchTree tree = BinarySearchTree.initialize();
		tree.inorder(tree.root);
		insertElementIt(tree.root, 2);
		System.out.println();
		tree.inorder(tree.root);
	}
	
	private static Node insertElement(Node root, int data) {
		if(root==null) {
			root = new Node(data);
			return root;
		}
		
		if(data<root.data)
			root.left = insertElement(root.left, data);
		if(data>=root.data)
			root.right = insertElement(root.right, data);
		return root;
			
	}
	
	private static void insertElementIt(Node root, int data) {
		if(root==null) {
			root=new Node(data);
			return;
		}
		
		boolean leftChild = false;
		Node prev = null;
		while(root!=null) {
			prev=root;
			if(data<root.data) {
				root=root.left;
				leftChild = true;
			}
			else if(data>=root.data) {
				root=root.right;
				leftChild = false;
			}
			
		}
		root=new Node(data);
		if(leftChild)
			prev.left=root;
		else
			prev.right=root;
		return;
		
	}

}
