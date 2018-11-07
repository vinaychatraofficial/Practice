package epi.sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author vcpaks
 * 13.1 Compute the intersection of two sorted arrays
 */
public class IntersectionSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {2,3,3,5,5,6,7,7,8,12};
		int[] arr2 = {5,5,6,8,8,9,10,10};
		System.out.println(intersection(arr1, arr2));
	}
	
	private static List<Integer> intersection(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;
		int i=0,j=0;
		Set<Integer> result = new HashSet<>();
		while(i<m && j<n) {
			if(arr1[i]<arr2[j]) {
				i++;
			}else if(arr1[i]==arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			}else {
				j++;
			}
		}
		return new ArrayList(result);
	}

}
