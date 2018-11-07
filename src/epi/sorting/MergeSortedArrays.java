package epi.sorting;

/**
 * @author vcpaks
 * 13.2 Merge two sorted arrays
 */
public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {5,13,17,-1,-1,-1,-1,-1};
		int[] arr2 = {3,7,11,19};
		mergeArrays(arr1,arr2,3,4);
		for(int i:arr1)
			System.out.print(i+" ");
	}
	
	private static void mergeArrays(int[] arr1, int[] arr2, int m, int n) {
		int i=m-1,j=n-1,k=m+n-1;
		while(i>=0 && j>=0) {
			if(arr1[i]>=arr2[j]) {
				arr1[k]=arr1[i];
				k--;
				i--;
			}else {
				arr1[k]=arr2[j];
				k--;
				j--;
			}
				
		}
		while(j>=0) {
			arr1[k]=arr2[j];
			k--;
			j--;
		}
	}

}
