package ae;

import java.util.ArrayList;
import java.util.HashMap;

public class FourNumberSum {

	public static ArrayList<Integer[]> fourNumberSum(int[] array, int targetSum) {
		HashMap<Integer,ArrayList<Integer[]>> pairSum = new HashMap<>();
		ArrayList<Integer[]> quad = new ArrayList<>();
		//skipping first one since there wont be anything in map to check
		//skipping last one since there no pair can be formed with last number
		for(int i=1;i<array.length-1;i++){
			//check all numbers after it if diff is found in map
			for(int j=i+1;j<array.length;j++){
				int sum = array[i]+array[j];
				if(pairSum.containsKey(targetSum - sum)){
					ArrayList<Integer[]> pairs = pairSum.get(targetSum - sum);
					for(Integer[] pair : pairs){
						quad.add(new Integer[]{array[i],array[j],
								pair[0],
								pair[1]});
					}
				}
			}

			//add pairs using numbers before it
			for(int k=0;k<i;k++){
				int sum = array[i] +array[k];
				if(!pairSum.containsKey(sum)){
					ArrayList<Integer[]> newList = new ArrayList<>();
					newList.add(new Integer[]{array[i],array[k]});
					pairSum.put(sum,newList);
				}else{
					ArrayList<Integer[]> exList = pairSum.get(sum);
					exList.add(new Integer[]{array[i],array[k]});
				}
			}
		}
		return quad;
	}
}
