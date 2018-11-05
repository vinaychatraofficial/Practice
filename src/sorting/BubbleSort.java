package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {3,0,4,1,2};
		for(int i:arr)
			System.out.print(i+" ");
		bubbleSort(arr);
		System.out.println();
		for(int i:arr)
			System.out.print(i+" ");
	}
	
	private static void bubbleSort(int[] arr){
		int n = arr.length;
		for(int i=0;i<n-1;i++){
			for(int j=n-1;j>i;j--){
				if(arr[j]<arr[j-1])
					swap(arr,j,j-1);
			}
		}
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}

}
