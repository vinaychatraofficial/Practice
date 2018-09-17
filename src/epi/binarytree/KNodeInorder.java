package epi.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vcprabha
 * 9.9 Compute the kth node in an inorder traversal
 */
public class KNodeInorder {

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
		four.left=nine;
		
		Map<BinaryTreeNode,Integer> nodeMap = new HashMap<>();
		nodeMap.put(zero, 10);
		nodeMap.put(one, 6);
		nodeMap.put(two, 3);
		nodeMap.put(three, 3);
		nodeMap.put(four, 2);
		nodeMap.put(four, 2);
		nodeMap.put(five, 1);
		nodeMap.put(six, 1);
		nodeMap.put(seven, 1);
		nodeMap.put(eight, 1);
		BinaryTreeNode kthNode = findNode(zero, 4, nodeMap);
		System.out.println(kthNode.data);
	
	}
	
	private static BinaryTreeNode findNode(BinaryTreeNode root, int k, Map<BinaryTreeNode,Integer> nodeMap){
		if(root==null)
			return null;
		
		int leftSize = root.left!=null?nodeMap.get(root.left):0;
		
		if(leftSize+1==k)
			return root;
		else if(k<leftSize+1)
			return findNode(root.left, k, nodeMap);
		else
			return findNode(root.right, k-(leftSize+1), nodeMap);
	}

}
