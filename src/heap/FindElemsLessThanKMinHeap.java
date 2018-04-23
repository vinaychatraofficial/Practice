package heap;

import java.util.ArrayList;
import java.util.List;

public class FindElemsLessThanKMinHeap {

	public static void main(String[] args) {
		MinHeap heap = MinHeap.initialize();
		List<Integer> list = new ArrayList<Integer>();
		findElemLessThanK(heap, 5, list, 0);
		for(int i:list)
			System.out.print(i+" ");
	}
	
	private static void findElemLessThanK(MinHeap heap, int k, List<Integer> list, int i){
		if(i>(heap.count-1))
			return;
		
		if(heap.data[i]>=k)
			return;
		
		list.add(heap.data[i]);
		
		findElemLessThanK(heap, k, list, 2*i+1);
		findElemLessThanK(heap, k, list, 2*i+2);
		
	}

}
