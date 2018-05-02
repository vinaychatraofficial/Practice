package graph;

import java.util.Stack;

public class DFS {
	
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) {
		Graph g = Graph.initialize();
		//dfsSpan(g);
		//dfsSpanRec(g, 0);
		System.out.println(dfsSearch(g, "C"));
	}
	
	private static void dfsSpan(Graph g) {
		System.out.println(g.vertices[0].label);
		s.push(0);
		g.vertices[0].isVisited=true;
		while(!s.isEmpty()) {
			int v = getAjacentUnvisitedVertex(g,s.peek());
			if(v==-1)
				s.pop();
			else {
				System.out.println(g.vertices[v].label);
				g.vertices[v].isVisited=true;
				s.push(v);
			}
		}
	}
	
	private static void dfsSpanRec(Graph g, Integer v){
		System.out.println(g.vertices[v].label);
		g.vertices[v].isVisited=true;
		while(true) {
			int adj = getAjacentUnvisitedVertex(g, v);
			if(adj==-1)
				break;
			dfsSpanRec(g, adj);
		}
	}
	
	private static int dfsSearch(Graph g, String str) {
		if(g.vertices[0].label.equals(str))
			return 0;
		g.vertices[0].isVisited=true;
		s.push(0);
		while(!s.isEmpty()) {
			int adj = getAjacentUnvisitedVertex(g, s.peek());
			if(adj==-1)
				s.pop();
			if(g.vertices[adj].label.equals(str))
				return adj;
			s.push(adj);
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
