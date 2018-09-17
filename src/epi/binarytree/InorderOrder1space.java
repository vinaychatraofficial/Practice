package epi.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcprabha
 * Implement an inorder traversal with O(1) space
 */
public class InorderOrder1space {

	public static void main(String[] args) {



		BinaryTreeNodeParent zero = new BinaryTreeNodeParent(0);
		BinaryTreeNodeParent one = new BinaryTreeNodeParent(1);
		BinaryTreeNodeParent two = new BinaryTreeNodeParent(2);
		BinaryTreeNodeParent three = new BinaryTreeNodeParent(3);
		BinaryTreeNodeParent four = new BinaryTreeNodeParent(4);
		BinaryTreeNodeParent five = new BinaryTreeNodeParent(5);
		BinaryTreeNodeParent six = new BinaryTreeNodeParent(6);
		BinaryTreeNodeParent seven = new BinaryTreeNodeParent(7);
		BinaryTreeNodeParent eight = new BinaryTreeNodeParent(8);
		BinaryTreeNodeParent nine = new BinaryTreeNodeParent(9);
		
		zero.left=one;
		one.parent=zero;
		zero.right=two;
		two.parent=zero;
		one.left=three;
		three.parent=one;
		one.right=four;
		four.parent=one;
		three.left=seven;
		seven.parent=three;
		three.right=eight;
		eight.parent=three;
		two.left=five;
		five.parent=two;
		two.right=six;
		six.parent=two;
		four.right=nine;
		nine.parent=four;
		
		inorder(zero);
		System.out.println(inorder1(zero));
	
	}
	
	private static void inorder(BinaryTreeNodeParent root){
		BinaryTreeNodeParent cur = root;
		BinaryTreeNodeParent prevLeft = null;
		while(cur!=null){
			if(cur.left!=null && !(prevLeft!=null && prevLeft==cur.left)){
				cur=cur.left;
			}else if(cur.right!=null){
				System.out.print(cur.data+" ");
				cur = cur.right;
			}else{
				System.out.print(cur.data+" ");
				if(cur.parent!=null && cur.parent.left==cur){
					prevLeft=cur;
					cur=cur.parent;
				}else{
					boolean isFound = false;
					while(cur.parent!=null){
						BinaryTreeNodeParent parent = cur.parent;
						if(cur==parent.left){
							prevLeft=cur;
							cur=cur.parent;
							isFound=true;
							break;
						}
						cur=parent;
					}
					if(!isFound)
						break;
				}
			}
			
		}
	}
	
	private static List<Integer> inorder1(BinaryTreeNodeParent root){
		BinaryTreeNodeParent prev = null, next = null, cur=root;
		List<Integer> result = new ArrayList<>();
		while(cur!=null) {
			//top
			if(cur.parent==prev) {
				if(cur.left!=null)
					next=cur.left;
				else {
					result.add(cur.data);
					next = cur.right!=null?cur.right:cur.parent;
				}
			}else if(cur.left==prev) {// from left
				result.add(cur.data);
				next = cur.right!=null?cur.right:cur.parent;
			}else {//from right
				next=cur.parent;
			}
			prev=cur;
			cur=next;
		}
		return result;
	}

}
