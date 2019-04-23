package ae;

import java.util.ArrayList;

public class KnapsackProblem {

	public static ArrayList<ArrayList<Integer>> knapsackProblem(int[][] items, int capacity) {
		int[][] values = new int[items.length][capacity+1];
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		for(int i=0;i<items.length;i++){
			for(int j=0;j<=capacity;j++){
				int withoutItem = i-1>=0 ? values[i-1][j]:0;
				int withItem = j-items[i][1] >=0? (items[i][0] + (i-1>=0 ? values[i-1][j-items[i][1]]:0)):0;
				values[i][j] = Math.max(withoutItem, withItem);
			}
		}
		//System.out.println("final value:"+values[items.length-1][capacity]);
		ArrayList<Integer> maxValue = new ArrayList<>();
		maxValue.add(values[items.length-1][capacity]);
		res.add(maxValue);

		int i=items.length-1,j=capacity;
		ArrayList<Integer> itemList = new ArrayList<>();
		while(i>=0 && values[i][j]!=0){
			if(i>=1 && values[i][j] == values[i-1][j])
				i--;
			else{
				itemList.add(0,i);
				j=j-items[i][1];
				i--;
			}
		}
		/*for(int item:itemList)
				System.out.print(item+" ");*/
		res.add(itemList);
		return res;
	}
}
