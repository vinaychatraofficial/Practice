package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BellmanFord2 {
	
	static List<Edge> edges = new ArrayList<>();
	
	public static void main(String[] args) {
		int maxVertices = 5;
		
		addEdge(0, 1, 4);
		addEdge(0, 2, 1);
		addEdge(1, 4, 4);
		addEdge(2, 1, 2);
		addEdge(2, 3, 4);
		addEdge(3, 4, 4);
		addEdge(4, 2, -2);
		Map<Integer,Integer> map = bellmanFord(maxVertices);
		for(Entry<Integer,Integer> e:map.entrySet()) {
			System.out.println(e.getKey()+":"+e.getValue());
		}
	}
	
	private static Map<Integer, Integer> bellmanFord(int maxVertices) {
		Map<Integer,Integer> distMap = new HashMap<>();
		Map<Integer,Integer> parentMap = new HashMap<>();
		for(int i=1;i<maxVertices;i++) {
			distMap.put(i, Integer.MAX_VALUE);
		}
		distMap.put(0, 0);
		for(int i=0;i<maxVertices-1;i++) {
			for(Edge e:edges) {
				if(distMap.get(e.source)+e.weight<distMap.get(e.dest)) {
					distMap.put(e.dest, distMap.get(e.source)+e.weight);
					parentMap.put(e.dest, e.source);
				}
			}
		}
		
		for(Edge e:edges) {
			if(distMap.get(e.source)+e.weight<distMap.get(e.dest)) {
				System.out.println("Negative edge cycle present");
				System.exit(1);
			}
		}
		
		return parentMap;
		
		
	}

	private static void addEdge(int source, int destination, int weight) {
		edges.add(new Edge(source,destination,weight));
	}
	
	public static class Edge{
		int source;
		int dest;
		int weight;
		
		public Edge(int source, int dest, int weight) {
			super();
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
		
		
	}

}
