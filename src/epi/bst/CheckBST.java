package epi.bst;

import java.util.LinkedList;
import java.util.Queue;

import epi.binarytree.BinaryTreeNode;

/**
 * @author vcpaks
 * 14.1 Test if a binary tree satisfies BST property
 */
public class CheckBST {

	public static void main(String[] args) {
		BinaryTreeNode 	one = new BinaryTreeNode(1);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode four = new BinaryTreeNode(4);
		BinaryTreeNode five = new BinaryTreeNode(5);
		
		four.right=five;
		four.left=two;
		two.left=one;
		two.right=three;
		
		boolean result = checkBSTQueue(three,Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(result);
	}
	
	public static class QueueEntry{
		BinaryTreeNode node;
		int min, max;
		
		public QueueEntry(BinaryTreeNode node, int min, int max) {
			this.node=node;
			this.max=max;
			this.min=min;
		}
	}
	
	private static boolean checkBST(BinaryTreeNode root, int min, int max) {
		
		if(root==null)
			return true;
		
		if(root.data<min || root.data>max)
			return false;
		
		return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
		
	}
	
	private static boolean checkBSTQueue(BinaryTreeNode root, int min, int max) {
		if(root==null)
			return true;
		
		Queue<QueueEntry> q = new LinkedList<>();
		q.add(new QueueEntry(root, min, max));
		
		while(!q.isEmpty()) {
			QueueEntry entry = q.remove();
			if(entry.node.data<entry.min || entry.node.data>entry.max)
				return false;
			
			if(entry.node.left!=null)
				q.add(new QueueEntry(entry.node.left, entry.min, entry.node.data));
			
			if(entry.node.right!=null)
				q.add(new QueueEntry(entry.node.right, entry.node.data, entry.max));
		}
		return true;
	}

}
