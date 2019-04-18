package ae;

public class NumberOfWaysToMakeChange {
	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		//return numberOfWaysToMakeChangeOne(n,denoms);
		return numberOfWaysToMakeChangeTwo(n,denoms);
	}
	
	private static int numberOfWaysToMakeChangeOne(int n, int[] denoms){
		int[] dp = new int[n+1];
		dp[0] = 1;
		
		for(int i=0;i<denoms.length;i++){
			for(int j=1;j<=n;j++){
				int withCoin = j-denoms[i]>=0? dp[j-denoms[i]]:0;
				dp[j] += withCoin;																	 
			}
		}
		return dp[n];
	}
	
	private static int numberOfWaysToMakeChangeTwo(int n, int[] denoms){
		int[][] dp = new int[denoms.length][n+1];
		for(int i=0;i<denoms.length;i++)
			dp[i][0]=1;
		
		for(int i=0;i<denoms.length;i++){
			for(int j=1;j<=n;j++){
				int withCoin = j-denoms[i]>=0? dp[i][j-denoms[i]]:0;
				int withoutCoin = i-1>=0? dp[i-1][j]:0;
				dp[i][j] = withCoin+withoutCoin;																	 
			}
		}
		return dp[denoms.length-1][n];
	}
}
