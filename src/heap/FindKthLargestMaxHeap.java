package heap;

public class FindKthLargestMaxHeap {

	public static void main(String[] args) {
		BinaryHeap heap = BinaryHeap.initialize();
		heap.printArray();
		System.out.println();
		//System.out.println(findKthLargest(heap, 2));
		System.out.println(findKthLargestAux(heap, 7));
	}
	
	private static int findKthLargest(BinaryHeap heap, int k) {
		int count=0;
		while(true) {
			int value = heap.deleteMax();
			count++;
			if(count==k)
				return value;
		}
	}
	
	private static int findKthLargestAux(BinaryHeap heap, int k) {
		BinaryHeap aux = new BinaryHeap(1);
		int top = heap.data[0];
		aux.insertElement(top);
		int count=0;
		while(true) {
			int value = aux.deleteMax();
			count++;
			if(count==k)
				return value;
			int l=2*(count-1)+1;
			int r=2*(count-1)+2;
			if(l<=heap.count-1)
				aux.insertElement(heap.data[l]);
			if(r<=heap.count-1)
				aux.insertElement(heap.data[r]);
		}
	}

}
