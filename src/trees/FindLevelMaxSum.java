package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindLevelMaxSum {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize2();
		System.out.println(findLevelMaxSum(tree.root));
	}
	
	private static int findLevelMaxSum(Node root){
		if(root==null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int sum=0;int maxSum=0;
		int level = 0,maxLevel=0;
		while(!q.isEmpty()){
			Node node = q.remove();
			
			if(node==null){
				level++;
				if(!q.isEmpty())
					q.add(null);
				if(sum>maxSum){
					maxSum = sum;
					maxLevel = level;
					sum=0;
				}
					
			}else{
				sum+=node.data;
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
			
		}
		System.out.println("max sum:"+maxSum);
		return maxLevel;
	}

}
