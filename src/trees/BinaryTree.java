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
		System.out.println();
		//System.out.println(tree.height(tree.root));
		tree.levelOrder(tree.root, tree.height(tree.root));
	}
	
	private int height(Node node){
		if(node==null)
			return 0;
		
		int lh = height(node.left);
		int rh = height(node.right);
		if(lh>rh)
			return lh+1;
		else
			return rh+1;
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
	
	private void levelOrder(Node node,int height){
		if(node==null)
			return;
		
		for(int i=1;i<=height;i++)
			printLevel(node,i);
	}

	private void printLevel(Node node, int i) {
		if(node==null || i==0)
			return;
		if(i==1)
			System.out.print(node.data+" ");
		
		printLevel(node.left,i-1);
		printLevel(node.right,i-1);
	}

}
