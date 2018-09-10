package epi.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author vcpaks
 * 10.2 Sort an increasing decreasing array
 */
public class SortIncreasingDecreasingArray {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(57);
		input.add(131);
		input.add(493);
		input.add(294);
		input.add(221);
		input.add(339);
		input.add(418);
		input.add(452);
		input.add(442);
		input.add(190);
		System.out.println(sort(input));
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
	
	private static List<Integer> sort(List<Integer> input){
		boolean isIncreasing = true;
		int indx=0;
		List<List<Integer>> subArrays = new ArrayList<>();
		for(int i=0;i<input.size();i++) {
			List<Integer> sublist = new ArrayList<>();
			if(i+1==input.size()) {
				sublist = input.subList(indx,input.size());
				if(!isIncreasing)
					Collections.reverse(sublist);
				subArrays.add(sublist);
			}else if(input.get(i+1)<input.get(i) && isIncreasing) {
				sublist = input.subList(indx, i+1);
				isIncreasing=false;
				indx=i+1;
				subArrays.add(sublist);
			}else if(input.get(i+1)>input.get(i) && !isIncreasing) {
				sublist = input.subList(indx, i+1);
				Collections.reverse(sublist);
				isIncreasing=true;
				indx=i+1;
				subArrays.add(sublist);
			} 
			
		}
		
		System.out.println(subArrays);
		
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(subArrays.size(),new Comparator<ArrayEntry>() {

			@Override
			public int compare(ArrayEntry o1, ArrayEntry o2) {
				return Integer.compare(o1.value, o2.value);
			}
		});
		
		List<Iterator<Integer>> iters = new ArrayList<>();
		for(int i=0;i<subArrays.size();i++)
			iters.add(subArrays.get(i).iterator());
		
		for(int i=0;i<subArrays.size();i++) {
			if(iters.get(i).hasNext())
				minHeap.add(new ArrayEntry(iters.get(i).next(), i));
		}
		
		List<Integer> result = new ArrayList<>();
		while(!minHeap.isEmpty()) {
			ArrayEntry min = minHeap.poll();
			result.add(min.value);
			if(iters.get(min.array).hasNext())
				minHeap.add(new ArrayEntry(iters.get(min.array).next(), min.array));
		}
		return result;
	}

}
