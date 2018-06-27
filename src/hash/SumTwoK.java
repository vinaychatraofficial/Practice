package hash;

import java.util.Hashtable;

/**
 * prob 12 sum of two numbers equal to K
 * @author vcprabha
 *
 */
public class SumTwoK {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {20,25,26,27};
		int k = 32;
		int result = findSumToK(arr1,arr2,k);
		if(result==-1)
			System.out.println("pairs dont exist");
		else
			System.out.println(result+","+(k-result));
	}

	private static Integer findSumToK(int[] arr1, int[] arr2, int k) {
		int length1 = arr1.length;
		int length2 = arr2.length;
		if(length1<length2){
			return insertArr(arr1,arr2,k);
		}else{
			return insertArr(arr2,arr1,k);
		}
	}

	private static int insertArr(int[] arr1, int[] arr2,int k) {
		java.util.Hashtable<Integer, Integer> ht = new Hashtable<>();
		for(int i=0;i<arr1.length;i++){
			ht.put(arr1[i], 1);
		}
		
		for(int i=0;i<arr2.length;i++){
			if(ht.get(k-arr2[i])!=null)
				return arr2[i];
		}
		
		return -1;
	}

}
