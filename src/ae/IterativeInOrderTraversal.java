package ae;

import java.util.function.Function;

public class IterativeInOrderTraversal {

	public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
		BinaryTree cur = tree;
		BinaryTree prev = null,next=null;

		while(cur!=null){
			if(prev == cur.parent){
				if(cur.left!=null)
					next=cur.left;
				else{
					callback.apply(cur);
					next = cur.right!=null? cur.right:cur.parent;
				}
			}else if(prev == cur.left){
				callback.apply(cur);
				next = cur.right!=null ? cur.right:cur.parent;
			}else{
				next = cur.parent;
			}
			prev = cur;
			cur = next;
		}
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;
		public BinaryTree parent;

		public BinaryTree(int value) {
			this.value = value;
		}

		public BinaryTree(int value, BinaryTree parent) {
			this.value = value;
			this.parent = parent;
		}
	}
}
