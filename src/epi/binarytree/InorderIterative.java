package epi.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author vcpaks
 * 9.7 Inorder traversal without recursion
 */
public class InorderIterative {

	public static void main(String[] args) {
		BinaryTreeNode zero = new BinaryTreeNode(0);
		BinaryTreeNode one = new BinaryTreeNode(1);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode four = new BinaryTreeNode(4);
		BinaryTreeNode five = new BinaryTreeNode(5);
		BinaryTreeNode six = new BinaryTreeNode(6);
		BinaryTreeNode seven = new BinaryTreeNode(7);
		BinaryTreeNode eight = new BinaryTreeNode(8);
		BinaryTreeNode nine = new BinaryTreeNode(9);
		
		zero.left=one;
		zero.right=two;
		one.left=three;
		one.right=four;
		three.left=seven;
		three.right=eight;
		two.left=five;
		two.right=six;
		four.right=nine;
		
		System.out.println(inorder1(zero));
	}
	
	private static List<Integer> inorder(BinaryTreeNode root){
		List<Integer> result = new ArrayList<>();
		Stack<BinaryTreeNode> s = new Stack<>();
		BinaryTreeNode curr = root;
		
		while(!s.isEmpty()||curr!=null) {
			if(curr!=null) {
				s.push(curr);
				curr=curr.left;
			}else {
				curr = s.pop();
				result.add(curr.data);
				curr = curr.right;
			}
		}
		return result;
	}
	
	private static List<Integer> inorder1(BinaryTreeNode root){
		List<Integer> result = new ArrayList<>();
		Stack<BinaryTreeNode> s = new Stack<>();
		s.push(root);
		BinaryTreeNode curr=root;
		while(!s.isEmpty()) {
			if(curr.left!=null) {
				s.push(curr.left);
				curr=curr.left;
			}else {
				curr = s.pop();
				result.add(curr.data);
				if(curr.right!=null) {
					s.push(curr.right);
					curr=curr.right;
				}
			}
		}
		return result;
	}

}
