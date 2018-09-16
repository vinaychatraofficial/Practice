package epi.binarytree;

/**
 * @author vcpaks
 * 9.2 Test if a binary tree is symmetric
 */
public class CheckTreeSymmetry {

	public static void main(String[] args) {
		
		BinaryTreeNode zero = new BinaryTreeNode(0);
		BinaryTreeNode one = new BinaryTreeNode(1);
		BinaryTreeNode two = new BinaryTreeNode(1);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode four = new BinaryTreeNode(4);
		BinaryTreeNode five = new BinaryTreeNode(4);
		BinaryTreeNode six = new BinaryTreeNode(3);
		BinaryTreeNode seven = new BinaryTreeNode(7);
		BinaryTreeNode nine = new BinaryTreeNode(7);
		
		zero.left=one;
		zero.right=two;
		one.left=three;
		one.right=four;
		two.left=five;
		two.right=six;
		three.left=seven;
		six.right=nine;
		
		System.out.println(checkSymmetry(zero));

	}
	
	private static boolean checkSymmetry(BinaryTreeNode root) {
		return checkSymmetry(root.left,root.right);
	}

	private static boolean checkSymmetry(BinaryTreeNode left, BinaryTreeNode right) {
		if(left==null && right==null)
			return true;
		
		if(left!=null && right!=null)
			return left.data==right.data &&
			checkSymmetry(left.left,right.right) &&
			checkSymmetry(left.right,right.left);
			
		return false;
	}

}
