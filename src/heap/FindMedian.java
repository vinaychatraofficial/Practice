package heap;

public class FindMedian {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5,6};
		System.out.println(findMedian(arr, 6));
		
	}
	
	public static double findMedian(int[] arr, int n) {
		MinHeap minHeap = new MinHeap(1);
		BinaryHeap maxHeap = new BinaryHeap(1);
		for(int i=0;i<n;i++) {
			addNumber(arr[i],maxHeap,minHeap);
			rebalance(maxHeap,minHeap);
		}
		return findMedian(maxHeap,minHeap);
	}

	private static double findMedian(BinaryHeap maxHeap, MinHeap minHeap) {
		int maxHeapCount = maxHeap.count;
		int minHeapCount = minHeap.count;
		
		if(maxHeapCount>minHeapCount) {
			return maxHeap.data[0];
		}else if(minHeapCount>maxHeapCount) {
			return minHeap.data[0];
		}else {
			return (double)(maxHeap.data[0]+minHeap.data[0])/2;
		}
	}

	private static void rebalance(BinaryHeap maxHeap, MinHeap minHeap) {
		int maxHeapCount = maxHeap.count;
		int minHeapCount = minHeap.count;
		if(maxHeapCount>minHeapCount && (maxHeapCount-minHeapCount)>1) {
			maxHeap.printArray();
			int top = maxHeap.deleteMax();
			System.out.println("rebalancing maxHeap removing "+top);
			minHeap.insertElem(top);
		}else if(minHeapCount>maxHeapCount && (minHeapCount-maxHeapCount)>1) {
			minHeap.printArray();
			int top = minHeap.deleteMin();
			
			System.out.println("rebalancing minHeap removing "+top);
			maxHeap.insertElement(top);
		}
	}

	private static void addNumber(int data, BinaryHeap maxHeap, MinHeap minHeap) {
		if(maxHeap.count==0 || data < maxHeap.data[0]) {
			maxHeap.insertElement(data);
			System.out.println("Inserting data into maxHeap "+data);
		}
		else {
			minHeap.insertElem(data);
			System.out.println("Inserting data into minHeap "+data);
		}
	}
	

}
