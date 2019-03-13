package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Prims3 {
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
		prims(maxVertices);
	}
	
	private static void prims(int maxVertices) {
		Map<Integer,Integer> distMap = new HashMap<>();
		Map<Integer,Integer> parentMap = new HashMap<>();
		PriorityQueue<Pair> q = new PriorityQueue(new Comparator<Pair>() {
			
			public int compare(Pair p1, Pair p2) {
				return Integer.compare(p1.dist, p2.dist);
			}
		});
		q.offer(new Pair(0,0));
		distMap.put(0, 0);
		for(int i=1; i<maxVertices;i++) {
			distMap.put(i, Integer.MAX_VALUE);
			q.offer(new Pair(i,Integer.MAX_VALUE));
		}
		while(!q.isEmpty()) {
			Pair minPair = q.poll();
			int minVertex = minPair.vertex;
			System.out.println(parentMap.get(minVertex)+"--"+distMap.get(minVertex)+"-->"+minVertex);
			for(int i=0;i<adjacencyMatrix[minVertex].length;i++) {
				if(adjacencyMatrix[minVertex][i]>0 && distMap.containsKey(i) && distMap.get(i)>adjacencyMatrix[minVertex][i]) {
					q.remove(new Pair(i,distMap.get(i)));
					q.offer(new Pair(i,adjacencyMatrix[minVertex][i]));
					distMap.put(i, adjacencyMatrix[minVertex][i]);
					parentMap.put(i, minVertex);
				}
			}
			distMap.remove(minVertex);
		}
	}

	private static void addEdge(int source, int destination, int weight) {
		adjacencyMatrix[source][destination]=weight;
		adjacencyMatrix[destination][source]=weight;
	}
	
	public static class Pair{
		int vertex;
		int dist;
		
		public Pair(int vertex, int dist) {
			this.vertex=vertex;
			this.dist=dist;
		}
		
		public boolean equals(Object o) {
			if(o instanceof Pair) {
				Pair p = (Pair)o;
				return p.vertex==this.vertex && p.dist==this.dist;
			}
			return false;
		}
	}

}
