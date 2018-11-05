package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = {3,0,4,1,2};
		for(int i:arr)
			System.out.print(i+" ");
		selectionSort(arr);
		System.out.println();
		for(int i:arr)
			System.out.print(i+" ");
	}
	
	private static void selectionSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			int minIdx = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[minIdx]) {
					minIdx = j;
				}
			}
			swap(arr,minIdx,i);
		}
	}

	private static void swap(int[] arr, int minIdx, int i) {
		int temp = arr[minIdx];
		arr[minIdx]=arr[i];
		arr[i]=temp;
	}

}
