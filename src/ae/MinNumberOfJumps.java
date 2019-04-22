package ae;

import java.util.Arrays;

public class MinNumberOfJumps {

	public static int minNumberOfJumps(int[] array) {
		int[] minJumps = new int[array.length];
		Arrays.fill(minJumps, Integer.MAX_VALUE);
		minJumps[0]=0;

		for(int i=1;i<array.length;i++){
			for(int j=0;j<i;j++){
				if(array[j]>= (i-j)){
					minJumps[i] = Math.min(minJumps[i], minJumps[j]+1);
				}
			}
		}

		return minJumps[array.length-1];
	}
}
