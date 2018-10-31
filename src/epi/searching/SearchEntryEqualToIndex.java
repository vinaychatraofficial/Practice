package epi.searching;

/**
 * @author vcprabha
 * 11.2 Search a sorted array for an entry equal to index
 */
public class SearchEntryEqualToIndex {

	public static void main(String[] args) {
		int[] arr = {-2,0,2,3,6,7,9};
		System.out.println(findIndex(arr));
	}
	
	private static int findIndex(int[] arr){
		int low=0, high=arr.length-1;
		while(low<=high){
			int mid = low+(high-low)/2;
			if(arr[mid]==mid){
				return arr[mid];
			}else if(arr[mid]<mid){
				low=mid+1;
			}else{
				high=mid-1;
			}
		}
		return -1;
	}

}
