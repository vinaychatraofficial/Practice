package epi.searching;

/**
 * @author vcpaks
 * 11.3 Search a cyclically sorted array
 */
public class SmallestCyclicArray {

	public static void main(String[] args) {
		int[] arr = {378,478,550,631,1003,203,220,234,279,368};
		System.out.println(searchCyclicRev(arr));
	}
	
	private static int searchCyclic(int[] arr) {
		int low=0,high=arr.length-1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(arr[mid]==arr[high])
				return mid;
			else if(arr[mid]<arr[high])
				high=mid;
			else
				low=mid+1;
		}
		return low;
	}
	
	private static int searchCyclicRev(int[] arr) {
		int low=0,high=arr.length-1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(arr[mid]==arr[low])
				return mid;
			else if(arr[mid]>arr[low])
				low=mid+1;
			else
				high=mid;
		}
		return low;
	}

}
