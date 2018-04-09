package trees;

public class CheckMirror {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		tree.inorder(tree.root);
		makeMirror(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		BinaryTree tree2 = BinaryTree.intialize();
		System.out.println(checkMirror(tree.root, tree2.root));
	}
	
	private static boolean checkMirror(Node root1, Node root2){
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		
		return (root1.data==root2.data) && checkMirror(root1.left, root2.right) 
				&& checkMirror(root1.right,root2.left);
	}
	
	private static void makeMirror(Node root){
		if(root==null)
			return;
		makeMirror(root.left);
		makeMirror(root.right);
		Node temp;
		temp = root.left;
		root.left=root.right;
		root.right=temp;
		
	}

}
