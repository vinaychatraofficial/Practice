package ae;

import java.util.Collections;
import java.util.PriorityQueue;

public class ContinuousMedianHandler {

	double median = 0;
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	public void insert(int number) {
		if(maxHeap.size()>0 && number < maxHeap.peek()){
			maxHeap.offer(number);
		}else if(minHeap.size()>0 && number > minHeap.peek()){
			minHeap.offer(number);
		}else{
			maxHeap.offer(number);
		}

		if(minHeap.size() - maxHeap.size() > 1)
			maxHeap.offer(minHeap.poll());
		else if(maxHeap.size() - minHeap.size() > 1)
			minHeap.offer(maxHeap.poll());

		if((minHeap.size() + maxHeap.size()) % 2 == 0)
			median = ((double)minHeap.peek() + (double)maxHeap.peek())/2;
		else
			median = minHeap.size() > maxHeap.size() ? (double)minHeap.peek():
				(double)maxHeap.peek();
			//System.out.println("median:"+median+" size:"+(minHeap.size() + maxHeap.size()));
	}

	public double getMedian() {
		return median;
	}
}
