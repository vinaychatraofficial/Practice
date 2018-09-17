package epi.binarytree;

public class FindSuccessor {

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
		System.out.println(findSuccessor(zero).data);
	
	}
	
	private static BinaryTreeNodeParent findSuccessor(BinaryTreeNodeParent root){
		if(root==null)
			return null;
		
		if(root.right!=null){
			BinaryTreeNodeParent curr = root.right;
			while(curr.left!=null)
				curr = curr.left;
			
			return curr;
		}else{
			BinaryTreeNodeParent curr = root;
			while(curr.parent!=null){
				BinaryTreeNodeParent parent = curr.parent;
				if(parent.left==curr)
					return parent;
				curr=parent;	
			}
		}
		return null;
	}

}
