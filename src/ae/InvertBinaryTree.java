package ae;

import java.util.Stack;

public class InvertBinaryTree {
	public static void invertBinaryTree(BinaryTree tree) {
	    	//invertBinaryTreeRec(tree);
			invertBinaryTreeIt(tree);
	  }
		
		private static void invertBinaryTreeRec(BinaryTree tree) {
			if(tree==null)
				return;
			BinaryTree temp = tree.left;
			tree.left=tree.right;
			tree.right=temp;
			
			invertBinaryTreeRec(tree.left);
			invertBinaryTreeRec(tree.right);
		}
		
		private static void invertBinaryTreeIt(BinaryTree tree) {
			Stack<BinaryTree> stack = new Stack<>();
			stack.push(tree);
			while(!stack.isEmpty()){
				BinaryTree cur = stack.pop();
				if(cur==null)
					continue;
				BinaryTree temp = cur.left;
				cur.left = cur.right;
				cur.right = temp;
				if(cur.right!=null)
					stack.push(cur.right);
				if(cur.left!=null)
					stack.push(cur.left);
			}
		}

	  static class BinaryTree {
	    public int value;
	    public BinaryTree left;
	    public BinaryTree right;

	    public BinaryTree(int value) {
	      this.value = value;
	    }
	  }  
}
