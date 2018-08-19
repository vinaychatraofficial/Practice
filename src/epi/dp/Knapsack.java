package epi.dp;

import java.util.Arrays;

/**
 * @author vcpaks
 * 16.6 Knapsack problem
 */
public class Knapsack {

	public static void main(String[] args) {
		int[] values = {60,50,70,30};
		int[] weights = {5,3,4,2};
		int capacity=5;
		int[][] arr = new int[values.length][capacity+1];
		for(int[] row:arr)
			Arrays.fill(row, -1);
		System.out.println(knapSack(values.length-1, capacity, arr, values, weights));
		System.out.println(knapSackIt(capacity, values, weights));
	}
	
	private static int knapSack(int i,int weight, int[][] arr, int[] values, int[] weights) {
		if(i<0)
			return 0;
		if(arr[i][weight]==-1) {
			int withoutCurrentItem = knapSack(i-1,weight,arr,values,weights);
			int withCurrentItem = weights[i]>weight? 0 : knapSack(i-1,weight-weights[i],arr,values,weights) + values[i];

			arr[i][weight] = Math.max(withoutCurrentItem,withCurrentItem);
		}
	    
	    return arr[i][weight];
	}
	
	private static int knapSackIt(int weight, int[] values, int[] weights) {
		int[][] arr = new int[values.length][weight+1];
		for(int[] row:arr)
			Arrays.fill(row, -1);
		//value with weight 0 is 0
		for(int i=0;i<values.length;i++) {
			arr[i][0]=0;
		}
		
		for(int i=0;i<values.length;i++) {
			for(int j=1;j<=weight;j++) {
				int withoutCurrentItem = i>0? arr[i-1][j]:0;
				int withCurrentItem;
				
				if(i>0) {
					if(weights[i]<=j) {
						withCurrentItem = arr[i-1][j-weights[i]]+values[i];
					}else {
						withCurrentItem=0;
					}
				}else {
					if(weights[i]<=j) {
						withCurrentItem = values[i];
					}else {
						withCurrentItem=0;
					}
				}
				arr[i][j] = Math.max(withoutCurrentItem, withCurrentItem);
			}
		}
		
		return arr[values.length-1][weight];
	}

}
