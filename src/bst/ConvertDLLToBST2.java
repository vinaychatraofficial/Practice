package bst;

import trees.Node;

class DLLNode2{
	int data;
	DLLNode2 prev;
	DLLNode2 next;
	
	public DLLNode2(int data){
		this.data = data;
	}
}

public class ConvertDLLToBST2 {

	//static DLLNode2 dllRoot;
	
	public static void main(String[] args) {
		DLLNode2 dllRoot = new DLLNode2(1);
		DLLNode2 node = push(dllRoot, 2);
		node = push(node, 3);
		node = push(node, 4);
		node = push(node, 5);
		node = push(node, 6);
		node = push(node, 7);
		//printDLL(root);
		//findNode(3);
		//printDLL(root);
		//System.out.println(countNodes(root));
		DLLNode2 bstRoot = convertToBST(dllRoot, 0,countNodes(dllRoot)-1);
		preorder(bstRoot);
	}
	
	private static void preorder(DLLNode2 root){
		if(root==null)
			return;
		
		System.out.print(root.data+" ");
		preorder(root.prev);
		preorder(root.next);
	}
	
	private static DLLNode2 push(DLLNode2 node, int data){
		DLLNode2 newNode = new DLLNode2(data);
		newNode.prev = node;
		node.next = newNode;
		return newNode;
	}
	
	private static void printDLL(DLLNode2 root){
		while(root!=null){
			System.out.println(root.data);
			root=root.next;
		}
	}
	
	private static int countNodes(DLLNode2 root){
		int count=0;
		while(root!=null){
			root=root.next;
			count++;
		}
		return count;
	}
	
	private static DLLNode2 convertToBST(DLLNode2 dllRoot, int left, int right){
		if(left>right)
			return null;
		
		
		int mid = left+(right-left)/2;
		System.out.println("mid:"+mid);
		DLLNode2 midElem = findNode(dllRoot, mid);
		if(midElem!=null){
			midElem.prev = convertToBST(dllRoot, left, mid-1);
			midElem.next = convertToBST(dllRoot, mid+1, right);
		}
		return midElem;
	}

	private static DLLNode2 findNode(DLLNode2 dllRoot, int mid) {
		int count=0;
		DLLNode2 head = dllRoot;
		System.out.println("findNode root:"+head.data);
		while(count!=mid){
			System.out.println("traversing "+head.data);
			head = head.next;
			count++;
		}
		System.out.println("Returning "+head.data);
		return new DLLNode2(head.data);
	}

}
