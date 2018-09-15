package epi.binarytree;

/**
 * @author vcpaks
 * Compute the LCA when nodes have parent pointers
 */
public class LCAWithParent {

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
		four.left=nine;
		nine.parent=four;
		System.out.println(computeLCA(seven, nine).data);
	
	}
	
	private static BinaryTreeNodeParent computeLCA(BinaryTreeNodeParent node1, BinaryTreeNodeParent node2) {
		int depth1 = getDepth(node1);
		int depth2 = getDepth(node2);
		
		int depthDiff = Math.abs(depth1-depth2);
		if(depth1>depth2) {
			while(depthDiff>0) {
				node1=node1.parent;
				depthDiff--;
			}
		}else {
			while(depthDiff>0) {
				node2=node2.parent;
				depthDiff--;
			}
		}
		
		while(node1!=node2) {
			node1 = node1.parent;
			node2 = node2.parent;
		}
		
		return node1;
	}

	private static int getDepth(BinaryTreeNodeParent node) {
		int depth=0;
		while(node.parent!=null) {
			depth++;
			node = node.parent;
		}
			
		return depth;
	}

}
