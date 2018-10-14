package epi.bst;

import epi.binarytree.BinaryTreeNode;

public class BST {
	
	public static BinaryTreeNode initialize1() {
		BinaryTreeNode 	five = new BinaryTreeNode(5);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode seven = new BinaryTreeNode(7);
		BinaryTreeNode seventeen = new BinaryTreeNode(17);
		BinaryTreeNode thirteen = new BinaryTreeNode(13);
		BinaryTreeNode eleven = new BinaryTreeNode(11);
		BinaryTreeNode fortythree = new BinaryTreeNode(43);
		BinaryTreeNode twentythree = new BinaryTreeNode(23);
		BinaryTreeNode thirtyseven = new BinaryTreeNode(37);
		BinaryTreeNode twentynine = new BinaryTreeNode(29);
		BinaryTreeNode thirtyone = new BinaryTreeNode(31);
		BinaryTreeNode fortyone = new BinaryTreeNode(41);
		BinaryTreeNode fortyseven = new BinaryTreeNode(47);
		BinaryTreeNode fiftythree = new BinaryTreeNode(53);
		BinaryTreeNode nineteen = new BinaryTreeNode(19);
		
		nineteen.left=seven;
		nineteen.right=fortythree;
		seven.left=three;
		seven.right=eleven;
		three.left=two;
		three.right=five;
		eleven.right=seventeen;
		seventeen.left=thirteen;
		fortythree.left=twentythree;
		fortythree.right=fortyseven;
		fortyseven.right=fiftythree;
		twentythree.right=thirtyseven;
		thirtyseven.left=twentynine;
		thirtyseven.right=fortyone;
		twentynine.right=thirtyone;
		return nineteen;
	}

}
