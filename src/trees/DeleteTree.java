package trees;

public class DeleteTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.inorder(tree.root);
		tree.root = deleteTree(tree.root);
		tree.inorder(tree.root);
	}
	
	private static Node deleteTree(Node root) {
		if(root==null)
			return null;
		
		deleteTree(root.left);
		deleteTree(root.right);
		System.out.println("Deleting "+root.data);
		root=null;
		return root;
	}

}
