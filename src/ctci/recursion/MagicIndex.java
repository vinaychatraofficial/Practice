package ctci.recursion;

/**
 * 9.3
 * @author vcpaks
 *
 */
public class MagicIndex {

	public static void main(String[] args) {
		int[] arr = {-10,-5,1,2,2,7,7,7,9,12,13};
		System.out.println(findIndex(0, arr.length-1, arr));
	}
	
	public static int findIndex(int start, int end, int[] arr) {
		if(start>end)
			return -1;
		
		int mid = start+(end-start)/2;
		int middle = arr[mid];
		
		if(middle == mid)
			return mid;
		
		int leftIdx = Math.min(middle, mid-1);
		int rightIdx = Math.max(middle, mid+1);
		
		int left = findIndex(start,leftIdx,arr);
		if(left!=-1)
			return left;
		
		int right = findIndex(rightIdx, end, arr);
		if(right!=-1)
			return right;
		
		return -1;
	}

}
