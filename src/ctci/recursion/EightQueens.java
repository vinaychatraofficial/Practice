package ctci.recursion;

import java.util.ArrayList;

/**
 * @author vcpaks
 * 9.9
 */
public class EightQueens {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> cols = new ArrayList<>();
		for(int i=0;i<8;i++)
			cols.add(-1);
		placeQueens(0,cols,res);
		for(ArrayList<Integer> list:res ) {
			for(Integer num:list) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

	private static void placeQueens(int row, ArrayList<Integer> cols, ArrayList<ArrayList<Integer>> res) {
		//if row has reached 8 we have placed all queens. Add to result
		if(row==8) {
			res.add(new ArrayList(cols));
			return;
		}
		
		for(int col=0;col<8;col++) {
			if(placementPossible(row,col,cols)) {
				cols.set(row, col);
				placeQueens(row+1, cols, res);
			}
		}
	}

	private static boolean placementPossible(int row, int col, ArrayList<Integer> cols) {
		for(int oldrow=0;oldrow<row;oldrow++) {
			int oldcol = cols.get(oldrow);
			//check if this col is occupied
			if(col==oldcol)
				return false;
			
			int coldiff = Math.abs(oldcol-col);
			int rowdiff = row-oldrow;
			//check if this cell falls on the diagonal
			if(coldiff==rowdiff)
				return false;
		}
		return true;
	}

}
