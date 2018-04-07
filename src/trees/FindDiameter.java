package trees;

//https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
public class FindDiameter {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize2();
		
		System.out.println(findDiameter(tree.root));
	}

	private static int findDiameter(Node root){
		if(root==null)
			return 0;
		
		int left = findDiameter(root.left);
		int right = findDiameter(root.right);
		
		int lHeight = findHeight(root.left);
		int rHeight = findHeight(root.right);
		
		int totalHeight = lHeight+rHeight+1;
		
		return Math.max(totalHeight,Math.max(left, right));
	}

	private static int findHeight(Node root) {
		if(root==null)
			return 0;
		return 1+Math.max(findHeight(root.left), findHeight(root.right));
	}
}
