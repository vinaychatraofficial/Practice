package ctci.dp;

/**
 * 9.8
 * @author vcpaks
 *
 */
public class WaysOfCalculatingCents {

	public static void main(String[] args) {
		int[] cents = {1,5,10,25};
		int amount = 10;
		System.out.println(calculateWaysCents(amount, cents));
	}
	
	private static int calculateWaysCents(int amount,int[] cents) {
		int[][] dp = new int[cents.length][amount+1];
		
		for(int i=0;i<cents.length;i++)
			dp[i][0]=1;
		
		for(int i=0;i<cents.length;i++) {
			for(int j=1;j<=amount;j++) {
				int withoutCent = i-1>=0?dp[i-1][j]:0;
				int withCent = j-cents[i]>=0?dp[i][j-cents[i]]:0;
				dp[i][j]=withoutCent+withCent;
			}
		}
		
		return dp[cents.length-1][amount];
		
	}

}
