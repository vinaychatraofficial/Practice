package ctci.dp;

/**
 * 9.1
 * @author vcpaks
 *
 */
public class NumberOfStairs {
	
	static int dpRec[];

	public static void main(String[] args) {
		dpRec = new int[4+1];
		System.out.println(countStairRec(4));
		System.out.println(countStairIt(4));
	}
	
	private static int countStairRec(int n) {
		if(n<0)
			return 0;
		else if(n==0)
			return 1;
		else if(dpRec[n]!=0)
			return dpRec[n];
		else {
			dpRec[n]=countStairRec(n-1)+countStairRec(n-2)+countStairRec(n-3);
		}
		return dpRec[n];
	}
	
	private static int countStairIt(int n) {
		int[] dp=new int[n+1];
		dp[0]=1;
		for(int i=1;i<=n;i++) {
			for(int k=1;k<=3;k++) {
				if((i-k)>=0)
					dp[i]+=dp[i-k];
			}
		}
		return dp[n];
	}
	

}
