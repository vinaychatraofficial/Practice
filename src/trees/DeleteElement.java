package trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteElement {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		tree.inorder(tree.root);
		deleteElement(tree.root, 2);
		tree.inorder(tree.root);
	}
	
	private static void deleteElement(Node root, int data){
		if(root==null)
			return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node temp=null;
		Node searchNode = null;
		
		while(!q.isEmpty()){
			Node node = q.remove();
			temp = node;
			if(temp.data==data)
				searchNode=node;
			
			if(node.left!=null)
				q.add(node.left);
			
			if(node.right!=null)
				q.add(node.right);
		}
		
		if(temp!=null&& searchNode!=null){
			System.out.println("Deleting node "+temp.data);
			deleteDeepestNode(root,temp);
			searchNode.data=temp.data;
			
		}
	}

	private static void deleteDeepestNode(Node root, Node deepestNode) {
		if(root==null)
			return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node node = q.remove();
			
			if(node.left!=null){
				if(node.left==deepestNode){
					System.out.println("Deleting node "+node.left.data);
					node.left=null;
				}else{
					q.add(node.left);
				}
			}
			
			if(node.right!=null){
				if(node.right==deepestNode){
					System.out.println("Deleting node "+node.right.data);
					node.right=null;
				}else{
					q.add(node.right);
				}
			}
		}
	}

}
