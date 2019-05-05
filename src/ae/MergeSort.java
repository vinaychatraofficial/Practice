package ae;

public class MergeSort {

	public static int[] mergeSort(int[] array) {
		int[] aux = array.clone();
		mergeSort(array,0,array.length-1,aux);
		return array;
	}

	private static void mergeSort(int[] array, int start, int end, int[] aux){
		if(start>=end)
			return;
		int mid = start + (end-start)/2;
		mergeSort(aux,start,mid,array);
		mergeSort(aux,mid+1,end,array);
		merge(array,start,mid+1,end,aux);
	}

	private static void merge(int[] res, int start, int midstart, int end, int[] array){
		//int[] res = new int[end-start+1];
		int i=start,j=midstart,k=start;
		while(i<midstart && j<=end){
			if(array[i]<=array[j]){
				res[k] = array[i];
				i++;
				k++;
			}else{
				res[k] = array[j];
				j++;
				k++;
			}
		}
		while(i<midstart){
			res[k] = array[i];
			i++;
			k++;
		}
		while(j<=end){
			res[k] = array[j];
			j++;
			k++;
		}
		/*i=start;
		for(k=0;k<res.length;k++,i++){
			array[i] = res[k];
		}*/
	}

	public static int[] mergeSort1(int[] array) {
		int[] aux = new int[array.length];
		mergeSort1(array,0,array.length-1);
		return array;
	}

	private static void mergeSort1(int[] array, int start, int end){
		if(start>=end)
			return;
		int mid = start + (end-start)/2;
		mergeSort1(array,start,mid);
		mergeSort1(array,mid+1,end);
		merge1(array,start,mid+1,end);
	}

	private static void merge1(int[] array, int start, int midstart, int end){
		int[] res = new int[end-start+1];
		int i=start,j=midstart,k=0;
		while(i<midstart && j<=end){
			if(array[i]<=array[j]){
				res[k] = array[i];
				i++;
				k++;
			}else{
				res[k] = array[j];
				j++;
				k++;
			}
		}
		while(i<midstart){
			res[k] = array[i];
			i++;
			k++;
		}
		while(j<=end){
			res[k] = array[j];
			j++;
			k++;
		}
		i=start;
		for(k=0;k<res.length;k++,i++){
			array[i] = res[k];
		}
	}
}
