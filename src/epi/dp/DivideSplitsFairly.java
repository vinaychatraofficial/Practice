package epi.dp;

import java.util.Arrays;

/**
 * @author vcpaks
 * Variant of 16.6 Knapsack problem - Divide splits fairly
 */
public class DivideSplitsFairly {

	public static void main(String[] args) {
		int[] values = {40,50,60,70,80,90};
		int totalValue=0;
		for(int value:values)
			totalValue+=value;
		int splitValue = totalValue/2;
		int[][] arr = new int[values.length][splitValue+1];
		for(int[] row:arr)
			Arrays.fill(row, -1);
		StringBuilder itemStr=new StringBuilder();
		System.out.println(divideFairly(values.length-1, splitValue, arr, values, itemStr));
		System.out.println(itemStr);
			
	}
	
	private static int divideFairly(int i, int totalValue, int[][] arr, int[] values, StringBuilder itemStr) {
		if(i<0)
			return 0;
		
		if(arr[i][totalValue]==-1) {
			int withoutItem = i>0? divideFairly(i-1, totalValue, arr, values,itemStr):0;
			int withItem = values[i]<=totalValue ? (i>0?divideFairly(i-1, totalValue-values[i], arr, values,itemStr):0)+values[i]:0;
			arr[i][totalValue] = Math.max(withoutItem, withItem);
			if(Math.max(withoutItem, withItem)==withItem) {
				itemStr.append(i+"-"+totalValue+",");
			}
		}
		
		return arr[i][totalValue];
	}

}
