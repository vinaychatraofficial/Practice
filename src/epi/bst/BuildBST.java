package epi.bst;

import epi.binarytree.BinaryTreeNode;

/**
 * @author vcpaks
 * 14.8 Build a minimum height BST from a sorted array
 */
public class BuildBST {

	public static void main(String[] args) {
		int[] arr = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53};
		BinaryTreeNode root = buildBST(arr);
		BST.printTreeLevelOrder(root);
	}
	
	private static BinaryTreeNode buildBST(int[] arr) {
		return buildBST(arr, 0, arr.length-1);
	}

	private static BinaryTreeNode buildBST(int[] arr, int start, int end) {
		if(start>end)
			return null;
		int mid = start + (end-start)/2;
		BinaryTreeNode root = new BinaryTreeNode(arr[mid]);
		root.left = buildBST(arr,start,mid-1);
		root.right = buildBST(arr, mid+1, end);
		return root;
	}

}
