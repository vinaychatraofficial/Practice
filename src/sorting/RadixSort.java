package sorting;

public class RadixSort {

	public static void main(String[] args) {
		int arr[] = {302,20,42,12,2};
		for(int i:arr)
			System.out.print(i+" ");
		radixSort(arr);
		System.out.println();
		for(int i:arr)
			System.out.print(i+" ");
	}
	
	private static void radixSort(int[] arr) {
		int max = getMax(arr);
		int exp=1;
		for(exp=1;max/exp>0;exp=exp*10)
			countSort(arr,exp);
	}

	private static void countSort(int[] arr, int exp) {
		int n = arr.length;
		int[] count = new int[10];
		int[] output = new int[n];
		
		for(int i=0;i<n;i++)
			count[(arr[i]/exp)%10]++;
		
		//running count
		for(int i=1;i<10;i++)
			count[i]=count[i]+count[i-1];
		
		//add to array in reverse order since you have running count
		for(int i=n-1;i>=0;i--) {
			output[count[(arr[i]/exp)%10]-1]=arr[i];
			count[(arr[i]/exp)%10]--;
		}
		
		for(int i=0;i<n;i++)
			arr[i]=output[i];
	}

	private static int getMax(int[] arr) {
		int max = arr[0];
		for(int i=1;i<arr.length;i++)
			if(arr[i]>max)
				max=arr[i];
		return max;
	}

}
