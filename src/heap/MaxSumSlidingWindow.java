package heap;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class MaxSumSlidingWindow {

	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7};
		int windowSize = 3;
		int[] out = calculateMaxSlidingWindow(arr, windowSize, 8);
		for(int elem:out)
			System.out.print(elem+" ");
	}
	
	private static int[] calculateMaxSlidingWindow(int[] input, int windowSize, int size) {
		Deque<Integer> dequeue = new LinkedList<>();
		int[] out = new int[size-windowSize+1];
		for(int i=0;i<windowSize;i++) {
			while(!dequeue.isEmpty() && input[i]>=input[dequeue.peekLast()])
				dequeue.removeLast();
			dequeue.addLast(i);
		}
		out[0]=input[dequeue.peekFirst()];
		printDequeue(dequeue);
		for(int i=windowSize;i<size;i++) {
			while(!dequeue.isEmpty() && dequeue.peekFirst()<=(i-windowSize))
				dequeue.removeFirst();
			while(!dequeue.isEmpty() && input[i]>=input[dequeue.peekLast()])
				dequeue.removeLast();
			dequeue.addLast(i);
			out[i-windowSize+1]=input[dequeue.peekFirst()];
		}
		return out;
	}
	
	private static void printDequeue(Deque<Integer> dequeue) {
		Iterator<Integer> it = dequeue.iterator();
		System.out.println("Dequeue contents");
		while(it.hasNext())
			System.out.print(it.next()+" ");
		System.out.println();
	}

}
