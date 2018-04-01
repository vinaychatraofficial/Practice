package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindHeight {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.intialize();
		System.out.println(findHeightIt(bt.root));
	}
	
	private static int findHeight(Node root) {
		if(root==null)
			return 0;
		
		return Math.max(findHeight(root.left), findHeight(root.right))+1;
	}
	
	private static int findHeightIt(Node root) {
		if(root==null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		int heightCount=0;
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			if(node==null) {
				if(!q.isEmpty())
					q.add(null);
				heightCount++;
			} else {
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
		}
		
		return heightCount;
	}

}
