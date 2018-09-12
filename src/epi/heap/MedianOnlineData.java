package epi.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author vcpaks
 * 10.5 Compute the median of online data
 */
public class MedianOnlineData {

	public static void main(String[] args) {
		List<Integer> data = new ArrayList<Integer>();
		/*data.add(4);
		data.add(3);
		data.add(2);
		data.add(0);
		data.add(-1);
		data.add(-2);*/
		data.add(-1);
		data.add(-2);
		data.add(0);
		data.add(2);
		data.add(3);
		data.add(4);
		computeMedian(data);
	}
	
	private static void computeMedian(List<Integer> data) {
		Iterator<Integer> iter = data.iterator();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		while(iter.hasNext()) {
			int x = iter.next();
			if(minHeap.isEmpty())
				minHeap.add(x);
			else {
				if(x>=minHeap.peek()) {
					if(minHeap.size()>maxHeap.size())
						maxHeap.add(minHeap.poll());
					minHeap.add(x);
				}else {
					if(maxHeap.size()>minHeap.size())
						minHeap.add(maxHeap.poll());
					maxHeap.add(x);
				}
			}
			if(maxHeap.size()>minHeap.size())
				System.out.println(maxHeap.peek());
			else if(minHeap.size()>maxHeap.size())
				System.out.println(minHeap.peek());
			else
				System.out.println((double)(minHeap.peek()+maxHeap.peek())/2);

		}
	}
	

}
