package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		Graph g = Graph.initialize();
		//bfsSpan(g);
		System.out.println(bfsSearch(g, "B"));
	}
	
	public static void bfsSpan(Graph g) {
		System.out.println(g.vertices[0].label);
		q.add(0);
		g.vertices[0].isVisited=true;
		while(!q.isEmpty()) {
			int v = getAjacentUnvisitedVertex(g,q.peek());
			if(v==-1)
				q.remove();
			else {
				System.out.println(g.vertices[v].label);
				g.vertices[v].isVisited=true;
				q.add(v);
			}
		}
	}
	
	private static int bfsSearch(Graph g, String str) {
		String label = g.vertices[0].label;
		if(str.equals(label))
			return 0;
		g.vertices[0].isVisited=true;
		q.add(0);
		while(!q.isEmpty()) {
			int v = q.peek();
			int adj = getAjacentUnvisitedVertex(g, v);
			if(adj==-1) {
				q.remove(v);
				
			}else {
				if(g.vertices[adj].label.equals(str))
					return adj;
				g.vertices[adj].isVisited=true;
				q.add(adj);
			}
		}
		return -1;
	}

	private static int getAjacentUnvisitedVertex(Graph g, Integer v) {
		for(int i=0;i<g.vertexCount;i++) {
			if(g.adjacencyMaxtrix[v][i]==1 && g.vertices[i].isVisited==false)
				return i;
		}
		return -1;
	}

}
