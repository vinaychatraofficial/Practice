package bst;

import trees.Node;

public class DeleteElement {

	public static void main(String[] args) {
		BinarySearchTree tree = BinarySearchTree.initialize();
		tree.inorder(tree.root);
		deleteElement(tree.root, 7);
		System.out.println();
		tree.inorder(tree.root);
	}
	
	private static Node deleteElement(Node root,int data) {
		if(root==null)
			return null;
		
		if(data<root.data)
			root.left = deleteElement(root.left, data);
		else if(data>root.data)
			root.right = deleteElement(root.right, data);
		else {
			if(root.left!=null && root.right!=null) {
				Node maxNode = findMax(root.left);
				//System.out.println("max node is "+maxNode.data);
				root.data = maxNode.data;
				root.left = deleteElement(root.left, maxNode.data);
			}else{
				if(root.left!=null) {
					root = root.left;
					//root.left = deleteElement(root.left, root.data);
				}
				else if(root.right!=null) {
					root = root.right;
					//root.right = deleteElement(root.right, root.data);
				}else {
					root=null;
				}
			}
		}
		return root;
	}
	
	private static Node deleteElementIt(Node root, int data) {
		if(root==null)
			return null;
		Node prev;
		while(root!=null) {
			if(data<root.data)
				root=root.left;
			else if(data>root.data)
				root=root.right;
			else
				break;
			prev = root;
		}
		
		if(root.left!=null && root.right!=null) {
			Node maxNode = findMax(root.left);
			root.data = maxNode.data;
			root.left = deleteElementIt(root.left, root.data);
		}else {
			if(root.left!=null) {
				root.data = root.left.data;
				root.left = deleteElementIt(root.left, root.data);
			}else if(root.right!=null) {
				root.data = root.right.data;
				root.right = deleteElementIt(root.right, root.data);
			}else {
				root=null;
			}
		}
		
		return root;
		
	}

	private static Node findMax(Node root) {
		if(root==null)
			return null;
		
		if(root.right!=null)
			return findMax(root.right);
		else
			return root;
	}

}
