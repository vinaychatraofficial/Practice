package epi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import epi.graph.MakingWiredConnections.Vertex;

/**
 * @author vcpaks
 * 18.8 Team photo 2 - largest number of teams in front of each other
 */
public class TeamPhoto2 {

	public static void main(String[] args) {
		List<Vertex> v = new ArrayList<>();
		Vertex zero = new Vertex(0);
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		zero.edges.add(one);
		one.edges.add(two);
		one.edges.add(three);
		three.edges.add(four);
		three.edges.add(two);
		four.edges.add(five);
		//four.edges.add(five);
		v.add(zero);
		v.add(one);
		v.add(two);
		v.add(three);
		v.add(four);
		v.add(five);
		System.out.println(findLongestPath(v));
	}
	
	private static class Vertex{
		int label;
		List<Vertex> edges = new ArrayList<>();
		
		public Vertex(int label) {
			this.label=label;
		}
	}
	
	private static int findLongestPath(List<Vertex> graph) {
		Map<Vertex, Integer> distMap = new HashMap<>();
		Stack<Vertex> sortedVertices = topSort(graph, distMap);
		return findLongestPath(sortedVertices,graph, distMap);
	}

	private static int findLongestPath(Stack<Vertex> sortedVertices, List<Vertex> graph, Map<Vertex, Integer> distMap) {
		int maxDist = 0;
		while(!sortedVertices.isEmpty()) {
			Vertex cur = sortedVertices.pop();
			maxDist = Math.max(maxDist, distMap.get(cur));
			for(Vertex next:cur.edges) {
				distMap.put(next, Math.max(distMap.get(next), distMap.get(cur)+1));
			}
		}
		return maxDist;
	}

	private static Stack<Vertex> topSort(List<Vertex> graph, Map<Vertex, Integer> distMap) {
		Stack<Vertex> sortedVertices = new Stack<>();
		List<Vertex> visited = new ArrayList<>();
		for(Vertex v:graph) {
			if(!visited.contains(v))
				dfs(graph,sortedVertices, visited, v, distMap);
		}
		return sortedVertices;
	}

	private static void dfs(List<Vertex> graph, Stack<Vertex> sortedVertices, List<Vertex> visited, Vertex v, Map<Vertex, Integer> distMap) {
		visited.add(v);
		distMap.put(v, 1);
		for(Vertex next:v.edges) {
			if(!visited.contains(next))
				dfs(graph,sortedVertices,visited,next, distMap);
		}
		sortedVertices.push(v);
	}

}
