package epi.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author vcpaks
 * 16.12 Find the longest non decreasing subsequence
 */
public class LongestNonDecreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {0,8,4,12,2,10,6,14,1,9};
		System.out.println(findLongestNonDecreasingSubsequence(arr));
	}
	
	private static int findLongestNonDecreasingSubsequence(int arr[]) {
		int size = arr.length;
		Integer[] maxLength = new Integer[size];
		int[] prev = new int[size];
		maxLength[0]=1;
		Arrays.fill(prev, -1);
		
		for(int i=1;i<size;i++) {
			maxLength[i]=1;
			
			for(int j=0;j<i;j++) {
				if(arr[j]<=arr[i]) {
					if(maxLength[j]+1>maxLength[i]) {
						maxLength[i]=maxLength[j]+1;
						prev[i]=j;
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int maxIndex=-1;
		for(int i=0;i<size;i++) {
			if(maxLength[i]>max) {
				max=maxLength[i];
				maxIndex=i;
			}
		}
		
		while(maxIndex!=-1) {
			System.out.print(arr[maxIndex]+" ");
			maxIndex=prev[maxIndex];
		}
		
		return max;
		
	}

}
