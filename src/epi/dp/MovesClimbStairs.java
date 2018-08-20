package epi.dp;

public class MovesClimbStairs {

	public static void main(String[] args) {
		int n=4;
		int k=2;
		int[] noOfWays = new int[n+1];
		System.out.println(numberOfWaysStairs(n, k,noOfWays));
		System.out.println(numberOfWaysStairsIt(n, k));
	}
	
	private static int numberOfWaysStairs(int n, int k, int[] noOfWays) {
		if(n<0)
			return 0;
		if(n==0)
			return 1;
		
		if(noOfWays[n]==0) {
			for(int i=1;i<=k && (n-i)>=0;i++) {
				noOfWays[n]+=numberOfWaysStairs(n-i, k, noOfWays);
			}
		}
		
		return noOfWays[n];
	}
	
	private static int numberOfWaysStairsIt(int n,int k) {
		int[]  noOfWays = new int[n+1];
		noOfWays[0]=1;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k && (i-j)>=0;j++) {
				noOfWays[i]+=noOfWays[i-j];
			}
		}
		
		return noOfWays[n];
	}

}
