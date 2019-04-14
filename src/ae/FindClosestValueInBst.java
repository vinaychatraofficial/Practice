package ae;

public class FindClosestValueInBst {
	 public static int findClosestValueInBst(BST tree, int target) {
		    BST cur = tree;
				int res = tree.value,minDiff = Integer.MAX_VALUE;
				while(cur!=null){
					if(Math.abs(cur.value-target)<minDiff){
						minDiff = Math.abs(cur.value-target);
						res = cur.value;
						//System.out.println(res);
					}
					if(cur.value<target)
						cur=cur.right;
					else if(cur.value>target)
						cur=cur.left;
					else
						return res;
					
				}
				return res;
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
