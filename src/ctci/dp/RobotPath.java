package ctci.dp;

/**
 * 9.2
 * @author vcpaks
 *
 */
public class RobotPath {
	static int[][] dp;
	public static void main(String[] args) {
		int x=3,y=4;
		dp = new int[x][y];
		System.out.println(findPaths(x,y));
	}
	private static int findPaths(int x, int y) {
		dp[0][0]=1;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(i==0 && j==0)
					continue;
				int right = (i-1)>=0?dp[i-1][j]:0;
				int down = (j-1)>=0?dp[i][j-1]:0;
				dp[i][j]=right+down;
				//System.out.println(i+","+j+":"+dp[i][j]);
			}
		}
		return dp[x-1][y-1];
	}

}
