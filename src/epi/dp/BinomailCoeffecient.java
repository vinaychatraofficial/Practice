package epi.dp;

import java.util.Arrays;

/**
 * @author vcpaks
 * 16.4 Compute the binomial coefficients
 */
public class BinomailCoeffecient {

	public static void main(String[] args) {
		int n=5, r=2;
		int[][] arr = new int[n+1][r+1];
		for(int[] row:arr)
			Arrays.fill(row, 0);
		System.out.println(ncr(n,r,arr));
		System.out.println(ncrIt(n, r));
	}
	
	private static int ncr(int n, int r, int[][] arr) {
		if(r==0||n==r)
			return 1;
		
		if(arr[n][r]==0) {
			//n-1,r-1 means nth element is definitely present n-1cr-1*1c1
			//n-1cr means nth element not present
			arr[n][r] = ncr(n-1,r-1,arr)+ncr(n-1,r,arr);
		}
		
		return arr[n][r];
	}
	
	private static int ncrIt(int n,int r) {
		int[][] arr = new int[n+1][r+1];
		for(int i=0;i<=n;i++)
			arr[i][0]=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=r;j++) {
				
				if(i==j)
					arr[i][j]=1;
				else {
					arr[i][j] = arr[i-1][j-1]*arr[1][1]+arr[i-1][j];
				}
				
			}
		}
		
		return arr[n][r];
	}

}
