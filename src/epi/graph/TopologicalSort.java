package epi.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class TopologicalSort {

	public static void main(String[] args) {
		//https://www.geeksforgeeks.org/topological-sorting/
		List<Vertex> v = new ArrayList<>();
		Vertex zero = new Vertex(0);
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		five.edges.add(two);
		five.edges.add(zero);
		two.edges.add(three);
		three.edges.add(one);
		four.edges.add(zero);
		four.edges.add(one);
		v.add(five);
		v.add(four);
		v.add(zero);
		v.add(one);
		v.add(two);
		v.add(three);
		
		Stack<Vertex> s = topSort(v);
		System.out.println("Topological sort");
		while(!s.isEmpty())
			System.out.print(s.pop().label+" ");
	}
	
	private static class Vertex{
		int label;
		List<Vertex> edges = new ArrayList<>();
		
		public Vertex(int label) {
			this.label=label;
		}
	}
	
	private static Stack<Vertex> topSort(List<Vertex> vertices){
		List<Vertex> visited = new ArrayList<>();
		Stack<Vertex> orderedVertices = new Stack<>();
		System.out.println("DFS");
		for(Vertex v:vertices) {
			if(!visited.contains(v))
				dfs(v, visited, orderedVertices);
		}
		System.out.println();
		return orderedVertices;
	}

	private static void dfs(Vertex v, List<Vertex> visited, Stack<Vertex> orderedVertices) {
		visited.add(v);
		System.out.print(v.label+" ");
		for(Vertex next:v.edges) {
			if(!visited.contains(next))
				dfs(next,visited,orderedVertices);
		}
		orderedVertices.push(v);
	}

}
