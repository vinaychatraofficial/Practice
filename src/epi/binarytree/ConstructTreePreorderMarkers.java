package epi.binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author vcprabha
 * 9.13 Reconstruct a binary tree from a preorder traversal with markers
 */
public class ConstructTreePreorderMarkers {

	static int index=0;
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
		
		BinaryTreeNode[] preorder = {zero,one,three,seven,null,null,eight,null,null,four,null,nine,null,
				null,two,five,null,null,six,null,null};
		
		BinaryTreeNode root = construct(preorder);
		
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
	
	private static BinaryTreeNode construct(BinaryTreeNode[] preorder){
		if(index>=preorder.length)
			return null;
		BinaryTreeNode root = preorder[index];
		index++;
		if(preorder[index]!=null)
			root.left=construct(preorder);
		else
			index++;
		if(preorder[index]!=null)
			root.right=construct(preorder);
		else
			index++;
		return root;
	}

}
