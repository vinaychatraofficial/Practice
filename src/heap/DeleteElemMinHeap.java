package heap;

public class DeleteElemMinHeap {

	public static void main(String[] args) {
		MinHeap heap = new MinHeap(0);
		heap = heap.initialize();
		heap.printArray();
		System.out.println();
		deleteElem(heap, 2);
		heap.printArray();
	}
	
	private static void deleteElem(MinHeap heap, int elem){
		boolean elemFound = false;
		int i;
		for(i=0;i<heap.count;i++){
			if(heap.data[i]==elem){
				elemFound=true;
				break;
			}
		}
		if(elemFound){
			heap.data[i]=heap.data[heap.count-1];
			heap.count--;
			heap.percolateDown(i);
		}
	}

}
