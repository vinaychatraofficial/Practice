package bst;

import java.util.ArrayList;
import java.util.List;

import trees.Node;

/**
 * Trim tree between k1 and k2
 * @author vcprabha
 *
 */
public class TrimTree {

	public static void main(String[] args) {
		BinarySearchTree bst = BinarySearchTree.initialize();
		List<Node> nodeList = new ArrayList<Node>();
		trimTree(bst.root, 2, 7, nodeList);
		for(Node node:nodeList)
			System.out.print(node.data+" ");
		Node root = formTree(nodeList,0,nodeList.size()-1);
		System.out.println();
		preorder(root);
		System.out.println();
		inorder(root);
	}
	
	private static void preorder(Node root) {
		if(root==null)
			return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	private static void inorder(Node root){
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
		
	}

	private static Node formTree(List<Node> nodeList, int left, int right) {
		if(left>right)
			return null;
		int mid = left+(right-left)/2;
		Node root = new Node(nodeList.get(mid).data);
		root.left = formTree(nodeList, left, mid-1);
		root.right = formTree(nodeList,mid+1,right);
		return root;
	}

	private static void trimTree(Node root, int k1, int k2, List<Node> nodeList){
		if(root==null)
			return;
		
		if(root.data>=k1)
			trimTree(root.left,k1,k2,nodeList);
		if(root.data>=k1 && root.data<=k2)
			nodeList.add(root);
		if(root.data<=k2)
			trimTree(root.right,k1,k2,nodeList);
	}

}
