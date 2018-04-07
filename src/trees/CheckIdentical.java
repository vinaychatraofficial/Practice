package trees;

public class CheckIdentical {

	public static void main(String[] args) {
		BinaryTree tree1 = BinaryTree.intialize();
		BinaryTree tree2 = BinaryTree.intialize1();
		System.out.println(checkIdentical(tree1.root, tree2.root));
	}
	
	private static boolean checkIdentical(Node root1, Node root2){
		if(root1==null && root2==null)
			return true;
		
		if(root1==null || root2==null)
			return false;
		
		if(root1.data!=root2.data)
			return false;
		else
			return (checkIdentical(root1.left,root2.left) && checkIdentical(root1.right, root2.right));
		
	}

}
