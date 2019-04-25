package ae;

public class FindLoop {

	public static LinkedList findLoop(LinkedList head) {
		LinkedList first = head, second=head;
		first = first.next;second = second.next.next;
		while(first!=second){
			first = first.next;
			second = second.next.next;
		}

		first = head;
		while(first!=second){
			first = first.next;
			second = second.next;
		}

		return first;

	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
