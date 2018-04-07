package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindNoFullNodes {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		System.out.println(findNoFullNodes(tree.root));
	}
	
	private static int findNoFullNodes(Node root){
		if(root==null)
			return 0;
		
		int fullNodeCount=0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node node = q.remove();
			
			if(node.left!=null)
				q.add(node.left);
			
			if(node.right!=null)
				q.add(node.right);
			
			if(node.left!=null && node.right!=null){
				System.out.println(node.data);
				fullNodeCount++;
			}
		}
		return fullNodeCount;
	}

}
