package trees;

public class ConstructTreeInPre {
	
	static int preorderIndex=0;

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		//tree.inorder(tree.root);
		//tree.preOrder(tree.root);
		int[] inorder = {4,2,5,1,3};
		int[] preorder = {1,2,4,5,3};
		Node newTree = constructTree(inorder, preorder, 0, inorder.length-1);
		tree.inorder(newTree);
	}
	
	private static Node constructTree(int[] inorder, int[] preorder,int start, int end) {
		//if(preorderIndex>=preorder.length)
		//	return null;
		if(start>end)
			return null;
		
		Node node = new Node(preorder[preorderIndex]);
		if(start==end)
			return node;
		int inorderIndex = 0;
		for(int i=start;i<=end;i++) {
			if(inorder[i]==preorder[preorderIndex]) {
				inorderIndex=i;
				break;
			}
		}
		preorderIndex++;
		System.out.println("inorder index:"+inorderIndex);
		Node left =constructTree(inorder, preorder, start, inorderIndex-1);
		node.left=left;
		preorderIndex++;
		System.out.println(left.data+" is to the left of "+node.data);
		System.out.println("Searching for right between "+(inorderIndex+1)+ " and "+end);
		Node right=constructTree(inorder, preorder, inorderIndex+1, end);
		node.right=right;
		System.out.println(right.data+" is to the right of "+node.data);
		return node;
			
	}

}
