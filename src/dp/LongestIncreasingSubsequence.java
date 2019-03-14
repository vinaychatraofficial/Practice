package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {3,4,-1,0,6,2,3};
		int longest = findLongestIncSubseq(arr);
		System.out.println(longest);
	}

	private static int findLongestIncSubseq(int[] arr) {
		int[] longest = new int[arr.length];
		int[] prev = new int[arr.length];
		Arrays.fill(longest, 1);
		Arrays.fill(prev, -1);
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && longest[j]+1>longest[i]) {
					longest[i]=longest[j]+1;
					prev[i]=j;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int maxIndex =-1;
		for(int i=0;i<arr.length;i++) {
			if(longest[i]>max) {
				max=longest[i];
				maxIndex=i;
			}
		}
		while(maxIndex!=-1) {
			System.out.print(arr[maxIndex]+" ");
			maxIndex=prev[maxIndex];
		}
		System.out.println();
		return max;
	}

}
