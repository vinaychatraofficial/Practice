package dp;

import java.util.ArrayList;
import java.util.List;

public class CoinChangingProblem {

	public static void main(String[] args) {
		int[] coins = {1,5,6,8};
		int sum=11;
		int min = findMinCoins(coins,sum);
		System.out.println(min);
	}

	private static int findMinCoins(int[] coins,int sum) {
		int[][] minCoins = new int[coins.length][sum+1];
		for(int i=0;i<coins.length;i++)
			minCoins[i][0]=0;
		
		for(int i=0;i<coins.length;i++) {
			for(int j=1;j<=sum;j++) {
				int withoutCoin = i-1>=0?minCoins[i-1][j]:Integer.MAX_VALUE;
				int withCoin = j-coins[i]>=0?1+minCoins[i][j-coins[i]]:Integer.MAX_VALUE;
				minCoins[i][j] = Math.min(withoutCoin, withCoin);
			}
		}
		List<Integer> list = new ArrayList<>();
		int i=coins.length-1;
		int j=sum;
		while(i>0 && j>0) {
			if(minCoins[i][j]==minCoins[i-1][j]) {
				i=i-1;
			}else {
				list.add(coins[i]);
				j=j-coins[i];
			}
		}
		System.out.println(list);
		return minCoins[coins.length-1][sum];
	}

}
