package dp;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

	public static void main(String[] args) {
		int[] arr = {2,3,7,8,10};
		int sum =11;
		boolean check = findSubsetSum(arr,sum);
		System.out.println(check);
	}

	private static boolean findSubsetSum(int[] arr, int sum) {
		boolean[][] check = new boolean[arr.length][sum+1];
		for(int i=0;i<arr.length;i++)
			check[i][0]=true;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=1;j<=sum;j++) {
				boolean withoutScore = i-1>=0?check[i-1][j]:false;
				boolean withScore = j-arr[i]>=0? (i-1>=0?check[i-1][j-arr[i]]:j==arr[i]):false;
				check[i][j]=withoutScore||withScore;
			}
		}
		
		int i=arr.length-1;
		int j=sum;
		List<Integer> list = new ArrayList<>();
		if(check[arr.length-1][sum]) {
			while(i>0 && j>0) {
				//System.out.println("Checking "+check[i-1][j]+" for "+arr[i]+","+j);
				if(check[i-1][j]) {
					i=i-1;
				}else {
					
					list.add(arr[i]);
					j=j-arr[i];
					i=i-1;
				}
			}
		}
		
		System.out.println(list);
		
		return check[arr.length-1][sum];
		
	}

}
