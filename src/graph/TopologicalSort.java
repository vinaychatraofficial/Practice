package graph;

public class TopologicalSort {

	public static void main(String[] args) {
		DirectedGraph g = DirectedGraph.initialize();
		topologicalSort(g);
	}
	
	private static void topologicalSort(DirectedGraph g) {
		int[] indegree = computeInDegree(g);
		for(int i=0;i<indegree.length;i++)
		System.out.println(indegree[i]);
		for(int i=0;i<g.vertexCount;i++)
			System.out.println(g.vertices[i].label+":"+indegree[i]);
	}
	
	private static int[] computeInDegree(DirectedGraph g) {
		int[] indegree = new int[g.vertexCount];
		for(int i=0;i<g.vertexCount;i++) {
			for(int j=0;j<g.vertexCount;j++) {
				if(g.adjacencyMaxtrix[i][j]==1)
					indegree[j]=indegree[j]++;
			}
		}
		return indegree;
	}

}
