package epi.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import epi.binarytree.BinaryTreeNode;

/**
 * @author vcprabha
 * 14.5 Reconstruct a BST from traversal data
 */
public class ConstructBST {
	
	static int preorderidx=0;
	static int postorderidx;

	public static void main(String[] args) {
		Integer[] arr = {19,7,3,2,5,11,17,13,43,23,37,29,31,41,47,53};
		//Integer[] arr = {2,5,3,13,17,11,7,31,29,41,37,23,53,47,43,19};
		List list = new ArrayList(Arrays.asList(arr));
		//BinaryTreeNode root = buildTreePre(list);
		//BinaryTreeNode root = buildTreePost(list);
		BinaryTreeNode root = buildTreePreBound(list);
		//BinaryTreeNode root = buildTreePostBound(list);
		BST.printTreeLevelOrder(root);
	}
	
	private static BinaryTreeNode buildTreePre(List<Integer> list){
		return buildTreePre(list,0,list.size()-1);
	}

	private static BinaryTreeNode buildTreePre(List<Integer> list, int start, int end) {
		if(start>end)
			return null;
		BinaryTreeNode root = new BinaryTreeNode(list.get(start));
		//System.out.println(list.get(start));
		int count=0;
		for(int i=start+1;i<=end;i++){
			if(list.get(i)<list.get(start))
				count++;
			else
				break;
		}
		root.left=buildTreePre(list, start+1, start+count);
		root.right=buildTreePre(list,start+count+1,end);
		return root;
	}
	
	private static BinaryTreeNode buildTreePost(List<Integer> list){
		return buildTreePost(list,0,list.size()-1);
	}

	private static BinaryTreeNode buildTreePost(List<Integer> list, int start, int end) {
		if(start>end)
			return null;
		BinaryTreeNode root = new BinaryTreeNode(list.get(end));
		int count=0;
		for(int i=start;i<=end-1;i++){
			if(list.get(i)<list.get(end))
				count++;
			else
				break;
		}
		root.left=buildTreePost(list, start, start+count-1);
		root.right=buildTreePost(list,start+count,end-1);
		return root;
	}
	
	private static BinaryTreeNode buildTreePreBound(List<Integer> list){
		return buildTreePreBound(list,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private static BinaryTreeNode buildTreePreBound(List<Integer> list,	int minValue, int maxValue) {
		if(preorderidx==list.size())
			return null;
		Integer rootValue = list.get(preorderidx);
		if(rootValue<minValue || rootValue>maxValue)
			return null;
		preorderidx++;
		BinaryTreeNode root = new BinaryTreeNode(rootValue);
		root.left=buildTreePreBound(list, minValue, rootValue);
		root.right=buildTreePreBound(list, rootValue, maxValue);
		return root;
	}
	
	private static BinaryTreeNode buildTreePostBound(List<Integer> list){
		postorderidx=list.size()-1;
		return buildTreePostBound(list,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private static BinaryTreeNode buildTreePostBound(List<Integer> list,int minValue, int maxValue) {
		if(postorderidx<0)
			return null;
		Integer rootValue = list.get(postorderidx);
		if(rootValue<minValue || rootValue>maxValue)
			return null;
		postorderidx--;
		BinaryTreeNode root = new BinaryTreeNode(rootValue);
		root.right=buildTreePostBound(list, rootValue, maxValue);
		root.left=buildTreePostBound(list, minValue, rootValue);
		return root;
	}
	

}
