package ae;

public class RemoveKthNodeFromEnd {

	public static void removeKthNodeFromEnd(LinkedList head, int k) {
	    //removeKthNodeFromEndOne(head,k);
			removeKthNodeFromEndTwo(head,k);
	  }
		
		private static void removeKthNodeFromEndTwo(LinkedList head, int k) {
			LinkedList end = head;
			int count = 0;
			while(count<k){
				end = end.next;
				count++;
			}
			
			LinkedList start=head,prev=null;
			if(end==null){
				head.value = head.next.value;
				head.next = head.next.next;
				return;
			}
				
			while(end!=null){
				end = end.next;
				prev=start;
				start=start.next;
			}
			prev.next = start.next;
			start.next=null;
		}
		
		private static void removeKthNodeFromEndOne(LinkedList head, int k) {
	    int n=0;
			LinkedList cur = head;
			while(cur!=null){
				n++;
				cur=cur.next;
			}
			

			if(k==n){
				head.value = head.next.value;
				head.next = head.next.next;
				return;
			}
			
			LinkedList prev=null;
			cur = head;
			for(int i=0;i<n-k;i++){
				prev=cur;
				cur = cur.next;
			}
			
			prev.next = cur.next;
			cur.next = null;
			
	  }

	  static class LinkedList {
	    int value;
	    LinkedList next = null;

	    public LinkedList(int value) {
	      this.value = value;
	    }
	  }
}
