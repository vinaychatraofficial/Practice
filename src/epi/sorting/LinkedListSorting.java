package epi.sorting;

/**
 * @author vcpaks
 * 13.10 Implement a fast sorting algorithm for lists
 */
public class LinkedListSorting {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(7);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode result = mergeSort(l1);
		System.out.println(result);
		while(result!=null) {
			System.out.println(result.data);
			result = result.next;
		}
	}
	
	public static class ListNode{
		int data;
		ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private static ListNode insertionSort(ListNode l) {
		ListNode head = new ListNode(0);
		ListNode iter = head;
		head.next = l;
		while(iter!=null && iter.next!=null) {
			if(iter.data>iter.next.data) {
				ListNode pre = head;
				ListNode target = iter.next;
				while(pre.next.data<=target.data)
					pre=pre.next;
				ListNode temp = pre.next;
				iter.next = target.next;
				target.next = temp;
				pre.next = target;
			}else {
				iter=iter.next;
			}
		}
		return head.next;
	}
	
	private static ListNode mergeSort(ListNode l) {
		if(l==null||l.next==null)
			return l;
		ListNode slow = l,fast=l,prevSlow =null;
		while(fast!=null && fast.next!=null) {
			prevSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prevSlow.next = null;
		return merge(mergeSort(l),mergeSort(slow));
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while(l1!=null && l2!=null) {
			if(l1.data<=l2.data) {
				curr.next=l1;
				l1=l1.next;
			}else {
				curr.next=l2;
				l2=l2.next;
			}
			curr=curr.next;
		}
		if(l1!=null)
			curr.next=l1;
		else if(l2!=null)
			curr.next=l2;
		
		return head.next;
	}

}
