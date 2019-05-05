package ae;

public class GetYoungestCommonAncestor {

	public static AncestralTree getYoungestCommonAncestor(
			AncestralTree topAncestor, 
			AncestralTree descendantOne, 
			AncestralTree descendantTwo
			) {
		int d1 = findDepth(descendantOne, topAncestor);
		int d2 = findDepth(descendantTwo, topAncestor);
		if(d1 < d2){
			int diff = d2-d1;
			while(diff>0){
				descendantTwo = descendantTwo.ancestor;
				diff--;
			}
		}else if(d1 > d2){
			int diff = d1-d2;
			while(diff>0){
				descendantOne = descendantOne.ancestor;
				diff--;
			}
		}
		while(descendantTwo!=descendantOne){
			descendantTwo = descendantTwo.ancestor;
			descendantOne = descendantOne.ancestor;
		}
		return descendantOne;
	} 

	private static int findDepth(AncestralTree descendant, AncestralTree topAncestor){
		int depth = 0;
		AncestralTree cur = descendant;
		while(cur!=topAncestor){
			cur = cur.ancestor;
			depth++;
		}
		return depth;
	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		// This method is for testing only.
		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}
}
