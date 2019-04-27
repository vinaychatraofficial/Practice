package ae;

public class QuickSort {

	public static int[] quickSort(int[] array) {
		quickSort(array,0,array.length-1);
		//System.out.println(array);
		return array;
	}

	private static void quickSort(int[] array, int start, int end) {
		if(start>end)
			return;
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
		if(start - (left-1) < end - (left+1)){
			quickSort(array,start,left-1);
			quickSort(array,left+1,end);
		}else{
			quickSort(array,left+1,end);
			quickSort(array,start,left-1);
		}
	}

	private static void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
