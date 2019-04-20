package ae;

public class SubarraySort {

	public static int[] subarraySort(int[] array) {

		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++){
			if(i==0 && array[i]>array[i+1]){
				minOutOfOrder = Math.min(minOutOfOrder, array[i]);
				maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
			}else if(i==array.length-1 && array[i-1]>array[i]){
				minOutOfOrder = Math.min(minOutOfOrder, array[i]);
				maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
			}else if((i>0 && array[i] < array[i-1]) || (i<array.length-1 && array[i] > array[i+1])){
				minOutOfOrder = Math.min(minOutOfOrder, array[i]);
				maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
			}
		}

		if(minOutOfOrder==Integer.MAX_VALUE)
			return new int[]{-1,-1};

		int i=0;
		while(i<array.length && array[i]<=minOutOfOrder){
			i++;
		}

		int j=array.length-1;
		while(j>=0 && array[j]>=maxOutOfOrder){
			j--;
		}

		return new int[]{i,j};
	}
}
