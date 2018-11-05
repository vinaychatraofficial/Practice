package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {3,0,4,1,2};
		for(int i:arr)
			System.out.print(i+" ");
		mergeSort(arr);
		System.out.println();
		for(int i:arr)
			System.out.print(i+" ");
	}
	
	private static void mergeSort(int[] arr){
		mergeSort(arr,0,arr.length-1);
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if(low<high){
			int mid = low+(high-low)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int m = mid-low+1;
		int n = high-mid;
		int[] L = new int[m];
		int[] R = new int[n];
		
		for(int i=0;i<m;i++)
			L[i] = arr[low+i];
		for(int j=0;j<n;j++)
			R[j] = arr[mid+1+j];
		int i=0,j=0,k=low;
		while(i<m && j<n){
			if(L[i]<=R[j]){
				arr[k]=L[i];
				i++;
			}else{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		
		while(i<m){
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<n){
			arr[k]=R[j];
			j++;
			k++;
		}
	}

}
