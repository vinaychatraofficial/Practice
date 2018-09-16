package epi.binarytree;

/**
 * @author vcpaks
 * 9.1 Test if a binary tree is height balanced
 */
public class HeightBalance {

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
		
		System.out.println(isBalanced(zero));
	}
	
	private static class BalancedHeight{
		boolean isBalanced;
		int height;
		public BalancedHeight(boolean isBalanced, int height) {
			super();
			this.isBalanced = isBalanced;
			this.height = height;
		}
		
		
	}
	
	private static boolean isBalanced(BinaryTreeNode root) {
		return checkBalanced(root).isBalanced;
	}
	
	private static BalancedHeight checkBalanced(BinaryTreeNode root) {
		if(root==null)
			return new BalancedHeight(true, -1);
		
		BalancedHeight left = null,right = null,max;
		left = checkBalanced(root.left);
		
		if(!left.isBalanced)
			return left;
		
		right = checkBalanced(root.right);
		
		if(!right.isBalanced)
			return right;
		
		int maxHeight = Math.max(left.height, right.height) +1;
		boolean isBalanced=true;
		if(Math.abs(left.height-right.height)>1)
			isBalanced=false;
		return new BalancedHeight(isBalanced, maxHeight);
	}

}
