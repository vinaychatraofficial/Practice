package epi.searching;

/**
 * @author vcprabha
 * (12.1) Search a sorted array for the first occurence of k
 */
public class FirstOccurenceK {

	public static void main(String[] args) {
		int[] arr = {-14,-10,2,108,108,243,285,285,285,401};
		System.out.println(findFirstOccurence(arr, 285));
	}
	
	private static Integer findFirstOccurence(int[] arr, int key){
		int firstOccurence = -1;
		firstOccurence = findFirstOccurence(arr,key,firstOccurence,0,arr.length-1);
		return firstOccurence;
	}

	private static int findFirstOccurence(int[] arr, int key, int firstOccurence, int low, int high) {
		if(high<low)
			return firstOccurence;
		int mid = low+(high-low)/2;
		if(arr[mid]==key){
			firstOccurence=mid;
			return findFirstOccurence(arr, key, firstOccurence, low, mid-1);
		}else if(key<arr[mid]){
			return findFirstOccurence(arr, key, firstOccurence, low, mid-1);
		}else{
			return findFirstOccurence(arr, key, firstOccurence, mid+1, high);
		}
	}

}
