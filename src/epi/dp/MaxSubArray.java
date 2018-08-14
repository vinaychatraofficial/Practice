package epi.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcpaks
 * Fina maximum sum over all subarrays of a given array of integer
 */
public class MaxSubArray {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(904);
		list.add(40);
		list.add(523);
		list.add(12);;
		list.add(-335);
		list.add(-385);
		list.add(-124);
		list.add(481);
		list.add(-31);
		System.out.println(findMaxSubArray(list));
	}
	
	private static int findMaxSubArray(List<Integer> list) {
		int maxSum=Integer.MIN_VALUE,minSum=0,runningSum=0;
		
		for(int i=0;i<list.size();i++) {
			runningSum+=list.get(i);
			
			if(runningSum<minSum)
				minSum=runningSum;
			
			if(runningSum-minSum>maxSum) {
				maxSum=(runningSum-minSum);
			}
		}
		return maxSum;
	}

}
