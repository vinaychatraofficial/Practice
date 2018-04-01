package trees;

import java.util.LinkedList;
import java.util.Queue;

public class InsertElement {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println("Before insertion:");
		inOrder(tree.root);
		insertElement(tree.root, 6);;
		System.out.println("After insertion:");
		inOrder(tree.root);
	}
	
	private static Node insertElement(Node root, int data) {
		if(root==null) {
			root = new Node(data);
			return root;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			if(node.left!=null)
				q.add(node.left);
			else {
				Node newNode = new Node(data);
				node.left=newNode;
				return root;
			}
			
			if(node.right!=null)
				q.add(node.right);
			else {
				Node newNode = new Node(data);
				node.right=newNode;
				return root;
			}
				
		}
		
		return root;
		
	}
	
	private static void inOrder(Node root) {
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
		
	}
	

}
