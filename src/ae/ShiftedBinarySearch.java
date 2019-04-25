package ae;

public class ShiftedBinarySearch {

	public static int shiftedBinarySearch(int[] array, int target) {
		int left = 0;
		int right = array.length-1;

		while(left<=right){
			int mid = left+(right-left)/2;
			if(array[mid]==target)
				return mid;
			else if(array[left] <= array[mid]){
				if(target >= array[left] && target < array[mid])
					right = mid-1;
				else
					left = mid+1;
			}else if(array[right] >= array[mid]){
				if(target > array[mid] && target <= array[right])
					left = mid+1;
				else
					right = mid-1;
			}
		}
		return -1;
	}
}
