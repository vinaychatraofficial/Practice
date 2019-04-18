package ae;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

	public static ArrayList<ArrayList<Integer>> getPermutations(ArrayList<Integer> array) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> visited = new ArrayList<>();
		//faster checking for visited nodes
		Set<Integer> set = new HashSet<>();
		for(Integer num:array){ 
			visited.add(num);
			set.add(num);
			getPermutations(array, res, set, visited);
			visited.remove(num);
			set.remove(num);
		}

		return res;
	}

	private static void getPermutations(ArrayList<Integer> array, 
			ArrayList<ArrayList<Integer>> res,
			Set<Integer> set,
			ArrayList<Integer> visited){
		if(visited.size()==array.size()){
			res.add(new ArrayList(visited));
			return;
		}

		for(Integer num:array){
			if(!set.contains(num)){
				visited.add(num);
				set.add(num);
				getPermutations(array, res, set, visited);
				visited.remove(visited.size()-1);
				set.remove(num);
			}
		}
	}
}
