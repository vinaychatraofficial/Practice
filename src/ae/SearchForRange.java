package ae;

public class SearchForRange {

	public static int[] searchForRange(int[] array, int target) {
	    int leftIndex = findLeftIndex(array,target);
			int rightIndex = findRightIndex(array,target);
			return new int[]{leftIndex,rightIndex};
	  }
		
		private static int findLeftIndex(int[] array, int target) {
			int left = 0;
			int right = array.length-1;
			while(left<=right){
				int middle = left+(right-left)/2;
				if(array[middle]==target && (middle==0 || array[middle-1]<target))
					return middle;
				else if(target > array[middle])
					left = middle+1;
				else
					right = middle-1;
			}
			return -1;
		}
		
		private static int findRightIndex(int[] array, int target) {
			int left = 0;
			int right = array.length-1;
			while(left<=right){
				int middle = left+(right-left)/2;
				if(array[middle]==target && (middle==array.length-1 || array[middle+1] > target))
					 return middle;
				else if(target < array[middle])
					right = middle-1;
				else
					left = middle+1;
			}
			return -1;
		}
}
