package epi.heap;

import java.util.PriorityQueue;

/**
 * @author vcpaks
 * 10.7 Implement stack api using a heap
 */
public class StackUsingHeap {
	
	private PriorityQueue<Element> maxHeap = new PriorityQueue<>();
	private int priority=0;

	public static void main(String[] args) {
		StackUsingHeap stack = new StackUsingHeap();
		stack.push(1);
		stack.push(2);
		stack.push(8);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	private static class Element implements Comparable<Element>{
		int value;
		int priority;
		
		public Element(int value, int priority) {
			super();
			this.value = value;
			this.priority = priority;
		}

		@Override
		public int compareTo(Element o) {
			return Integer.compare(o.priority, this.priority);
		}
		
		
	}
	
	private void push(int value) {
		maxHeap.add(new Element(value,priority++));
	}
	
	private Integer pop() {
		if(maxHeap.peek()!=null) {
			return maxHeap.poll().value;
		}
		return null;
	}
	
	private Integer peek() {
		return maxHeap.peek().value;
	}

}
