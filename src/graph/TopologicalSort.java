package graph;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	
	static Queue<Integer> q = new LinkedList<>();
	static int[] topologicalOrder;

	public static void main(String[] args) {
		DirectedGraph g = DirectedGraph.initialize();
		topologicalSort(g);
	}
	
	private static void topologicalSort(DirectedGraph g) {
		int[] indegree = computeInDegree(g);
		topologicalOrder = new int[g.vertexCount];
		int counter = 0;
		/*for(int i=0;i<g.vertexCount;i++)
			System.out.println(g.vertices[i].label+":"+indegree[i]);*/
		
		for(int i=0;i<g.vertexCount;i++)
			if(indegree[i]==0)
				q.add(i);
		
		while(!q.isEmpty()) {
			int v = q.remove();
			topologicalOrder[v]=++counter;
			System.out.println(g.vertices[v].label);
			for(int i=0;i<g.vertexCount;i++) {
				if(g.adjacencyMaxtrix[v][i]==1) {
					indegree[i]--;
					if(indegree[i]==0)
						q.add(i);
				}
					
			}
		}
		
		for(int i=0;i<g.vertexCount;i++) {
			System.out.println("topological order of "+g.vertices[i].label+":"+topologicalOrder[i]);
		}
		
		if(counter!=g.vertexCount)
			System.out.println("Graph has cycles");
		
	}
	
	

	private static int[] computeInDegree(DirectedGraph g) {
		int[] indegree = new int[g.vertexCount];
		for(int i=0;i<g.vertexCount;i++) {
			for(int j=0;j<g.vertexCount;j++) {
				if(g.adjacencyMaxtrix[i][j]==1) {
					indegree[j]++;
				}
			}
		}
		return indegree;
	}

}
