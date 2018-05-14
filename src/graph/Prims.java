package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Prims {
	
	static int[] key;
	static int[] parent;
	static Set<Integer> settled;

	public static void main(String[] args) {
		Graph g = Graph.initializeWeightedGraph();
		key = new int[g.vertexCount];
		parent = new int[g.vertexCount];
		settled = new HashSet<>();
		findMST(g, 0);
		
	}
	
	private static void findMST(Graph g, int source) {
		for(int i=0;i<g.vertexCount;i++) {
			key[i]=Integer.MAX_VALUE;
		}
		key[source]=0;
		parent[source]=-1;
		Queue<Integer> q = new LinkedList<>();
		
		q.add(source);
		while(!q.isEmpty()) {
			int minVertex = findMinVertex(g,q);
			q.remove(minVertex);
			settled.add(minVertex);
			System.out.println("Vertex "+minVertex+" from "+parent[minVertex]+" of length "+key[minVertex]);
			List<Integer> adjList = g.adjacencyList.get(minVertex);
			for(int adj:adjList) {
				if(!settled.contains(adj)) {
					if(key[adj]>g.adjacencyMaxtrix[minVertex][adj]) {
						key[adj]=g.adjacencyMaxtrix[minVertex][adj];
						parent[adj]=minVertex;
					}
					if(!q.contains(adj))
						q.add(adj);
				}
			}
		}
	}

	private static int findMinVertex(Graph g, Queue<Integer> q) {
		int minIndex = 0, minValue=Integer.MAX_VALUE;
		for(int i=0;i<g.vertexCount;i++) {
			if(q.contains(i)) {
				if(key[i]<minValue) {
					minValue = key[i];
					minIndex = i;
				}
			}
		}
		
		return minIndex;
	}

}
