package epi.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author vcpaks
 * 10.1 Merge sorted arrays/files
 */
public class MergeSortedArrays {

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(3);
		l1.add(5);
		l1.add(7);
		List<Integer> l2 = new ArrayList<>();
		l2.add(0);
		l2.add(6);
		List<Integer> l3 = new ArrayList<>();
		l3.add(0);
		l3.add(6);
		l3.add(28);
		input.add(l1);
		input.add(l2);
		input.add(l3);
		System.out.println(merge(input));
	}
	
	private static class ArrayEntry{
		int value;
		int array;
		
		public ArrayEntry(int value, int array) {
			super();
			this.value = value;
			this.array = array;
		}
		
	}
	
	private static List<Integer> merge(List<List<Integer>> input){
		List<Iterator<Integer>> iters = new ArrayList<>();
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(input.size(),new Comparator<ArrayEntry>() {

			@Override
			public int compare(ArrayEntry o1, ArrayEntry o2) {
				return Integer.compare(o1.value, o2.value);
			}
		});
		
		for(int i=0;i<input.size();i++) {
			iters.add(input.get(i).iterator());
		}
		
		for(int i=0;i<input.size();i++) {
			if(iters.get(i).hasNext()) {
				minHeap.add(new ArrayEntry(iters.get(i).next(), i));
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		while(!minHeap.isEmpty()) {
			ArrayEntry minEntry = minHeap.poll();
			result.add(minEntry.value);
			if(iters.get(minEntry.array).hasNext()) {
				minHeap.add(new ArrayEntry(iters.get(minEntry.array).next(), minEntry.array));
			}
		}
		
		return result;
	}

}
