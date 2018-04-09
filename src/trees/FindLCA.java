package trees;

public class FindLCA {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		Node lca = findLCA(tree.root, tree.root.left, tree.root.left.left);
		System.out.println(lca.data);
		
	}
	
	private static Node findLCA(Node root, Node x, Node y){
		if(root==null)
			return null;
		
		if(root==x||root==y){
			return root;
		}
		
		Node left = findLCA(root.left,x,y);
		Node right = findLCA(root.right,x,y);
		if(left!=null && right!=null)
			return root;
		
		if(left!=null)
			return left;
		else
			return right;
	}

}
