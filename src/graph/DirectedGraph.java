package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DirectedGraph {
	Vertex[] vertices;
	int[][] adjacencyMaxtrix;
	List<List<Integer>> adjacencyList;
	int maxVertices;
	int vertexCount;
	
	public DirectedGraph(int maxVertices) {
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
	}
	
	public void addVertex(String label) {
		vertices[vertexCount++] = new Vertex(label);
	}
	
	public void addEdge(int source, int destination) {
		adjacencyMaxtrix[source][destination]=1;
		List<Integer> sourceList = adjacencyList.get(source);
		sourceList.add(destination);
	}
	
	public void addEdge(int source, int destination, int weight) {
		adjacencyMaxtrix[source][destination]=weight;
		List<Integer> sourceList = adjacencyList.get(source);
		sourceList.add(destination);
	}
	
	public void displayVertex(int i) {
		System.out.println(vertices[i].label);
	}
	
	public static DirectedGraph initialize() {
		DirectedGraph g = new DirectedGraph(10);
		g.addVertex("7");
		g.addVertex("5");
		g.addVertex("3");
		g.addVertex("11");
		g.addVertex("8");
		g.addVertex("2");
		g.addVertex("9");
		g.addVertex("10");
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(0, 4);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 6);
		g.addEdge(3, 7);
		g.addEdge(2, 7);
		return g;
	}
	
	public static DirectedGraph initializeWeightedGraph() {
		DirectedGraph g = new DirectedGraph(10);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 4, 4);
		g.addEdge(2, 1, 2);
		g.addEdge(2, 3, 4);
		g.addEdge(3, 4, 4);
		return g;
	}
	
	public static DirectedGraph initializeWeightedCyclicGraph() {
		DirectedGraph g = new DirectedGraph(10);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 4, 4);
		g.addEdge(2, 1, 2);
		g.addEdge(2, 3, 4);
		g.addEdge(3, 4, 4);
		g.addEdge(4, 2, -10);
		return g;
	}

}

