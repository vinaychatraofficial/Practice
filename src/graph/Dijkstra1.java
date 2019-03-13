package graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Dijkstra1 {
	
	static int[][] adjacencyMatrix ;
	public static void main(String[] args) {
		int maxVertices = 7;
		adjacencyMatrix = new int[maxVertices][maxVertices];
		for(int i=0;i<maxVertices;i++) {
			for(int j=0;j<maxVertices;j++) {
				adjacencyMatrix[i][j]=0;
			}
		}
		addEdge(0, 2, 7);
		addEdge(0, 3, 5);
		addEdge(1, 4, 5);
		addEdge(2, 1, 8);
		addEdge(2, 4, 7);
		addEdge(2, 3, 9);
		addEdge(3, 4, 15);
		addEdge(3, 5,6);
		addEdge(4,5,8);
		addEdge(4, 6,9);
		addEdge(5, 6, 11);
		Map<Integer,Integer> map = dijkstra(maxVertices);
		for(Entry<Integer,Integer> e:map.entrySet()) {
			System.out.println(e.getKey()+":"+e.getValue());
		}
	}
	
	private static Map<Integer,Integer> dijkstra(int maxVertices) {
		Map<Integer,Integer> distMap = new HashMap<>();
		Map<Integer,Integer> parentMap = new HashMap<>();
		Map<Integer,Integer> finalMap = new HashMap<>();
		PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return Integer.compare(p1.dist, p2.dist);
			}
		});
		for(int i=1;i<maxVertices;i++) {
			distMap.put(i, Integer.MAX_VALUE);
			minHeap.offer(new Pair(i,Integer.MAX_VALUE));
		}
		distMap.put(0, 0);
		minHeap.offer(new Pair(0,0));
		parentMap.put(0, null);
		while(!minHeap.isEmpty()) {
			Pair cur = minHeap.poll();
			for(int i=0;i<maxVertices;i++) {
				if(adjacencyMatrix[cur.vertex][i]>0 && distMap.containsKey(i)) {
					if(distMap.get(i)>cur.dist+adjacencyMatrix[cur.vertex][i]) {
						int newDist = cur.dist+adjacencyMatrix[cur.vertex][i];
						minHeap.remove(new Pair(i,distMap.get(i)));
						distMap.put(i, newDist);
						minHeap.offer(new Pair(i,newDist));
						parentMap.put(i, cur.vertex);
					}
				}
			}
			distMap.remove(cur.vertex);
			finalMap.put(cur.vertex, cur.dist);
		}
		return parentMap;
	}

	private static void addEdge(int source, int destination, int weight) {
		adjacencyMatrix[source][destination]=weight;
		adjacencyMatrix[destination][source]=weight;
	}
	
	public static class Pair{
		int vertex;
		int dist;
		
		public Pair(int vertex, int dist) {
			this.vertex = vertex;
			this.dist = dist;
		}
		
		public boolean equals(Object o) {
			if(o==null)
				return false;
			if(o instanceof Pair) {
				Pair p = (Pair)o;
				return this.vertex==p.vertex && this.dist==p.dist;
			}
			return false;
		}
	}

}
