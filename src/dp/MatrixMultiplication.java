package dp;

public class MatrixMultiplication {

	public static void main(String[] args) {
		int[] arr = {4,2,3,5,3};
		int maxCost = findCostMul(arr);
		System.out.println(maxCost);
	}

	private static int findCostMul(int[] arr) {
		int[][] cost = new int[arr.length-1][arr.length-1];
		for(int i=0;i<arr.length-1;i++)
			cost[i][i]=0;
		
		for(int length=2;length<=arr.length-1;length++) {
			for(int i=0;i<=arr.length-1-length;i++) {
				int end = i+length-1;
				cost[i][end]=Integer.MAX_VALUE;
				for(int j=i;j<end;j++) {
					int curcost = cost[i][j]+cost[j+1][end]+arr[i]*arr[j+1]*arr[end+1];
					
					if(curcost<cost[i][end]) {
						cost[i][end]=curcost;
						//System.out.println(curcost);
					}
				}
			}
		}
		return cost[0][arr.length-2];
	}

}
