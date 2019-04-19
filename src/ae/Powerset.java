package ae;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Powerset {

	public static ArrayList<ArrayList<Integer>> powerset(ArrayList<Integer> array) {
		//return powersetOne(array);
		//return powersetRec(array);
		return powersetIt(array);
	}

	private static ArrayList<ArrayList<Integer>> powersetIt(ArrayList<Integer> array) {
		ArrayList<ArrayList<Integer>> set = new ArrayList<>();
		set.add(new ArrayList());
		for(Integer num:array){
			int length = set.size();
			for(int i=0;i<length;i++){
				ArrayList<Integer> newSubset = new ArrayList(set.get(i));
				newSubset.add(num);
				set.add(newSubset);
			}
		}
		return set;
	}

	private static ArrayList<ArrayList<Integer>> powersetRec(ArrayList<Integer> array) {
		ArrayList<ArrayList<Integer>> set = new ArrayList<>();
		set.add(new ArrayList());
		powersetTwo(array,0,set);
		return set;
	}

	private static void powersetTwo(ArrayList<Integer> array, int idx,
			ArrayList<ArrayList<Integer>> set){
		if(idx==array.size())
			return;

		int elem = array.get(idx);
		int length = set.size();
		for(int i=0;i<length;i++){
			ArrayList<Integer> newSubset = new ArrayList(set.get(i));
			newSubset.add(elem);
			set.add(newSubset);
		}
		powersetTwo(array,idx+1,set);
	}

	private static ArrayList<ArrayList<Integer>> powersetOne(ArrayList<Integer> array) {
		Set<Set<Integer>> set = new HashSet<>();

		Set<Integer> visited = new HashSet<>();
		set.add(new HashSet());
		for(Integer num:array){
			visited.add(num);
			powerset(array,set,visited);
			visited.remove(num);
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		for(Set<Integer> s:set){
			ArrayList<Integer> temp =	new ArrayList(s);
			res.add(temp);
			for(Integer elem:s)
				System.out.print(elem+" ");
			System.out.println();
		}

		return res;
	}

	private static void powerset(ArrayList<Integer> array, Set<Set<Integer>> set,
			Set<Integer> visited){
		if(!set.contains(visited)){
			set.add(new HashSet(visited));
		}

		for(Integer num:array){
			if(!visited.contains(num)){
				visited.add(num);
				powerset(array,set,visited);
				visited.remove(num);
			}
		}

	}
}
