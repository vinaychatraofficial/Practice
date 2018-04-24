package heap;

public class FindKthSmallestMinHeap {

	public static void main(String[] args) {
		MinHeap heap = MinHeap.initialize();
		heap.printArray();
		System.out.println();
		//System.out.println(findKthSmallest(heap, 5));
		System.out.println(findKthSmallestAux(heap, 3));
	}
	
	private static int findKthSmallest(MinHeap heap, int k) {
		int count=0;
		while(true) {
			int value=heap.deleteMin();
			count++;
			if(count==k)
				return value;
		}
	}
	
	private static int findKthSmallestAux(MinHeap heap, int k) {
		MinHeap aux = new MinHeap(1);
		int smallest = heap.data[0];
		aux.insertElem(smallest);
		int count=0;
		while(true) {
			int data = aux.deleteMin();
			count++;
			if(count==k)
				return data;
			aux.insertElem(heap.data[2*(count-1)+1]);
			aux.insertElem(heap.data[2*(count-1)+2]);
		}
	}

}
