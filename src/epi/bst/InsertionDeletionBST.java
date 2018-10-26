package epi.bst;

import epi.binarytree.BinaryTreeNode;

/**
 * @author vcpaks
 * (15.10) Insertion and deletion in a BST
 */
public class InsertionDeletionBST {

	public static void main(String[] args) {
		BinaryTreeNode root = BST.initialize1();
		insert(root, 18);
		//BST.printTreeLevelOrder(root);
		delete(root,18);
		//BST.printTreeLevelOrder(root);
		delete(root,23);
		BST.printTreeLevelOrder(root);
	}
	
	private static boolean insert(BinaryTreeNode root, Integer key) {
		if(root==null)
			root = new BinaryTreeNode(key);
		
		BinaryTreeNode curr = root;
		BinaryTreeNode parent = curr;
		while(curr!=null) {
			parent=curr;
			if(curr.data==key)
				return false;
			curr = key<curr.data?curr.left:curr.right;
		}
		
		if(key<parent.data)
			parent.left = new BinaryTreeNode(key);
		else
			parent.right = new BinaryTreeNode(key);
		
		return true;
	}
	
	private static boolean delete(BinaryTreeNode root, Integer key) {
		if(root==null)
			return false;
		
		//find the key
		BinaryTreeNode curr = root;
		BinaryTreeNode parent = curr;
		
		while(curr!=null && curr.data!=key) {
			parent=curr;
			curr=key<curr.data?curr.left:curr.right;
		}
		
		if(curr==null)
			return false;
		
		BinaryTreeNode keyNode = curr;
		//if right subtree, replace with successor and adjust
		if(keyNode.right!=null) {
			BinaryTreeNode rKeyNode = keyNode.right;
			BinaryTreeNode rParent = keyNode;
			while(rKeyNode.left!=null) {
				rParent=rKeyNode;
				rKeyNode = rKeyNode.left;
			}
			
			//replace
			keyNode.data=rKeyNode.data;
			
			if(rParent.left==rKeyNode) {
				rParent.left=rKeyNode.right;
			}else {
				rParent.right=rKeyNode.right;
			}
			
			//keyNode.right=null;
		}else { //no right subtree
			if(root==keyNode) {
				root=keyNode.left;
			}else {
				if(parent.left==keyNode)
					parent.left=keyNode.left;
				else
					parent.right=keyNode.left;
			}
			keyNode.left=null;
		}
		
		return true;
	}

}
