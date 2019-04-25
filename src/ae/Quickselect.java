package ae;

import java.util.Collections;
import java.util.PriorityQueue;

public class Quickselect {

	public static int quickselect(int[] array, int k) {
		//return maxHeap(array,k);
		return quickSelect(array,k);
	}

	private static int quickSelect(int[] array, int k){
		int start = 0;
		int end = array.length-1;
		while(true){
			if(start>end)
				return -1;

			int pivot = array[end];
			int left = start;
			int right = end-1;
			while(left<=right){
				if(array[left]<=pivot)
					left++;
				else if(array[right]>pivot)
					right--;
				else
					swap(array,left,right);
			}
			swap(array,left,end);

			if(left==k-1)
				return array[left];
			else if(k-1>left)
				start = left+1;
			else
				end = left-1;
		}
	}



	private static void swap(int[] array,int left, int right){
		int temp = array[left];
		array[left]=array[right];
		array[right]=temp;
	}
	private static int maxHeap(int[] array, int k){
		PriorityQueue<Integer> maxHeap = new PriorityQueue(k, Collections.reverseOrder());
		for(int i=0;i<k;i++)
			maxHeap.offer(array[i]);
		for(int i=k;i<array.length;i++){
			if(array[i] > maxHeap.peek())
				continue;
			maxHeap.poll();
			maxHeap.offer(array[i]);
		}
		return maxHeap.peek();
	}
}
