package epi.binarytree;

/**
 * @author vcpaks
 * 10.3 Compute the LCA in a binary tree
 */
public class FindLCA {

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
		System.out.println(computeLCA(zero, seven, nine).data);
	}
	
	private static class LCA{
		int nodes;
		BinaryTreeNode lca;
		public LCA(int nodes, BinaryTreeNode lca) {
			super();
			this.nodes = nodes;
			this.lca = lca;
		}
		
		
	}
	
	private static BinaryTreeNode computeLCA(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		return findLCA(root, node1, node2).lca;
	}

	private static LCA findLCA(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		if(root==null)
			return new LCA(0, null);
		
		LCA leftLCA = findLCA(root.left, node1, node2);
		if(leftLCA.nodes==2)
			return leftLCA;
		LCA rightLCA = findLCA(root.right, node1, node2);
		if(rightLCA.nodes==2)
			return rightLCA;
		
		int noOfNodes = leftLCA.nodes + rightLCA.nodes;
		
		if(noOfNodes==2)
				return new LCA(2, root);
		
		if(root==node1||root==node2)
			noOfNodes++;
		
		return new LCA(noOfNodes, noOfNodes==2?root:null);
	}

}
