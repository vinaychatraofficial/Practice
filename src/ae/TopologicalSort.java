package ae;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

	public static ArrayList<Integer> topologicalSort(ArrayList<Integer> jobs, ArrayList<Integer[]> deps) {
		Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		Map<Integer,Boolean> visited = new HashMap<>();
		for(Integer[] dep:deps){
			if(!graph.containsKey(dep[1])){
				ArrayList<Integer> children = new ArrayList<>();
				children.add(dep[0]);
				graph.put(dep[1],children);
			}else{
				ArrayList<Integer> children = graph.get(dep[1]);
				children.add(dep[0]);
			}
		}

		for(Integer job:jobs){
			if(!visited.containsKey(job)){
				boolean valid = topologicalSort(jobs,graph,job,visited,res);
				if(!valid)
					return new ArrayList<>();
			}
		}

		for(int elem:res)
			System.out.print(elem+" ");

		return res;
	}

	private static boolean topologicalSort(ArrayList<Integer> jobs,Map<Integer,ArrayList<Integer>> graph, Integer job,
			Map<Integer,Boolean> visited, ArrayList<Integer> res) {
		if(res.size()==jobs.size())
			return true;

		visited.put(job,false);
		List<Integer> children = graph.containsKey(job)?graph.get(job):new ArrayList<>();
		for(Integer child:children){
			if(!visited.containsKey(child)){
				boolean valid = topologicalSort(jobs,graph,child,visited,res);
				if(!valid)
					return false;
			}
			else if(visited.get(child)==false)//if processing, there is a cycle
				return false;
		}
		visited.put(job,true);
		res.add(job);
		return true;
	}
}
