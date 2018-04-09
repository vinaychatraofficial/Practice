package trees;

import java.util.ArrayList;
import java.util.List;

public class FindPathWithSum {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		//System.out.println(findPathWithSum(tree.root, 7, new ArrayList<Integer>(), 0));
		System.out.println(findPathWithRemainingSum(tree.root, 4));
	}
	
	private static boolean findPathWithSum(Node root, int sum, List<Integer> nodeList, int index){
		if(root==null)
			return false;
		
		int tempSum = 0;
		for(int i=0;i<index;i++){
			tempSum+=nodeList.get(i);
		}
		System.out.println("Tempsum:"+tempSum+",sum:"+sum+",index:"+index);
		tempSum=tempSum+root.data;
		System.out.println("Tempsum after adding:"+tempSum);
		if(tempSum==sum){
			System.out.println("Found tempSum:"+tempSum);
			return true;
		}
		nodeList.add(root.data);
		index++;
		return findPathWithSum(root.left, sum, nodeList, index) ||findPathWithSum(root.right, sum, nodeList, index); 
	}
	
	private static boolean findPathWithRemainingSum(Node root, int sum){
		if(root==null)
			return false;
		
		sum = sum - root.data;
		if(sum==0)
			return true;
		else
			return findPathWithRemainingSum(root.left, sum) || findPathWithRemainingSum(root.right, sum);
	}

}
