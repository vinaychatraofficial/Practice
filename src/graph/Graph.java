package graph;

class Vertex{
	String label;
	boolean isVisited;
	
	public Vertex(String label) {
		this.label=label;
		this.isVisited=false;
	}
}

public class Graph {
	Vertex[] vertices;
	int[][] adjacencyMaxtrix;
	int maxVertices;
	int vertexCount;
	
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
	}
	
	public void addVertex(String label) {
		vertices[vertexCount++] = new Vertex(label);
	}
	
	public void addEdge(int source, int destination) {
		adjacencyMaxtrix[source][destination]=1;
		adjacencyMaxtrix[destination][source]=1;
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

}
