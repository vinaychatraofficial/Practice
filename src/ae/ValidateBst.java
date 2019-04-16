package ae;

public class ValidateBst {
	public static boolean validateBst(BST tree) {
	    return validateBst(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
	  }
		
		private static boolean validateBst(BST tree, int min, int max){
			boolean isBST = tree.value >= min && tree.value<max;
			if(!isBST)
				return isBST;
			if(tree.left!=null)
				isBST = isBST && validateBst(tree.left,min, tree.value);
			if(tree.right!=null)
				isBST = isBST && validateBst(tree.right, tree.value,max);
			return isBST;
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
