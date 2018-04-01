package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {
	
	Node root;
	
	public BinaryTree(){
		this.root=null;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.inorder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		System.out.println();
		//System.out.println(tree.height(tree.root));
		tree.levelOrder(tree.root, tree.height(tree.root));
		System.out.println();
		tree.levelOrderQueue(tree.root);
		System.out.println("\nPre order iterative");
		tree.preOrderIterative(tree.root);
	}
	
	private void preOrderIterative(Node root) {
		if(root==null)
			return;
		
		Stack<Node> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.data+" ");
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
			
		}
	}
	
	public void levelOrderQueue(Node root) {
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(node.data+ " ");
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
		}
	}
	
	private int height(Node node){
		if(node==null)
			return 0;
		
		int lh = height(node.left);
		int rh = height(node.right);
		if(lh>rh)
			return lh+1;
		else
			return rh+1;
	}
	
	public void inorder(Node node){
		if(node==null)
			return;
		
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
		
	}
	
	private void preOrder(Node node){
		if(node==null)
			return;
		
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private void postOrder(Node node){
		if(node==null)
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
		
	}
	
	private void levelOrder(Node node,int height){
		if(node==null)
			return;
		
		for(int i=1;i<=height;i++)
			printLevel(node,i);
	}

	private void printLevel(Node node, int i) {
		if(node==null || i==0)
			return;
		if(i==1)
			System.out.print(node.data+" ");
		
		printLevel(node.left,i-1);
		printLevel(node.right,i-1);
	}
	
	public static BinaryTree intialize() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		return tree;
	}

}
