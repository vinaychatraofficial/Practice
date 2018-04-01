package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SearchMaxElement {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println(searchElem(tree.root,7));
		System.out.println(searchElemIt(tree.root,8));
	}
	
	private static boolean searchElem(Node root, int data) {
		if(root==null)
			return false;
		
		boolean found = false;
		
		if(root.data==data)
			return true;
		
		found = searchElem(root.left,data);
		if(!found)
			found = searchElem(root.right,data);
		
		return found;
	}
	
	private static boolean searchElemIt(Node root, int data) {
		if(root==null)
			return false;
		
		Queue q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node node = (Node) q.remove();
			if(node.data==data)
				return true;
			
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
				
		}
		
		return false;
	}

}
