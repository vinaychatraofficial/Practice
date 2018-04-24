package heap;

public class MergeHeaps {

	public static void main(String[] args) {
		MinHeap heap1 = MinHeap.initialize1();
		heap1.printArray();
		System.out.println();
		MinHeap heap2 = MinHeap.initialize2();
		heap2.printArray();
		mergeHeaps(heap1, heap2);
		System.out.println();
		heap1.printArray();
	}
	
	private static void mergeHeaps(MinHeap heap1, MinHeap heap2) {
		for(int i=0;i<heap2.count;i++) {
			heap1.data[heap1.count++]=heap2.data[i];
		}
		int i=heap1.count-1;
		for(int j=(i-1)/2;j>=0;j--)
			heap1.percolateDown(j);
	}

}
