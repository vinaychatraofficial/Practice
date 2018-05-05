package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnweightedShortestPath {

	static int[] distance;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		DirectedGraph g  = DirectedGraph.initialize();
		distance = new int[g.vertexCount];
		q = new LinkedList<>();
		unweightedShortestPath(g, 0);
		for(int i=0;i<g.vertexCount;i++)
		System.out.println(distance[i]);
	}
	
	private static void unweightedShortestPath(DirectedGraph g, int source) {
		for(int i=0;i<g.vertexCount;i++)
			distance[i]=-1;
		distance[source]=0;
		q.add(source);
		while(!q.isEmpty()) {
			int v = q.remove();
			List<Integer> sourceList = g.adjacencyList.get(v);
			for(Integer adj:sourceList) {
				if(distance[adj]==-1) {
					distance[adj]=distance[v]+1;
					q.add(adj);
				}
			}
		}
		
	}

}
