package epi.searching;

/**
 * @author vcpaks
 * 11.6 Search in a 2D Sorted Array
 */
public class Search2DArray {

	public static void main(String[] args) {
		int[][] arr = {{-1,2,4,4,6},{1,5,5,9,21},{3,6,6,9,22},{3,6,8,10,24},{6,8,9,12,25},{8,10,12,13,40}};
		System.out.println(search2DArray(arr, 7));
	}
	
	private static boolean search2DArray(int[][] arr, int k) {
		int m=arr.length;
		int n=arr[0].length;
		int row=0,col=n-1;
		
		while(row<=m-1 && col>=0) {
			if(arr[row][col]==k)
				return true;
			else if(arr[row][col]<k)
				row++;
			else
				col--;
		}
		
		return false;
	}

}
