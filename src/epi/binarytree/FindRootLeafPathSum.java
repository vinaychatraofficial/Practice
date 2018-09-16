package epi.binarytree;

/**
 * @author vcpaks
 * 9.6 Find a root to leaf path with specified sum
 */
public class FindRootLeafPathSum {

	public static void main(String[] args) {

		BinaryTreeNode zero = new BinaryTreeNode(0);
		BinaryTreeNode one = new BinaryTreeNode(1);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode four = new BinaryTreeNode(4);
		BinaryTreeNode five = new BinaryTreeNode(5);
		BinaryTreeNode six = new BinaryTreeNode(6);
		BinaryTreeNode seven = new BinaryTreeNode(7);
		BinaryTreeNode eight = new BinaryTreeNode(8);
		BinaryTreeNode nine = new BinaryTreeNode(9);
		
		zero.left=one;
		zero.right=two;
		one.left=three;
		one.right=four;
		three.left=seven;
		three.right=eight;
		two.left=five;
		two.right=six;
		four.left=nine;
		
		System.out.println(hasSum(zero, 12, 0));
	
	}
	
	private static boolean hasSum(BinaryTreeNode root, int sum, int partialSum) {
		if(root==null)
			return false;
		
		partialSum+=root.data;
		
		if(root.left==null && root.right==null)
			return sum==partialSum;
		
		return hasSum(root.left, sum, partialSum) || hasSum(root.right, sum, partialSum);
	}

}
