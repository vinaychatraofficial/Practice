package epi.sorting;

import java.util.Arrays;

/**
 * @author vcpaks
 * 13.4 Find the max non constructible value
 */
public class MaxNonConstructibleValue {
	
	public static void main(String[] args) {
		int[] arr = {12,2,1,15,2,4};
		System.out.println(findMaxNonConstructibleValue(arr));
	}
	
	private static int findMaxNonConstructibleValue(int[] arr) {
		Arrays.sort(arr);
		
		int maxConstructibleValue = 0;
		
		for(int i:arr) {
			if(i>maxConstructibleValue+1)
				break;
			maxConstructibleValue+=i;
		}
		return maxConstructibleValue+1;
	}

}
