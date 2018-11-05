package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {3,0,4,1,2};
		for(int i:arr)
			System.out.print(i+" ");
		insertionSort(arr);
		System.out.println();
		for(int i:arr)
			System.out.print(i+" ");
	}
	
	private static void insertionSort(int[] arr){
		int n = arr.length;
		for(int i=1;i<n;i++){
			int j=i-1;
			int elem = arr[i];
			for(j=i-1;j>=0;j--){
				if(arr[j]>elem)
					arr[j+1]=arr[j];
				else
					break;
			}
			arr[j+1]=elem;
		}
	}

}
