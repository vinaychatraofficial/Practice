package sorting;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {3,0,4,1,2};
		for(int i:arr)
			System.out.print(i+" ");
		quickSort(arr);
		System.out.println();
		for(int i:arr)
			System.out.print(i+" ");
	}
	
	private static void quickSort(int[] arr) {
		quickSort(arr,0,arr.length-1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pIdx = partition(arr,low,high);
			quickSort(arr,low,pIdx-1);
			quickSort(arr,pIdx+1,high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int index=low;
		for(int i=low;i<high;i++) {
			if(arr[i]<pivot) {
				swap(arr,index,i);
				index++;
			}
		}
		swap(arr,index,high);
		return index;
	}

	private static void swap(int[] arr, int index, int high) {
		int temp = arr[index];
		arr[index]=arr[high];
		arr[high]=temp;
	}

}
