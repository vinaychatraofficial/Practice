package trees;

class Node{
	int data;
	Node left, right;
	
	public Node(int data){
		this.data = data;
		this.left=this.right=null;
	}
}

public class BinaryTree {
	
	Node root;
	
	public BinaryTree(){
		this.root=null;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.inorder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
	
	private void inorder(Node node){
		if(node==null)
			return;
		
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
		
	}
	
	private void preOrder(Node node){
		if(node==null)
			return;
		
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private void postOrder(Node node){
		if(node==null)
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
		
	}
	
	private void levelOrder(Node node){
		if(node==null)
			return;
		
		
	}

}
