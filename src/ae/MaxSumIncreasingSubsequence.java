package ae;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxSumIncreasingSubsequence {

	public static ArrayList<ArrayList<Integer>> maxSumIncreasingSubsequence(int[] array) {
	    int[] subSeqSum = new int[array.length];
			int[] prev = new int[array.length];
			int maxSum=Integer.MIN_VALUE;
			int maxIndex=-1;
			
			Arrays.fill(prev,-1);
			
			for(int i=0;i<array.length;i++){
				subSeqSum[i]=array[i];
				if(array[i]>maxSum){
					maxSum=array[i];
					maxIndex=i;
				}
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			
			for(int i=1;i<array.length;i++){
				for(int j=0;j<i;j++){
					if(array[j]<array[i] && subSeqSum[i] < (subSeqSum[j]+array[i])){
						subSeqSum[i] = subSeqSum[j]+array[i];
						prev[i] = j;
					}
				}
				if(subSeqSum[i]>maxSum){
					maxSum = subSeqSum[i];
					maxIndex = i;
				}
			}
			int index=maxIndex;
			while(index!=-1){
				list.add(array[index]);
				index=prev[index];
			}
			
			ArrayList<Integer> sum = new ArrayList<>();
			sum.add(maxSum);
			res.add(sum);
			Collections.reverse(list);
			res.add(list);
			return res;
	  }
}
