package trees;



public class BST {
	
	Node root;
	

	public static void main(String[] args) {
		BST bst = new BST();
		bst.root = bst.insertBSTItr(bst.root, 4);
		bst.root = bst.insertBSTItr(bst.root, 2);
		bst.root = bst.insertBSTItr(bst.root, 1);
		bst.root = bst.insertBSTItr(bst.root, 3);
		bst.root = bst.insertBSTItr(bst.root, 8);
		bst.root = bst.insertBSTItr(bst.root, 7);
		bst.root = bst.insertBSTItr(bst.root, 6);
		
		bst.inOrder(bst.root);
		
		System.out.println(bst.searchBSTItr(bst.root, 3));
		bst.root = bst.removeBSTItr(bst.root, 3);
		bst.inOrder(bst.root);
		System.out.println(bst.searchBSTItr(bst.root, 3));
	}
	
	
	public Node removeBST(Node root, int data) {
		if(root==null)
			return root;
		
		if(data<root.data)
			root.left = removeBST(root.left,data);
		else if(data==root.data)
			root=null;
		else
			root.right = removeBST(root.right,data);
		
		return root;
	}
	
	public Node removeBSTItr(Node root, int data) {
		if(root==null)
			return root;
		
		Node curr=root;
		
		while(true) {
			
			if(data<curr.data) {
				if(curr.left!=null) 
					curr = curr.left;
				else
					return root;
			}else if(data==curr.data) {
				curr=null;
				return root;
			}else {
				if(curr.right!=null)
					curr=curr.right;
				else
					return root;
			}
			
		}
	}
	
	public Node insertBST(Node root, int data) {
		if(root==null) {
			root = new Node(data);
			return root;
		}
		
		if(data<=root.data)
			root.left = insertBST(root.left, data);
		else
			root.right = insertBST(root.right, data);
		return root;
					
	}
	
	public boolean searchBST(Node root, int data) {
		if(root==null)
			return false;
		
		if(data<root.data)
			return searchBST(root.left,data);
		else if(data==root.data)
			return true;
		else
			return searchBST(root.right,data);
		
	}
	
	public boolean searchBSTItr(Node root, int data) {
		if(root==null)
			return false;
		
		Node curr = root;
		while(true) {
			if(data<curr.data) {
				if(curr.left!=null)
					curr=curr.left;
				else
					return false;
			}else if(data==curr.data) {
				return true;
			}else {
				if(curr.right!=null)
					curr=curr.right;
				else
					return false;
			}
				
		}
	}
	
	public Node insertBSTItr(Node root, int data) {
		if(root==null) {
			root = new Node(data);
			return root;
		}
		
		Node curr = root;
		
		while(true) {
			if(data<=curr.data) {
				if(curr.left!=null)
					curr = curr.left;
				else {
					curr.left = new Node(data);
					break;
				}
					
			}else {
				if(curr.right!=null)
					curr=curr.right;
				else {
					curr.right = new Node(data);
					break;
				}
			}
		}
		
		return root;
	}
	
	private void inOrder(Node root) {
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

}
