package epi.bst;

import epi.binarytree.BinaryTreeNode;

/**
 * @author vcpaks
 * 14.2 Find the first key greater than a value in a BST
 */
public class FirstKeyGreaterThanValue {

	public static void main(String[] args) {
		BinaryTreeNode 	one = new BinaryTreeNode(1);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode ten = new BinaryTreeNode(10);
		BinaryTreeNode twelve = new BinaryTreeNode(12);
		BinaryTreeNode twenty = new BinaryTreeNode(20);
		BinaryTreeNode twentytwo = new BinaryTreeNode(22);
		BinaryTreeNode eleven = new BinaryTreeNode(11);
		BinaryTreeNode fourteen = new BinaryTreeNode(14);
		
		ten.left=two;
		two.left=one;
		two.right=three;
		ten.right=twenty;
		twenty.left=twelve;
		twenty.right=twentytwo;
		twelve.left=eleven;
		twelve.right=fourteen;
		
		//BinaryTreeNode node = firstValueGreater(ten, 10);
		BinaryTreeNode node = firstValueGreaterIt(ten, 3);
		
		System.out.println(node.data);
	}
	
	private static BinaryTreeNode firstValueGreater(BinaryTreeNode root, int data) {
		BinaryTreeNode candidate = null;
		return firstValueGreater(root,candidate,data);
	}

	private static BinaryTreeNode firstValueGreater(BinaryTreeNode root, BinaryTreeNode candidate, int data) {
		if(root==null)
			return candidate;
		
		if(root.data>data)
			return firstValueGreater(root.left,root,data);
		else
			return firstValueGreater(root.right,candidate,data);
		
	}
	
	private static BinaryTreeNode firstValueGreaterIt(BinaryTreeNode root, int data) {
		if(root==null)
			return null;
		
		BinaryTreeNode candidate = null;
		while(root!=null) {
			if(root.data>data) {
				candidate=root;
				root=root.left;
			}else {
				root=root.right;
			}
		}
		return candidate;
	}

}
