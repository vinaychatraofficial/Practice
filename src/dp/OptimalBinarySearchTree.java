package dp;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		int[] arr = {10,12,16,21};
		int[] cost = {4,2,6,3};
		int min = findMinCost(arr,cost);
		System.out.println(min);
	}

	private static int findMinCost(int[] arr, int[] cost) {
		int[][] minCost = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++) {
			minCost[i][i]=cost[i];
		}
		
		for(int length=2;length<=arr.length;length++) {
			for(int i=0;i<=arr.length-length;i++) {
					int end = i+length-1;
					int sum=0;
					for(int k=i;k<=end;k++) {
						sum+=cost[k];
					}
					int min = Integer.MAX_VALUE;
					for(int j=i;j<=end;j++) {
						int left = j-1>=i?minCost[i][j-1]:0;
						int right = j+1<=end?minCost[j+1][end]:0;
						int tempSum = left+right;
						if(tempSum<min) {
							min=tempSum;
						}
					}
					minCost[i][end]=sum+min;
			}
			
		}
		return minCost[0][arr.length-1];
	}

}
