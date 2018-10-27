package epi.bst;

import java.util.ArrayList;
import java.util.List;

import epi.binarytree.BinaryTreeNode;

/**
 * @author vcpaks
 * 14.10 The range lookup problem
 */
public class RangeLookup {

	public static void main(String[] args) {
		BinaryTreeNode root = BST.initialize1();
		System.out.println(rangeSearch(root, 16, 42));
	}
	
	private static List<Integer> rangeSearch(BinaryTreeNode root, int low, int high) {
		List<Integer> result = new ArrayList<>();
		rangeSearch(root,low,high,result);
		return result;
	}

	private static void rangeSearch(BinaryTreeNode root, int low, int high, List<Integer> result) {
		if(root==null)
			return;
		
		if(root.data>=low && root.data<=high) {
			result.add(root.data);
			rangeSearch(root.left, low, high,result);
			rangeSearch(root.right, low, high, result);
		}else if(root.data<low) {
			rangeSearch(root.right, low, high, result);
		}else {
			rangeSearch(root.left, low, high, result);
		}
	}

}
