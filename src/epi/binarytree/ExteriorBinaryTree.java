package epi.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcpaks
 * 9.15 Compute the exterior of a binary tree
 */
public class ExteriorBinaryTree {

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
		
		List<Integer> result = computeExterior(zero);
		System.out.println(result);
	
	}
	
	private static List<Integer> computeExterior(BinaryTreeNode root){
		List<Integer> result = new ArrayList<>();
		result.add(root.data);
		computeLeft(root.left,result,true);
		computeRight(root.right,result,true);
		return result;
	}

	private static void computeRight(BinaryTreeNode root, List<Integer> result, boolean boundary) {
		if(root==null)
			return;
		
		computeRight(root.left,result,boundary && root.right==null);
		computeRight(root.right,result,boundary);
		if(boundary || (root.left==null && root.right==null))
			result.add(root.data);
	}

	private static void computeLeft(BinaryTreeNode root, List<Integer> result, boolean boundary) {
		if(root==null)
			return;
		
		if(boundary || (root.left==null && root.right==null))
			result.add(root.data);
		
		computeLeft(root.left, result, boundary);
		computeLeft(root.right,result, boundary && root.left==null);
	}
	

}
