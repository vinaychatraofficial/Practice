package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTree {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize3();
		printZigZag(tree.root);
	}
	
	private static void printZigZag(Node root){
		if(root==null)
			return;
		
		Stack<Node> s1 = new Stack();
		Stack<Node> s2 = new Stack();
		s1.add(root);
		
		boolean leftToRight = true;
		
		while(!s1.isEmpty()){
			Node node = s1.pop();
			System.out.println(node.data);
			
			if(leftToRight){
				if(node.left!=null)
					s2.push(node.left);
				if(node.right!=null)
					s2.push(node.right);
			}else{
				if(node.right!=null)
					s2.push(node.right);
				if(node.left!=null)
					s2.push(node.left);
			}
			
			if(s1.isEmpty()){
				leftToRight= !leftToRight;
				Stack temp = s1;
				s1=s2;
				s2=temp;
			}
		}
	}
	
	

}
