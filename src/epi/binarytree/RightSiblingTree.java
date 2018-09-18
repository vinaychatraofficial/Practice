package epi.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author vcpaks
 * 9.16 Compute the right sibling tree
 */
public class RightSiblingTree {

	public static void main(String[] args) {

		BinaryTreeNodeNext zero = new BinaryTreeNodeNext(0);
		BinaryTreeNodeNext one = new BinaryTreeNodeNext(1);
		BinaryTreeNodeNext two = new BinaryTreeNodeNext(2);
		BinaryTreeNodeNext three = new BinaryTreeNodeNext(3);
		BinaryTreeNodeNext four = new BinaryTreeNodeNext(4);
		BinaryTreeNodeNext five = new BinaryTreeNodeNext(5);
		BinaryTreeNodeNext six = new BinaryTreeNodeNext(6);
		BinaryTreeNodeNext seven = new BinaryTreeNodeNext(7);
		BinaryTreeNodeNext eight = new BinaryTreeNodeNext(8);
		BinaryTreeNodeNext nine = new BinaryTreeNodeNext(9);
		
		zero.left=one;
		zero.right=two;
		one.left=three;
		one.right=four;
		three.left=seven;
		three.right=eight;
		two.left=five;
		two.right=six;
		four.left=nine;
		
		BinaryTreeNodeNext root = compute(zero);
		preorder(root);
	
	}
	
	private static void preorder(BinaryTreeNodeNext root) {
		if(root==null)
			return;
		if(root.next!=null)
			System.out.println(root.data+" next is "+root.next.data);
		else
			System.out.println(root.data+" next is null");
		preorder(root.left);
		preorder(root.right);
	}

	private static BinaryTreeNodeNext compute(BinaryTreeNodeNext root) {
		BinaryTreeNodeNext curr,prev,start;
		prev=root;
		curr = prev.left;
		start=curr;
		while(curr!=null) {
			//left child
			if(curr==prev.left) {
				curr.next=prev.right;
				curr=curr.next;
			}else {
				curr.next=prev.next!=null?prev.next.left:null;
				prev=prev.next;
				curr=curr.next;
				if(curr==null) {
					prev=start;
					start=start.left;
					curr=start;
				}
			}
		}
		return root;
	}
	
	private static BinaryTreeNodeNext computeQ(BinaryTreeNodeNext root) {
		Queue<BinaryTreeNodeNext> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		BinaryTreeNodeNext prev = null;
		while(!q.isEmpty()) {
			BinaryTreeNodeNext cur = q.remove();
			if(prev!=null)
				prev.next=cur;
			if(cur==null && !q.isEmpty())
				q.add(null);
			else if(cur!=null){
				if(cur.left!=null) {
					q.add(cur.left);
				}
				if(cur.right!=null) {
					q.add(cur.right);
				}
			}
			prev=cur;
		}
		return root;
	}

}
