package graph;

import java.util.ArrayList;
import java.util.List;

class Vertex{
	String label;
	boolean isVisited;
	
	public Vertex(String label) {
		this.label=label;
		this.isVisited=false;
	}
}

class Edge{
	int source;
	int destination;
	int weight;
	
	public Edge(int source, int destination, int weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	
}

public class Graph {
	Vertex[] vertices;
	int[][] adjacencyMaxtrix;
	List<List<Integer>> adjacencyList;
	int maxVertices;
	int vertexCount;
	List<Edge> edges;
	
	public Graph(int maxVertices) {
		this.maxVertices=maxVertices;
		vertices = new Vertex[maxVertices];
		adjacencyMaxtrix = new int[maxVertices][maxVertices];
		for(int i=0;i<maxVertices;i++) {
			for(int j=0;j<maxVertices;j++) {
				adjacencyMaxtrix[i][j]=0;
			}
		}
		vertexCount=0;
		adjacencyList = new ArrayList<List<Integer>>();
		for(int i=0;i<maxVertices;i++)
			adjacencyList.add(new ArrayList<Integer>());
		edges = new ArrayList<>();
	}
	
	public void addVertex(String label) {
		vertices[vertexCount++] = new Vertex(label);
	}
	
	public void addEdge(int source, int destination) {
		adjacencyMaxtrix[source][destination]=1;
		adjacencyMaxtrix[destination][source]=1;
		List<Integer> sourceList = adjacencyList.get(source);
		sourceList.add(destination);
		List<Integer> destList = adjacencyList.get(destination);
		destList.add(source);
	}
	
	public void addEdge(int source, int destination, int weight) {
		adjacencyMaxtrix[source][destination]=weight;
		adjacencyMaxtrix[destination][source]=weight;
		List<Integer> sourceList = adjacencyList.get(source);
		sourceList.add(destination);
		List<Integer> destList = adjacencyList.get(destination);
		destList.add(source);
		Edge edge = new Edge(source, destination, weight);
		edges.add(edge);
	}
	
	public void displayVertex(int i) {
		System.out.println(vertices[i].label);
	}
	
	public static Graph initialize() {
		Graph g = new Graph(10);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		g.addVertex("H");
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(1, 7);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(4, 7);
		return g;
	}
	
	public static Graph initializeWeightedGraph() {
		Graph g = new Graph(10);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		g.addEdge(0, 2, 7);
		g.addEdge(0, 3, 5);
		g.addEdge(1, 4, 5);
		g.addEdge(2, 1, 8);
		g.addEdge(2, 4, 7);
		g.addEdge(2, 3, 9);
		g.addEdge(3, 4, 15);
		g.addEdge(3, 5,6);
		g.addEdge(4,5,8);
		g.addEdge(4, 6,9);
		g.addEdge(5, 6, 11);
		return g;
	}

}
