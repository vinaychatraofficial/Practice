/**
 * 
 */
package dp;

/**
 * Number of ways you can reach n = number of ways you can reach n-1 + 1 step
 *                                + number of ways you can reach n-2 + 2 step
 *                                .....
 *                                + number of ways you can reach n - k + k step
 * @author vcpaks
 *
 */
public class StairCase {

	public static void main(String[] args) {
		int n=4,k=2;
		int ways = computeWays(n,k);
		System.out.println(ways);
	}

	private static int computeWays(int n, int k) {
		int[] ways = new int[n+1];
		ways[0]=1;
		ways[1]=1;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				ways[i]+=ways[i-j];
			}
		}
		return ways[n];
	}

}
