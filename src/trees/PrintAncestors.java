package trees;

public class PrintAncestors {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		printAncestors(tree.root, 4);
	}
	
	private static boolean printAncestors(Node root, Integer searchNode){
		if(root==null)
			return false;
		
		if((root.left!=null && root.left.data==searchNode) || (root.right!=null &&root.right.data==searchNode) || printAncestors(root.left, searchNode) ||
				printAncestors(root.right, searchNode)){
			System.out.println(root.data);
			return true;
		}
		return false;
	}

}
