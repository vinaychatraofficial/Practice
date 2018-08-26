package epi.greedy;

import java.util.Stack;

/**
 * @author vcpaks
 * 17.8 Compute the largest rectangle under the skyline
 */
public class MaxRectangleSkyline {

	public static void main(String[] args) {
		int[] arr = {1,4,2,5,6,3,2,6,6,5,2,1,3};
		System.out.println(computeLargestRectangle(arr));
	}
	
	private static int computeLargestRectangle(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		
		for(int i=0;i<=arr.length;i++) {
			while(!stack.isEmpty() && (i==arr.length || isTallerBuilding(arr,i,stack.peek()) )) {
					int elem = stack.pop();
					int height = arr[elem];
					int start = stack.isEmpty()? 0:stack.peek()+1;
					int area = height * (i-start);
					maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}
		return maxArea;
		
	}

	private static boolean isTallerBuilding(int[] arr, int i, Integer peek) {
		if(arr[i]<=arr[peek])
			return true;
		return false;
	}

}
