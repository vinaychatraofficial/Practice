package ae;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindThreeLargestNumbers {
	public static int[] findThreeLargestNumbers(int[] array) {
	    PriorityQueue<Integer> minHeap = new PriorityQueue();
			if(array.length<=3){
				Arrays.sort(array);
				return array;
			}
			minHeap.offer(array[0]);
			minHeap.offer(array[1]);
			minHeap.offer(array[2]);
			for(int i=3;i<array.length;i++){
				if(minHeap.peek()<array[i]){
					minHeap.poll();
					minHeap.offer(array[i]);
				}
			}
			
			int[] res = new int[3];
			int count=0;
			while(!minHeap.isEmpty()){
				res[count++]=minHeap.poll();
			}
			
			return res;
	  }
	
	public static int[] findThreeLargestNumbersArray(int[] array) {

		int[] res = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
		for(int num:array){
			if(num>res[2]){
				res[0]=res[1];
				res[1]=res[2];
				res[2]=num;
			}else if(num>res[1]){
				res[0]=res[1];
				res[1]=num;
			}else if(num>res[0]){
				res[0]=num;
			}
		}
		
		return res;
  }
}
