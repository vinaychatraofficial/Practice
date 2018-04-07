package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindLevels {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		System.out.println(findLevels(tree.root));
	}
	
	private static int findLevels(Node root){
		if(root==null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int level =0;
		while(!q.isEmpty()){
			Node node = q.remove();
			if(node==null){
				level++;
				if(!q.isEmpty())
					q.add(null);
			}else{
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
		}
		return level;
		
	}

}
