package sorting;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = {3,0,4,1,2};
		for(int i:arr)
			System.out.print(i+" ");
		heapSort(arr);
		System.out.println();
		for(int i:arr)
			System.out.print(i+" ");
	}
	
	private static void heapSort(int[] arr) {
		int n=arr.length;
		
		//build heap
		for(int i=n/2-1;i>=0;i--)
			heapify(arr,i,n);
		
		//keep removing largest element from max heap
		for(int i=n-1;i>=0;i--) {
			swap(arr,0,i);
			heapify(arr,0,i);
		}
	}

	private static void heapify(int[] arr, int i, int n) {
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		
		if(left<n && arr[left]>arr[largest])
			largest=left;
		if(right<n && arr[right]>arr[largest])
			largest=right;
		if(largest!=i) {
			swap(arr,largest,i);
			heapify(arr,largest,n);
		}
	}

	private static void swap(int[] arr, int largest, int i) {
		int temp = arr[largest];
		arr[largest]=arr[i];
		arr[i]=temp;
	}

}
