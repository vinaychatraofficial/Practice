package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DijkstraQueue {
	
	static int[] distance;
	static Set<Integer> settled;

	public static void main(String[] args) {
		DirectedGraph g = DirectedGraph.initializeWeightedGraph();
		distance = new int[g.vertexCount];
		settled = new HashSet<>();
		findShortestPath(g, 0);
		for(int i=0;i<g.vertexCount;i++)
			System.out.println(i+" "+distance[i]);
	}
	
	private static void findShortestPath(DirectedGraph g, int source) {
		for(int i=0;i<g.vertexCount;i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		distance[source]=0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		while(!q.isEmpty()) {
			Integer minVertex = findMinVertex(g, q);
			q.remove(minVertex);
			settled.add(minVertex);
			List<Integer> adjList = g.adjacencyList.get(minVertex);
			for(Integer adj:adjList) {
				if(!settled.contains(adj)) {
					int newDistance = distance[minVertex]+g.adjacencyMaxtrix[minVertex][adj];
					if(distance[adj]>newDistance) {
						distance[adj]=newDistance;
					}
					q.add(adj);
				}
			}
		}
		
	}

	private static Integer findMinVertex(DirectedGraph g, Queue<Integer> q) {
		int minIndex = 0;
		int minValue=Integer.MAX_VALUE;
		for(int i=0;i<g.vertexCount;i++) {
			if(q.contains(i)) {
				if(distance[i]<minValue) {
					minValue = distance[i];
					minIndex=i;
				}
			}
		}
		return minIndex;
	}

}
