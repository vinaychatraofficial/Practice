package trees;

class TreeNode{
	char data;
	TreeNode left, right;
	
	public TreeNode(char data) {
		this.data = data;
		this.left=this.right=null;
	}
}

public class BuildTree {
	
	static int preindex=0;

	public static void main(String[] args) {
		char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
	    char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
	    
	    TreeNode root = buildTree(pre,in,0, in.length-1);
	    
	    inOrder(root);
	}

	private static void inOrder(TreeNode root) {
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	private static TreeNode buildTree(char[] pre, char[] in, int start, int end) {
		if(start>end)
			return null;
		
		TreeNode node = new TreeNode(pre[preindex++]);
		if(start==end)
			return node;
		
		int index = search(in, node.data, start, end);
		
		node.left=buildTree(pre, in , start, index-1);
		node.right=buildTree(pre, in, index+1, end);
		return node;
		
	}

	private static int search(char[] in, char data, int start, int end) {
		for(int i=start;i<=end;i++) {
			if(in[i]==data)
				return i;
		}
			
		return 0;
	}

}
