package epi.binarytree;

/**
 * @author vcpaks
 * 9.5 Sum binary numbers represented by root to leaf paths
 */
public class SumRootLeafPaths {

	public static void main(String[] args) {
		BinaryTreeNode A = new BinaryTreeNode(1);
		BinaryTreeNode B = new BinaryTreeNode(0);
		BinaryTreeNode C = new BinaryTreeNode(0);
		A.left=B;
		A.right=C;
		BinaryTreeNode D = new BinaryTreeNode(0);
		BinaryTreeNode E = new BinaryTreeNode(0);
		B.right=D;
		C.right=E;
		BinaryTreeNode F = new BinaryTreeNode(1);
		BinaryTreeNode G = new BinaryTreeNode(0);
		D.left=F;
		D.right=G;
		BinaryTreeNode H = new BinaryTreeNode(1);
		F.right=H;
		System.out.println(sum(A,0));
	}
	
	private static int sum(BinaryTreeNode root, int sum) {
		if(root==null)
			return 0;
		
		sum=sum*2+root.data;
		if(root.left==null && root.right==null)
			return sum;
		
		return sum(root.left,sum)+sum(root.right,sum);
	}

}
