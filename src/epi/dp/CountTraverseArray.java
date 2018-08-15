package epi.dp;

import java.util.Arrays;

/**
 * @author vcpaks
 * 16.3 Count number of ways to traverse a 2D array
 */
public class CountTraverseArray {

	public static void main(String[] args) {
		System.out.println(countTraverseArrIt(5, 5));
		int[][] arr = new int[5][5];
		for(int[] row:arr)
			Arrays.fill(row, -1);
		System.out.println(countTraverseArrRec(4, 4, arr));
	}
	
	private static int countTraverseArrIt(int n, int m) {
		int[][] arr = new int[n][m];
		arr[0][0]=1;
		
		for(int i=0;i<n;i++) {
			arr[i][0]=1;
		}
		
		for(int j=0;j<m;j++) {
			arr[0][j]=1;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				arr[i][j]=arr[i-1][j] + arr[i][j-1];
			}
		}
		
		return arr[n-1][m-1];
	}
	
	private static int countTraverseArrRec(int i, int j, int[][] arr) {
		if(i==0 || j==0)
			return 1;
		
		if(arr[i][j]==-1) {
			arr[i][j] = countTraverseArrRec(i-1, j, arr) + countTraverseArrRec(i, j-1, arr);
		}
		
		return arr[i][j];
	}

}
