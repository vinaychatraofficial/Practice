package ae;

import java.util.Arrays;

public class SmallestDifference {
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
	    int i=0,j=0;
			Arrays.sort(arrayOne);
			Arrays.sort(arrayTwo);
			int smallestDiff = Integer.MAX_VALUE;
			int[] res = new int[0];
			
			while(i<arrayOne.length && j<arrayTwo.length){
				if(arrayOne[i] < arrayTwo[j]){
					int diff = Math.abs(arrayOne[i]-arrayTwo[j]);
					if(diff<smallestDiff){
						smallestDiff = diff;
						res = new int[]{arrayOne[i],arrayTwo[j]};
					}
					i++;
				}else if(arrayOne[i] > arrayTwo[j]){
					int diff = Math.abs(arrayOne[i]-arrayTwo[j]);
					if(diff<smallestDiff){
						smallestDiff = diff;
						res = new int[]{arrayOne[i],arrayTwo[j]};
					}
					j++;
				}else{
					res = new int[]{arrayOne[i],arrayTwo[j]};
					return res;
				}
			}
			return res;
	  }
}
