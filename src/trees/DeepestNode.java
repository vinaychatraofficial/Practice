package trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNode {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.intialize();
		System.out.println(findDeepest(bt.root));
	}
	
	private static int findDeepest(Node root) {
		if(root==null)
			return Integer.MIN_VALUE;
		
		int temp = Integer.MIN_VALUE;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			temp = node.data;
			
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
		}
		
		return temp;
		
	}

}
