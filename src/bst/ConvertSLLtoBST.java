package bst;

import trees.Node;

class ListNode{
	ListNode next;
	int data;
	
	public ListNode(int data) {
		this.data = data;
	}
}

public class ConvertSLLtoBST {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node = addToList(head, 2);
		node =  addToList(node, 3);
		node =  addToList(node, 4);
		node =  addToList(node, 5);
		node =  addToList(node, 6);
		node =  addToList(node, 7);
		//printList(head);
		//System.out.println(countNode(head));
		Node root = convertToBST(head, 0, countNode(head)-1);
		preorder(root);
	}
	
	private static void preorder(Node root) {
		if(root==null)
			return;
		
		System.out.println(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}

	private static void printList(ListNode head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	private static int countNode(ListNode head) {
		int count=0;
		while(head!=null) {
			count++;
			head = head.next;
		}
		return count;
	}

	private static ListNode addToList(ListNode prevNode, int data) {
		ListNode newNode = new ListNode(data);
		prevNode.next = newNode;
		return newNode;
	}
	
	private static Node convertToBST(ListNode head, int left, int right) {
		if(left>right)
			return null;
		
		int mid = left+(right-left)/2;
		Node root = findNode(head,mid);
		root.left = convertToBST(head, left, mid-1);
		root.right = convertToBST(head, mid+1, right);
		return root;
	}

	private static Node findNode(ListNode head, int mid) {
		ListNode node = head;
		int count=0;
		while(count!=mid) {
			node=node.next;
			count++;
		}
		return new Node(node.data);
	}

}
