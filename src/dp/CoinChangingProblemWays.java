package dp;

public class CoinChangingProblemWays {

	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int total = 5;
		int ways = waysOfCoins(coins,total);
		System.out.println(ways);
	}

	private static int waysOfCoins(int[] coins, int total) {
		int[][] ways = new int[coins.length][total+1];
		//for(int i=0;i<coins.length;i++)
		//	ways[i][0]=1;
		for(int j=0;j<=total;j++)
			ways[0][j] = j%coins[0]==0?1:0;
		for(int i=1;i<coins.length;i++) {
			for(int j=0;j<=total;j++) {
				int withoutCoin = (i-1)>=0?ways[i-1][j]:0;
				int withCoin = (j-coins[i])>=0?ways[i][j-coins[i]]:0;
				ways[i][j] = withoutCoin+withCoin;		
			}
		}
		return ways[coins.length-1][total];
	}

}
