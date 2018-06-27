package hash;

import java.util.Hashtable;

/**
 * Problem 5. Given two array of unordered numbers, check both arrays have the same set of numbers
 * @author vcpaks
 *
 */
public class CompareArrays {

	public static void main(String[] args) {
		int[] arr1 = {2, 5, 6,8, 10, 2,2};
		int[] arr2 = {2,5,5,8,10,5,6};
		//int[] arr2 = {2, 5, 6,8, 10, 2,2};
		System.out.println(checkSame(arr1, arr2));
	}

	private static boolean checkSame(int[] arr1, int[] arr2) {
		if(arr1.length!=arr2.length)
			return false;
		
		java.util.Hashtable<Integer, Integer> ht = new Hashtable<>();
		for(int i=0;i<arr1.length;i++) {
			if(ht.get(arr1[i])!=null) {
				int count = ht.get(arr1[i]);
				count++;
				ht.put(arr1[i], count);
			}else {
				ht.put(arr1[i], 1);
			}
				
		}
		for(int i=0;i<arr2.length;i++) {
			if(ht.get(arr2[i])!=null) {
				int count=ht.get(arr2[i]);
				count--;
				ht.put(arr2[i], count);
			}else {
				return false;
			}
		}
		
		for(Integer key:ht.keySet()) {
			if(ht.get(key)!=0) {
				return false;
			}
		}
		return true;
	}

}
