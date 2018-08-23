package epi.greedy;

import java.util.Arrays;

public class MinimizeWaitingTime {

	public static void main(String[] args) {
		int[] queries = {2,5,1,3};
		System.out.println(findMinWaitingTime(queries));
	}
	
	private static int findMinWaitingTime(int[] queries) {
		int minWaitTime = 0;
		
		Arrays.sort(queries);
		
		for(int i=0;i<queries.length;i++) {
			minWaitTime += queries[i]* (queries.length - (i+1));
		}
		
		return minWaitTime;
	}
	
	private static int findMinWaitingTimeRec(int[] queries) {
		int minWaitTime = 0;
		Arrays.sort(queries);
		
		return findMinWaitingTimeRec(queries,0,minWaitTime);
	}

	private static int findMinWaitingTimeRec(int[] queries, int i, int minWaitTime) {
		if(i==queries.length)
			return minWaitTime; 
		
		int presentWaitTime = queries[i]+minWaitTime;
		
		return findMinWaitingTimeRec(queries, i+1, presentWaitTime+minWaitTime);
	}

}
