package epi.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author vcprabha
 * 9.12 Reconstruct a binary tree from traversal data
 */
public class ConstructTreeInorderPreorder {

	static int preIdx=0;
	
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
		
		BinaryTreeNode[] inorder = {seven,three,eight,one,four,nine,zero,five,two,six};
		BinaryTreeNode[] preorder = {zero,one,three,seven,eight,four,nine,two,five,six};
		
		Map<BinaryTreeNode,Integer> nodeMap = constructMap(inorder);
		BinaryTreeNode root = construct(inorder, preorder, 0, inorder.length-1, nodeMap);
		
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			BinaryTreeNode cur = q.remove();
			System.out.print(cur.data+" ");
			if(cur.left!=null)
				q.add(cur.left);
			if(cur.right!=null)
				q.add(cur.right);
		}
	
	}
	
	private static Map<BinaryTreeNode,Integer> constructMap(BinaryTreeNode[] inorder){
		Map<BinaryTreeNode,Integer> nodeMap = new HashMap<>();
		for(int i=0;i<inorder.length;i++){
			nodeMap.put(inorder[i], i);
		}
		return nodeMap;
	}
	
	private static BinaryTreeNode construct(BinaryTreeNode[] inorder, BinaryTreeNode[] preorder,
		int startIdx, int endIdx, Map<BinaryTreeNode,Integer> nodeMap){
		if(preIdx>=preorder.length)
			return null;
		if(startIdx>endIdx)
			return null;
		
		BinaryTreeNode root = preorder[preIdx++];
		int inIdx = nodeMap.get(root);
		root.left = construct(inorder, preorder, startIdx, inIdx-1,nodeMap);
		root.right = construct(inorder, preorder, inIdx+1, endIdx, nodeMap);
		return root;
	}

}
