package trees;

import java.util.LinkedList;
import java.util.Queue;

public class NextSibling {

	public static void main(String[] args) {
		SNode root = new SNode(1);
		root.left = new SNode(2);
		root.right = new SNode(3);
		root.left.left = new SNode(4);
		root.left.right = new SNode(5);
		root.right.left = new SNode(6);
		root.right.right = new SNode(7);
		//populateNextSibling(root);
		populateNextSiblingRec(root);

	}
	
	private static void populateNextSibling(SNode root){
		if(root==null)
			return;
		
		Queue<SNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()){
			SNode node = q.remove();
			
			
			if(node==null){
				if(!q.isEmpty())
					q.add(null);
			}else{
				if(!q.isEmpty()){
					node.nextSibling = q.peek();
				}
				if(node.nextSibling!=null)
					System.out.println(node.data+" has "+node.nextSibling.data);
				if(node.left!=null){
					q.add(node.left);
				}
				if(node.right!=null){
					q.add(node.right);
				}
			}
		}
	}
	
	private static void populateNextSiblingRec(SNode root){
		if(root==null)
			return;
		
		if(root.nextSibling!=null)
			System.out.println(root.data+" has "+root.nextSibling.data);
		
		if(root.left!=null)
			root.left.nextSibling = root.right;
		
		if(root.right!=null && root.nextSibling!=null)
			root.right.nextSibling = root.nextSibling.left;
		
		populateNextSiblingRec(root.left);
		populateNextSiblingRec(root.right);
		
		
	}
	

}

class SNode{
	int data;
	SNode left, right, nextSibling;
	
	public SNode(int data){
		this.data = data;
		this.left=this.right=this.nextSibling=null;
	}
}

