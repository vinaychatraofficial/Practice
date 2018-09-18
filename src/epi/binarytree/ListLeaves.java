package epi.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcprabha
 * 9.14 Form a linked list from the leaves of a binary tree
 */
public class ListLeaves {

	public static void main(String[] args) {
		BinaryTreeNode zero = new BinaryTreeNode(0);
		BinaryTreeNode one = new BinaryTreeNode(1);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode four = new BinaryTreeNode(4);
		BinaryTreeNode five = new BinaryTreeNode(5);
		BinaryTreeNode six = new BinaryTreeNode(6);
		BinaryTreeNode seven = new BinaryTreeNode(7);
		BinaryTreeNode eight = new BinaryTreeNode(8);
		BinaryTreeNode nine = new BinaryTreeNode(9);
		
		zero.left=one;
		zero.right=two;
		one.left=three;
		one.right=four;
		three.left=seven;
		three.right=eight;
		two.left=five;
		two.right=six;
		four.right=nine;
		
		List<Integer> result = new ArrayList<>();
		listLeaves(zero, result);
		System.out.println(result);
	}
	
	private static void listLeaves(BinaryTreeNode root,List<Integer> result){
		if(root==null)
			return;
		
		listLeaves(root.left, result);
		if(root.left==null && root.right==null)
			result.add(root.data);
		listLeaves(root.right, result);
	}

}
