package dp;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

	public static void main(String[] args) {
		int[] weights = {1,3,4,5};
		int[] values = {1,4,5,7};
		int max = 7;
		int maxValue = knapsack(weights,values,max);
		System.out.println("maxValue:"+maxValue);
	}

	private static int knapsack(int[] weights, int[] values, int max) {
		int[][] value = new int[weights.length][max+1];
		for(int i=0;i<weights.length;i++)
			value[i][0]=0;
		for(int i=0;i<weights.length;i++) {
			for(int j=1;j<=max;j++) {
				int withoutweight = i-1>=0?value[i-1][j]:0;
				int withweight = j-weights[i]>=0?values[i]+(i-1>=0?value[i-1][j-weights[i]]:0):0;
				value[i][j] = Math.max(withoutweight, withweight);
			}
		}
		int i=weights.length-1;
		int j=max;
		List<Integer> maxList = new ArrayList<>();
		while(i>0 || j>0) {
			if(value[i-1][j]==value[i][j]) {
				i=i-1;
			}else {
				maxList.add(values[i]);
				System.out.println("Adding "+values[i]);
				j=j-weights[i];
				i=i-1;
				System.out.println(i+","+j);
			}
		}
		System.out.println(maxList);
		return value[weights.length-1][max];
	}

}
