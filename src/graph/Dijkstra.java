package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class WeightedVertex{
	int index;
	int weight;
	
	public WeightedVertex(int index, int weight) {
		super();
		this.index = index;
		this.weight = weight;
	}
	
	
}

class WeightComparator implements Comparator<WeightedVertex>{

	@Override
	public int compare(WeightedVertex v1, WeightedVertex v2) {
		if(v1.weight<v2.weight)
			return -1;
		else if(v1.weight>v2.weight)
			return 1;
		else
			return 0;
	}
	
}


public class Dijkstra {
	
	static Set<Integer> settledNodes;
	static int[] path;
	static int[] distance;
	static PriorityQueue<WeightedVertex> pq;

	public static void main(String[] args) {
		DirectedGraph g = DirectedGraph.initializeWeightedGraph();
		settledNodes = new HashSet<>();
		path = new int[g.vertexCount];
		distance = new int[g.vertexCount];
		pq = new PriorityQueue<>(new WeightComparator());
		findShortestPath(g, 0);
		for(int i=0;i<distance.length;i++)
			System.out.println(distance[i]);
	}
	
	private static void findShortestPath(DirectedGraph g, int source) {
		for(int i=0;i<g.vertexCount;i++)
			distance[i]=Integer.MAX_VALUE;
		distance[source]=0;
		pq.add(new WeightedVertex(0, distance[0]));
		
		while(!pq.isEmpty()) {
			WeightedVertex minVertex = pq.remove();
			if(!settledNodes.contains(minVertex.index)) {
				List<Integer> sourceList = g.adjacencyList.get(minVertex.index);
				for(Integer adj:sourceList) {
					if(distance[adj]>(distance[minVertex.index])+g.adjacencyMaxtrix[minVertex.index][adj]) {
						distance[adj]=distance[minVertex.index]+g.adjacencyMaxtrix[minVertex.index][adj];
					}
					pq.add(new WeightedVertex(adj, distance[adj]));
				}
				settledNodes.add(minVertex.index);
			}
		}
	}

	private static WeightedVertex findMinimum(List<WeightedVertex> unsettledNodes) {
		int minValue=Integer.MAX_VALUE;
		WeightedVertex minVertex = null;
		
		for(WeightedVertex vertex:unsettledNodes) {
			if(vertex.weight<minValue) {
				minValue = vertex.weight;
				minVertex = vertex;
			}
		}
		
		return minVertex;
	}

}
