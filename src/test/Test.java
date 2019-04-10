package test;

public class Test {

	public static void main(String[] args) {
		int[] coins = {25,5,10,5,10,5,10,25,1,25,1,25,1,25,5,10};
		int[][] maxGain = new int[coins.length][coins.length];
		int max = pickCoins(coins,0,coins.length-1,maxGain);
		System.out.println(max);
		maxGain = new int[coins.length][coins.length];
		max = pickCoins2(coins, 0, coins.length-1, maxGain);
		System.out.println(max);
	}

	private static int pickCoins(int[] coins, int start, int end, int[][] maxGain) {
		if(start>end)
			return 0;
		
		if(maxGain[start][end]==0) {
			int startMax = coins[start] + Math.min(pickCoins(coins, start+2, end, maxGain),pickCoins(coins, start+1, end-1, maxGain));
			int endMax = coins[end] + Math.min(pickCoins(coins, start+1, end-1, maxGain), pickCoins(coins, start, end-2, maxGain));
			maxGain[start][end] = Math.max(startMax, endMax);
		}
		return maxGain[start][end];
	}
	
	private static int pickCoins2(int[] coins, int start, int end, int[][] maxGain) {
		if(start>end)
			return 0;
		
		if(maxGain[start][end]==0) {
			int startMax = coins[start] - pickCoins2(coins, start+1, end, maxGain);
			int endMax = coins[end] - pickCoins2(coins, start, end-1, maxGain);
			maxGain[start][end] = Math.max(startMax, endMax);
		}
		return maxGain[start][end];
	}

}
