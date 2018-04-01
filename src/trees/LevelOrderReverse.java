package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderReverse {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		tree.levelOrderQueue(tree.root);
		System.out.println();
		levelOrderReverse(tree.root);
	}
	
	private static void levelOrderReverse(Node root) {
		if(root==null)
			return;
		
		Queue q = new LinkedList<>();
		Stack stack = new Stack();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node node = (Node) q.remove();
			stack.push(node);
			
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
		}
		
		while(!stack.isEmpty()) {
			Node node = (Node) stack.pop();
			System.out.print(node.data+" ");
		}
	}

}
