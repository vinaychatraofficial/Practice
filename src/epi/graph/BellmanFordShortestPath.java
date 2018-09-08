package epi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BellmanFordShortestPath {

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
		Map<Integer, Integer> distMap = null;
		try {
			distMap = bellmanFord(edges, vertices, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(distMap!=null) {
			for(Integer key:distMap.keySet()) {
				System.out.println("Distance of "+key+" is "+distMap.get(key));
			}
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
	
	private static Map<Integer,Integer> bellmanFord(List<Edge> edges, List<Integer> vertices, Integer source) throws Exception{
		Map<Integer,Integer> distMap = new HashMap<>();
		for(Integer v:vertices) {
			distMap.put(v, Integer.MAX_VALUE);
		}
		distMap.put(source, 0);
		
		for(int i=0;i<vertices.size()-1;i++)
			relaxEdges(edges,distMap);
		
		for(Edge e:edges) {
			int src = e.src;
			int dest = e.dest;
			if(distMap.get(dest)>(distMap.get(src)+e.weight))
				throw new Exception("Negative cycle found");
		}
		
		return distMap;
	}

	private static void relaxEdges(List<Edge> edges, Map<Integer, Integer> distMap) {
		for(Edge e:edges) {
			int src = e.src;
			int dest = e.dest;
			if(distMap.get(dest)>(distMap.get(src)+e.weight)) {
				distMap.put(dest, distMap.get(src)+e.weight);
			}
		}
	}

}
