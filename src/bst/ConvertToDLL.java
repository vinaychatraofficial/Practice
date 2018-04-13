package bst;

import trees.Node;

public class ConvertToDLL {

	public static void main(String[] args) {
		BinarySearchTree tree = BinarySearchTree.initialize();
		Node dll = convertToDLL(tree.root);
		//tree.inorder(tree.root);
		Node itr = dll;
		do{
			System.out.println(dll.data);
			dll=dll.right;
		}while(itr!=dll);
	}
	
	private static Node convertToDLL(Node root){
		if(root==null)
			return null;
		
		Node left = convertToDLL(root.left);
		Node right = convertToDLL(root.right);
		
		root.left=root.right=root;
		
		return concatenateLists(concatenateLists(left,root),right);
	}

	private static Node concatenateLists(Node left, Node right) {
		if(left==null)
			return right;
		if(right==null)
			return left;
		Node leftLast = left.left;
		Node rightLast = right.left;
		
		leftLast.right=right;
		right.left=leftLast;
		rightLast.right=left;
		left.left=rightLast;
		
		return left;
					
	}

}
