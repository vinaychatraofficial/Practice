package ae;

public class SearchInSortedMatrix {

	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
		int row = 0;
		int col = matrix[0].length-1;

		while(row < matrix.length && col >= 0){
			//System.out.println(row+":"+col);
			if(matrix[row][col] == target)
				return new int[]{row, col};
			else if(target < matrix[row][col])
				col--;
			else
				row++;
		}
		return new int[]{-1,-1};
	}
}
