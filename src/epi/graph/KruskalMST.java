package epi.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0,1,6));
		edges.add(new Edge(0,2,8));
		edges.add(new Edge(0,5,5));
		edges.add(new Edge(1,2,7));
		edges.add(new Edge(1,4,3));
		edges.add(new Edge(1,0,6));
		edges.add(new Edge(2,0,8));
		edges.add(new Edge(2,1,7));
		edges.add(new Edge(2,3,4));
		edges.add(new Edge(3,2,4));
		edges.add(new Edge(3,4,1));
		edges.add(new Edge(3,5,1));
		edges.add(new Edge(4,1,3));
		edges.add(new Edge(4,3,1));
		edges.add(new Edge(4,5,1));
		edges.add(new Edge(5,0,5));
		edges.add(new Edge(5,3,1));
		edges.add(new Edge(5,4,1));
		List<Integer> vertices = new ArrayList<>();
		vertices.add(0);
		vertices.add(1);
		vertices.add(2);
		vertices.add(3);
		vertices.add(4);
		vertices.add(5);
		List<Edge> result = kruskal(edges, vertices);
		for(Edge edge:result) {
			System.out.println(edge.src+"->"+edge.dest);
		}
		
	}
	
	private static class Edge{
		int src;
		int dest;
		int weight;
		
		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		
	}
	
	private static class Subset{
		int rank;
		int parent;
	}
	
	private static class EdgeComparator implements Comparator<Edge>{

		@Override
		public int compare(Edge e1, Edge e2) {
			return Integer.compare(e1.weight, e2.weight);
		}
		
	}
	
	private static List<Edge> kruskal(List<Edge> edges, List<Integer> vertices) {
		Collections.sort(edges, new EdgeComparator());
		Subset[] s = new Subset[vertices.size()];
		List<Edge> result = new ArrayList<>();
		for(int i=0;i<vertices.size();i++) {
			makeSet(s, i);
		}
		
		int count=0;
		
		for(Edge e:edges) {
			int xroot = find(s, e.src);
			int yroot = find(s, e.dest);
			
			if(count==vertices.size()-1)
				break;
			
			if(xroot!=yroot) {
				count++;
				result.add(e);
				union(e.src,e.dest,s);
			}
		}
		
		return result;
	}
	
	private static void union(int src, int dest, Subset[] s) {
		int xroot = find(s,src);
		int yroot = find(s,dest);
		
		if(s[xroot].rank!=s[yroot].rank) {
			if(s[xroot].rank>s[yroot].rank) {
				s[yroot].parent=xroot;
			}else {
				s[xroot].parent=yroot;
			}
		}else {
			s[yroot].parent=xroot;
			s[xroot].rank++;
		}
	}

	private static int find(Subset[] s, int src) {
		if(s[src].parent!=src)
			s[src].parent = find(s,s[src].parent);
		return s[src].parent;
	}

	private static void makeSet(Subset s[], int i) {
		s[i] = new Subset();
		s[i].parent = i;
		s[i].rank = 0;
	}

}
