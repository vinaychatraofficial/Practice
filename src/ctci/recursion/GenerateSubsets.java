package ctci.recursion;

import java.util.ArrayList;

public class GenerateSubsets {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		genSubset(arr,arr.length-1,res);
		for(ArrayList<Integer> list:res) {
			for(Integer elem:list) {
				System.out.print(elem+" ");
			}
			System.out.println();
		}
	}

	private static void genSubset(int[] arr, int index, ArrayList<ArrayList<Integer>> res) {
		if(index==-1) {
			ArrayList<Integer> temp = new ArrayList<>();
			res.add(temp);
			return;
		}
		
		int elem = arr[index];
		genSubset(arr,index-1,res);
		ArrayList<ArrayList<Integer>> newSet = new ArrayList<>();
		for(ArrayList<Integer> list:res) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(list);
			temp.add(elem);
			newSet.add(temp);
		}
		res.addAll(newSet);
	}

}
