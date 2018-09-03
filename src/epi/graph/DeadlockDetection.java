package epi.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vcpaks
 * 18.4 Deadlock detection
 */
public class DeadlockDetection {

	public static void main(String[] args) {
		List<Integer> vertices = new ArrayList<>();
		vertices.add(0);
		vertices.add(1);
		vertices.add(2);
		vertices.add(3);
		vertices.add(4);
		vertices.add(5);
		Map<Integer,List<Integer>> edges = new HashMap<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		edges.put(0, list1);
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(3);
		edges.put(1, list2);
		List<Integer> list3 = new ArrayList<>();
		list3.add(4);
		list3.add(5);
		edges.put(2, list3);
		List<Integer> list4 = new ArrayList<>();
		list4.add(1);
		edges.put(5, list4);
		System.out.println(hasCycle(vertices,edges));
	}
	
	private static boolean hasCycle(List<Integer> vertices, Map<Integer,List<Integer>> edges) {
		//0 white, 1 gray, 2 black. While traversing DFS if there is a vertex we encounter which is gray, then there is a cycle
		//Gray means it is already visited
		Map<Integer,Integer> colorMap = new HashMap<>();
		//color all vertices white
		for(Integer vertex:vertices) {
			colorMap.put(vertex, 0);
		}
		
		for(Integer vertex:vertices) {
			if(hasCycle(edges,vertex,colorMap))
				return true;
		}
		
		return false;
	}

	private static boolean hasCycle(Map<Integer, List<Integer>> edges, Integer vertex, Map<Integer, Integer> colorMap) {
		if(colorMap.get(vertex)==1)
			return true;
		
		colorMap.put(vertex, 1);
		if(edges.get(vertex)!=null){
			for(Integer next:edges.get(vertex)) {
				if(colorMap.get(vertex)!=2 && hasCycle(edges, next, colorMap))
					return true;
			}
		}
		
		colorMap.put(vertex, 2);
		return false;
	}

}
