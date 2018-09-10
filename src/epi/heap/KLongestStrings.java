package epi.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author vcpaks
 * Compute k longest strings
 */
public class KLongestStrings {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("hi");
		list.add("hello");
		list.add("how");
		list.add("fare");
		list.add("vinay");
		System.out.println(kLongestString(3, list));
	}
	
	private static List<String> kLongestString(int k,List<String> input){
		PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		
		for(String s:input) {
			minHeap.add(s);
			if(minHeap.size()>k)
				minHeap.poll();
		}
		return new ArrayList<>(minHeap);
	}

}
