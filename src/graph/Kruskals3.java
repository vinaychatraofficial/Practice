package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskals3 {

	static int[][] adjacencyMatrix ;
	static ArrayList<Edge> edges = new ArrayList<>();
	static Map<Integer,Node> map = new HashMap<>();
	
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
		kruskals(maxVertices);
	}
	
	private static void kruskals(int maxVertices) {
		Collections.sort(edges);
		makeSet(maxVertices);
		int count=0;
		for(Edge e:edges) {
			Node source = map.get(e.source);
			Node dest = map.get(e.dest);
			Node sRoot = findSet(source);
			Node dRoot = findSet(dest);
			
			if(sRoot==dRoot) {
				continue;
			}else {
				union(source,dest);
				System.out.println(e.source+"--"+e.weight+"-->"+e.dest);
				count++;
				if(count==maxVertices-1)
					break;
			}
		}
	}

	private static void union(Node source, Node dest) {
		Node sRoot = findSet(source);
		Node dRoot = findSet(dest);
		
		if(sRoot==dRoot)
			return;
		
		int sRank = source.rank;
		int dRank = dest.rank;
		if(sRank>=dRank) {
			sRank = (sRank==dRank) ? sRank+1:sRank;
			dRoot.parent = sRoot;
		}else {
			sRoot.parent = dRoot;
		}
	}

	private static Node findSet(Node node) {
		Node parent = node.parent;
		if(node==parent)
			return parent;
		node.parent = findSet(parent);
		return node.parent;
	}

	private static void makeSet(int maxVertices) {
		for(int i=0;i<maxVertices;i++) {
			Node node = new Node(i, 0);
			node.parent=node;
			map.put(i, node);
		}
	}

	private static void addEdge(int source, int destination, int weight) {
		adjacencyMatrix[source][destination]=weight;
		adjacencyMatrix[destination][source]=weight;
		edges.add(new Edge(source,destination,weight));
	}
	
	public static class Node{
		int data;
		Node parent;
		int rank;
		
		public Node(int data, int rank) {
			super();
			this.data = data;
			this.rank = rank;
		}
		
		
	}
	
	public static class Edge implements Comparable<Edge>{
		int source;
		int dest;
		int weight;
		
		public Edge(int source, int dest, int weight) {
			super();
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}

}
