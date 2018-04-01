package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxElement {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println(findMax(tree.root));
		System.out.println(findMaxIt(tree.root));
	}
	
	private static int findMax(Node root) {
		if(root==null)
			return Integer.MIN_VALUE;
		
		int max=Integer.MIN_VALUE,lVal=Integer.MIN_VALUE,rVal=Integer.MIN_VALUE;
		
		int rootVal = root.data;
		
		if(root.left!=null)
			lVal = findMax(root.left);
		if(root.right!=null)
			rVal = findMax(root.right);
		
		max=Math.max(lVal, rVal);
		max=Math.max(max, rootVal);
		
		return max;
		
	}
	
	private static int findMaxIt(Node root) {
		if(root==null)
			return Integer.MIN_VALUE;
		
		int max = Integer.MIN_VALUE;
		Queue q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node node = (Node) q.remove();
			
			if(node.data>max)
				max=node.data;
			
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
			
		}
		
		return max;
		
	}

}
