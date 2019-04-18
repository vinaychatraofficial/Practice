package ae;

public class MinNumberOfCoinsForChange {
	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		//return minNumberOfCoinsForChangeOne(n,denoms);
		return minNumberOfCoinsForChangeTwo(n,denoms);
	}
	
	public static int minNumberOfCoinsForChangeOne(int n, int[] denoms) {
		int[] coins = new int[n+1];
		for(int i=1;i<=n;i++){
			coins[i] = Integer.MAX_VALUE;
		}
		coins[0]=0;
		
		for(int i=0;i<denoms.length;i++){
			for(int j=1;j<=n;j++){
				int withDenom = Integer.MAX_VALUE;
				if(j-denoms[i]>=0){
					if(coins[j-denoms[i]]!=Integer.MAX_VALUE)
						withDenom = coins[j-denoms[i]]+1;
				}
				coins[j] = Math.min(coins[j],withDenom);
			}
		}
		return coins[n] == Integer.MAX_VALUE ? -1:coins[n];
	}
	
	public static int minNumberOfCoinsForChangeTwo(int n, int[] denoms) {
		int[][] coins = new int[denoms.length][n+1];
		for(int i=0;i<denoms.length;i++){
			coins[i][0] = 0;
		}
		
		for(int i=0;i<denoms.length;i++){
			for(int j=1;j<=n;j++){
				int withDenom = Integer.MAX_VALUE;
				if(j-denoms[i]>=0){
					if(coins[i][j-denoms[i]]!=Integer.MAX_VALUE)
						withDenom = coins[i][j-denoms[i]]+1;
				}
				int withoutDenom = i-1>=0? coins[i-1][j] : Integer.MAX_VALUE;
				coins[i][j] = Math.min(withoutDenom,withDenom);
			}
		}
		
		return coins[denoms.length-1][n] == Integer.MAX_VALUE ? -1:coins[denoms.length-1][n];
	}
}
