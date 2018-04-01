package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindSize {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println(findSizeIt(tree.root));
	}
	
	private static int findSize(Node root) {
		if(root==null)
			return 0;
		
		return findSize(root.left)+1+findSize(root.right);
	}
	
	private static int findSizeIt(Node root) {
		if(root==null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int count=0;
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			count++;
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
		}
		
		return count;
		
	}

}
