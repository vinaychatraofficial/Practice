package graph;



public class DirectedGraph {
	Vertex[] vertices;
	int[][] adjacencyMaxtrix;
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
	}
	
	public void addVertex(String label) {
		vertices[vertexCount++] = new Vertex(label);
	}
	
	public void addEdge(int source, int destination) {
		adjacencyMaxtrix[source][destination]=1;
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
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 6);
		g.addEdge(3, 7);
		g.addEdge(2, 7);
		return g;
	}

}

