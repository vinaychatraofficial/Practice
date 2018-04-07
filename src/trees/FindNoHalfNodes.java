package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindNoHalfNodes {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize1();
		System.out.println(findNoHalfNodes(tree.root));
	}

	private static int findNoHalfNodes(Node root){
		if(root==null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int halfNodeCount = 0;
		
		while(!q.isEmpty()){
			Node node = q.remove();
			if(node.left!=null){
				q.add(node.left);
				if(node.right==null)
					halfNodeCount++;
			}
			
			if(node.right!=null){
				q.add(node.right);
				if(node.left==null)
					halfNodeCount++;
			}
		}
		
		return halfNodeCount;
	}
}
