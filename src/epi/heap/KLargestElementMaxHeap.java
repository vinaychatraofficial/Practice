package epi.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author vcpaks
 * Compute k largest elements in a max heap array
 */
public class KLargestElementMaxHeap {

	public static void main(String[] args) {
		int[] arr = {561,314, 401, 28,156, 359, 271,11,3};
		System.out.println(kLargest(arr, 4));
	}
	
	private static class HeapEntry implements Comparable<HeapEntry>{
		int value;
		int index;
		
		public HeapEntry(int value,int index) {
			this.value=value;
			this.index=index;
		}
		
		@Override
		public int compareTo(HeapEntry o) {
			return Integer.compare(o.value, this.value);
		}
	}
	
	private static List<Integer> kLargest(int arr[], int k){
		PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>();
		List<Integer> result = new ArrayList<>();
		maxHeap.add(new HeapEntry(arr[0], 0));
		for(int i=0;i<k;i++) {
			HeapEntry entry = maxHeap.poll();
			result.add(entry.value);
			int leftChild = 2*entry.index+1;
			int rightChild = 2*entry.index+2;
			if(leftChild<arr.length) {
				maxHeap.add(new HeapEntry(arr[leftChild], leftChild));
			}
			
			if(rightChild<arr.length) {
				maxHeap.add(new HeapEntry(arr[rightChild], rightChild));
			}
		}
		return result;
	}

}
