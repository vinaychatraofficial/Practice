package epi.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author vcprabha
 * 10.3 Sort an almost sorted array
 */
public class SortAlmostSortedArray {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(2);
		input.add(-1);
		input.add(3);
		input.add(6);
		input.add(5);
		input.add(4);
		input.add(7);
		input.add(8);
		input.add(9);
		System.out.println(input);
		System.out.println("After sorting");
		System.out.println(sort(input, 2));
	}
	
	private static List<Integer> sort(List<Integer> input, int k){
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0;i<=k;i++){
			minHeap.add(input.get(i));
		}
		
		for(int i=k+1;i<input.size();i++){
			result.add(minHeap.poll());
			minHeap.add(input.get(i));
		}
		
		while(!minHeap.isEmpty()){
			result.add(minHeap.poll());
		}
		return result;
	}

}
