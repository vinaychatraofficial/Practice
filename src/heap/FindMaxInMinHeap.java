package heap;

public class FindMaxInMinHeap {

	public static void main(String[] args) {
		MinHeap heap = new MinHeap(0);
		heap = heap.initialize();
		//heap.printArray();
		System.out.println(findMax(heap));
	}
	
	private static int findMax(MinHeap heap){
		int lastIndex = heap.count-1;
		int max=Integer.MIN_VALUE;
		//System.out.println(heap.count);
		for(int i=(lastIndex-1)/2;i<heap.count;i++){
			if(heap.data[i]>max)
				max=heap.data[i];
		}
		return max;
	}

}
