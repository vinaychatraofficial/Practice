package bst;

class DLLNode{
	DLLNode prev;
	DLLNode next;
	int data;
	
	public DLLNode(int data) {
		this.data=data;
	}
}

public class ConvertDLLSBST {
	static DLLNode head;
	public static void main(String args[]) {
		head = new DLLNode(1);
		add(head,2);
		add(head,3);
		add(head,4);
		add(head,5);
		add(head,6);
		add(head,7);
		printList(head);
		
		int count = countNodes(head);
		printList(head);
		DLLNode root = constructBST( count);
		System.out.println("Printing BST");
		printPreorder(root);
		System.out.println();
		printBST(root);
	}
	
	private static void printBST(DLLNode root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		printBST(root.next);
	}
	
	private static void printPreorder(DLLNode root) {
		if(root==null)
			return;
		
		System.out.print(root.data+" ");
		printPreorder(root.prev);
		printPreorder(root.next);
	}
	
	private static int countNodes(DLLNode head) {
		int count=0;
		while(head!=null) {
			head=head.next;
			count++;
		}
		return count;
	}

	private static DLLNode constructBST(int count){
		if(count<=0 || head==null)
			return null;
		DLLNode left = constructBST(count/2);
		DLLNode root = head;
		root.prev=left;
		head = head.next;
		root.next = constructBST( count-count/2-1);
		return root;
		
	}
	
	private static void add(DLLNode node, int data) {
		DLLNode prev = null;
		while(node!=null) {
			prev=node;
			node=node.next;
		}
		node = new DLLNode(data);
		node.prev=prev;
		prev.next = node;
	}
	
	private static void printList(DLLNode head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
	}

}
