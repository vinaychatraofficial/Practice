package graph;

import java.util.List;

public class BellmanFord {
	
	static int distance[];

	public static void main(String[] args) {
		DirectedGraph g = DirectedGraph.initializeWeightedGraph();
		distance = new int[g.vertexCount];
		findShortestPath(g, 0);
		for(int i=0;i<g.vertexCount;i++)
			System.out.println(i+" "+distance[i]);
	}
	
	private static void findShortestPath(DirectedGraph g, int source) {
		for(int i=0;i<g.vertexCount;i++)
			distance[i] = Integer.MAX_VALUE;
		distance[source] = 0;
		
		for(int i=1;i<=g.vertexCount-1;i++) {
			for(int j=0;j<g.vertexCount;j++) {
				List<Integer> adjList = g.adjacencyList.get(j);
				for(int adj:adjList) {
					int newDist = distance[j]+g.adjacencyMaxtrix[j][adj];
					if(distance[adj]>newDist) {
						distance[adj]=newDist;
					}
				}
			}
		}
	}

}
