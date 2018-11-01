package epi.searching;

import java.util.Random;

/**
 * @author vcpaks
 * 11.8 Find the kth largest element
 */
public class KthLargest {

	public static void main(String[] args) {
		int[] arr = {3,2,1,5,4};
		System.out.println(kthLargest(arr, 2));
	}
	
	private static int kthLargest(int[] arr,int k) {
		int left=0,right=arr.length-1;
		Random rand = new Random(0);
		while(left<=right) {
			int pIndex = rand.nextInt(right-left+1)+left;
			int partIndex = partition(arr,pIndex,left,right);
			if(partIndex==k-1)
				return arr[partIndex];
			else if(partIndex>k-1)
				right=partIndex-1;
			else
				left=partIndex+1;
			
		}
		
		return -1;
	}

	private static int partition(int[] arr, int pIndex, int left, int right) {
		int pivotValue = arr[pIndex];
		swap(arr,pIndex,right);
		int index=left;
		for(int i=left;i<right;i++) {
			if(arr[i]>pivotValue) {
				swap(arr,i,index);
				index++;
			}
		}
		swap(arr,index,right);
		return index;
	}

	private static void swap(int[] arr, int pIndex, int right) {
		int temp = arr[pIndex];
		arr[pIndex] = arr[right];
		arr[right] = temp;
	}

}
