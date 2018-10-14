package epi.bst;

import java.util.ArrayList;
import java.util.List;

import epi.binarytree.BinaryTreeNode;

/**
 * @author vcpaks
 * 14.3 Find the k largest elements in a BST
 */
public class KLargestElemBST {

	public static void main(String[] args) {
		BinaryTreeNode root = BST.initialize1();
		List<BinaryTreeNode> list = new ArrayList<>();
		findKLargestElem(root, list, 4);
		for(BinaryTreeNode node:list)
			System.out.println(node.data);
	}
	
	private static void findKLargestElem(BinaryTreeNode root, List<BinaryTreeNode> list, int k) {
		if(root==null)
			return;
		
		if(list.size()<k)
			findKLargestElem(root.right, list, k);
		if(list.size()<k) {
			list.add(root);
			findKLargestElem(root.left, list, k);
		}
	}

}
