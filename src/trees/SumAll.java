package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumAll {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		System.out.println(sumAll(tree.root));
		System.out.println(sumAllIt(tree.root));
	}
	
	private static int sumAll(Node root){
		if(root==null)
			return 0;
		
		return root.data+sumAll(root.left)+sumAll(root.right);
	}
	
	private static int sumAllIt(Node root){
		if(root==null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int sum=0;
		
		while(!q.isEmpty()){
			Node node = q.remove();
			sum+=node.data;
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
		}
		return sum;
	}

}
