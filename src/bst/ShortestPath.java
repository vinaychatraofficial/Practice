package bst;

import java.util.ArrayList;
import java.util.List;

import trees.Node;

public class ShortestPath {

	public static void main(String[] args) {
		BinarySearchTree bst = BinarySearchTree.initialize();
		Node lca = findLCA(bst.root, bst.root.left.left, bst.root.right.right);
		System.out.println(lca.data);
		List<Integer> path = findPath(lca, bst.root.right.right.data);
		for(Integer data:path)
			System.out.println(data);
	}
	
	private static List<Integer> findPath(Node root, int data){
		List<Integer> path = new ArrayList<>();
		if(root==null)
			return null;
		
		while(root!=null) {
			if(data<root.data) {
				root = root.left;
				path.add(root.data);
			}
			else if(data>root.data) {
				root = root.right;
				path.add(root.data);
			}
			else
				break;
		}
		
		return path;
		
	}
	
	private static Node findLCA(Node root, Node node1, Node node2) {
		if(root==null)
			return null;
		
		if(root==node1 || root==node2 )
			return root;
		
		Node left = findLCA(root.left, node1, node2);
		Node right = findLCA(root.right, node1, node2);
		
		if(left!=null && right!=null)
			return root;
		
		if(left!=null)
			return left;
		else
			return right;
	}

}
