package trees;

public class MakeMirror {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		tree.inorder(tree.root);
		makeMirror(tree.root);
		System.out.println();
		tree.inorder(tree.root);
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
