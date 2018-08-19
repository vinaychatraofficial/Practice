package epi.dp;

/**
 * @author vcpaks
 * 16.9 Pick coins for maximum gain
 * max rev = Math.max(C(a)+Math.min(rev(a+2,b),rev(a+1,b-1)),
 * 					  C(b)+Math.min(rev(a+1,b-1),rev(a,b-2))
 * 					  )
 */
public class PickCoinsMaxGain {

	public static void main(String[] args) {
		int[] coins = {25,5,10,5,10,5,10,25,1,25,1,25,1,25,5,10};
		int[][] rev = new int[coins.length][coins.length];
		System.out.println(maxRevenue(0, coins.length-1, coins, rev));
	}
	
	private static int maxRevenue(int a, int b, int[] coins, int[][] rev) {
		if(a>b)
			return 0;
		
		if(rev[a][b]==0) {
			int maxA = coins[a]+Math.min(maxRevenue(a+2, b, coins, rev), maxRevenue(a+1, b-1, coins, rev));
			int maxB = coins[b]+Math.min(maxRevenue(a+1, b-1, coins, rev), maxRevenue(a, b-2, coins, rev));
			rev[a][b] = Math.max(maxA, maxB);
		}
		
		return rev[a][b];
	}

}
