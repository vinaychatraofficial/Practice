package ae;

public class HeapSort {

	public static int[] heapSort(int[] array) {
		heapify(array);
		for(int i=array.length-1;i>0;i--){
			swap(array,0,i);
			siftDown(array,0,i-1);
		}
		return array;
	}

	private static void heapify(int[] array){
		for(int i = (array.length-2)/2; i>=0;i--){
			siftDown(array,i,array.length-1);
		}
	}

	private static void siftDown(int[] array, int index,int endIdx){
		int firstChild = 2*index+1;
		while(firstChild <= endIdx){
			int secondChild = 2*index+2;
			int indexToSwap = firstChild;
			if(secondChild <= endIdx){
				if(array[secondChild] > array[firstChild])
					indexToSwap = secondChild;
			}
			if(array[index] < array[indexToSwap]){
				swap(array,index,indexToSwap);
				index = indexToSwap;
				firstChild = 2*index+1;
			}else{
				break;
			}
		}
	}

	private static void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
