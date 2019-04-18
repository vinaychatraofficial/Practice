package ae;

import java.util.ArrayList;

public class Permutations {

	public static ArrayList<ArrayList<Integer>> getPermutations(ArrayList<Integer> array) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> visited = new ArrayList<>();
    for(Integer num:array){ 
			visited = new ArrayList<>();
			visited.add(num);
			getPermutations(array, res, visited);
		}
		
		return res;
  }
	
	private static void getPermutations(ArrayList<Integer> array, 
																			ArrayList<ArrayList<Integer>> res,
																			ArrayList<Integer> visited){
		if(visited.size()==array.size()){
			res.add(new ArrayList(visited));
			return;
		}
		
		for(Integer num:array){
			if(!visited.contains(num)){
				visited.add(num);
				getPermutations(array, res, visited);
				visited.remove(visited.size()-1);
			}
		}
	}
}
