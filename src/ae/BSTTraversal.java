package ae;

import java.util.ArrayList;

public class BSTTraversal {
	public static ArrayList<Integer> inOrderTraverse(BST tree, ArrayList<Integer> array) {
	    if(tree.left!=null)
				inOrderTraverse(tree.left, array);
			array.add(tree.value);
			if(tree.right!=null)
				inOrderTraverse(tree.right, array);
			return array;
	  }

	  public static ArrayList<Integer> preOrderTraverse(BST tree, ArrayList<Integer> array) {
	    array.add(tree.value);
			if(tree.left!=null)
				preOrderTraverse(tree.left, array);
			
			if(tree.right!=null)
				preOrderTraverse(tree.right, array);
			return array;
	  }

	  public static ArrayList<Integer> postOrderTraverse(BST tree, ArrayList<Integer> array) {
	    if(tree.left!=null)
				postOrderTraverse(tree.left, array);
			if(tree.right!=null)
				postOrderTraverse(tree.right, array);
			array.add(tree.value);
			return array;
	  }

	  static class BST {
	    public int value;
	    public BST left;
	    public BST right;

	    public BST(int value) {
	      this.value = value;
	    }
	  }
}
