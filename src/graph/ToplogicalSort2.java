package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ToplogicalSort2 {
	static int[][] adjacencyMatrix ;
	public static void main(String[] args) {
		int maxVertices = 7;
		adjacencyMatrix = new int[maxVertices][maxVertices];
		for(int i=0;i<maxVertices;i++) {
			for(int j=0;j<maxVertices;j++) {
				adjacencyMatrix[i][j]=0;
			}
		}
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 3);
		addEdge(1, 4);
		addEdge(3, 5);
		addEdge(4, 5);
		addEdge(5, 6);
		
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<7;i++) {
			if(!visited.contains(i))
				topSort(i,visited,s);
		}
		
		while(!s.isEmpty())
			System.out.println(s.pop());
	}
	
	private static void topSort(int v, Set<Integer> visited, Stack<Integer> s) {
		visited.add(v);
		for(int i=0;i<7;i++) {
			if(adjacencyMatrix[v][i]==1 && !visited.contains(i)) {
				topSort(i,visited,s);
			}
		}
		s.push(v);
	}

	private static void addEdge(int source, int destination) {
		adjacencyMatrix[source][destination]=1;
	}

}
