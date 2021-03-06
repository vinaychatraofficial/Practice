package bst;

import trees.Node;

public class BinarySearchTree {
	
	Node root;
	
	public BinarySearchTree(){
		this.root=null;
	}
	
	public static BinarySearchTree initialize() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(5);
		tree.root.left = new Node(3);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);
		tree.root.right = new Node(7);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(8);
		return tree;
	}
	
	public static BinarySearchTree initialize1() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.left.left = new Node(10);
		tree.root.left.right = new Node(40);
		tree.root.right = new Node(70);
		tree.root.right.left = new Node(60);
		tree.root.right.right = new Node(80);
		return tree;
	}
	
	public static BinarySearchTree initialize2() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(5);
		tree.root.left = new Node(4);
		tree.root.right = new Node(7);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(8);
		return tree;
	}
	
	public static BinarySearchTree initialize3() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(5);
		tree.root.left = new Node(3);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);
		tree.root.right = new Node(7);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(8);
		return tree;
	}
	
	public static BinarySearchTree wrongInitialize() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(5);
		tree.root.left = new Node(3);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(9);
		tree.root.right = new Node(7);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(8);
		return tree;
	}
	
	
	public static BinarySearchTree treeInitialize1() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(20);
		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(30);
		return tree;
	}
	
	public static BinarySearchTree treeInitialize2() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(15);
		tree.root.right.right = new Node(30);
		tree.root.right.right.left = new Node(20);
		return tree;
	}
	
	public static void inorder(Node root) {
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

}
