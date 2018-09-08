package epi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShortestPathDijkstra {

	public static void main(String[] args) {

		List<Vertex> v = new ArrayList<>();
		Vertex zero = new Vertex(0);
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		zero.edges.put(one,6);
		zero.edges.put(two,8);
		zero.edges.put(five,5);
		one.edges.put(two,7);
		one.edges.put(four,3);
		one.edges.put(zero,6);
		two.edges.put(zero,8);
		two.edges.put(one,7);
		two.edges.put(three,4);
		three.edges.put(two,4);
		three.edges.put(four,1);
		three.edges.put(five,1);
		four.edges.put(one,3);
		four.edges.put(three,1);
		four.edges.put(five,1);
		five.edges.put(zero,5);
		five.edges.put(three,1);
		five.edges.put(four,1);
		
		v.add(zero);
		v.add(one);
		v.add(two);
		v.add(three);
		v.add(four);
		v.add(five);
		
		Map<Vertex,Integer> distMap = shortestPath(v, zero);
		for(Vertex vertex:v)
			if(distMap.get(vertex)!=null)
				System.out.println(vertex.label+"->"+distMap.get(vertex));
	
	}
	
	private static class Vertex{
		int label;
		Map<Vertex,Integer> edges = new HashMap<>();
		
		public Vertex(int label) {
			this.label=label;
		}
	}
	
	private static Map<Vertex, Integer> shortestPath(List<Vertex> vertices, Vertex source){
		Map<Vertex,Integer> vertexMap = new HashMap<>();
		Map<Vertex,Integer> distMap = new HashMap<>();
		
		for(Vertex v:vertices) {
			vertexMap.put(v, Integer.MAX_VALUE);
		}
		
		vertexMap.put(source, 0);
		
		while(!vertexMap.isEmpty()) {
			Vertex curr = getMinVertex(vertexMap);
			distMap.put(curr, vertexMap.get(curr));
			for(Vertex next:curr.edges.keySet()) {
				if(vertexMap.containsKey(next)) {
					int dist = vertexMap.get(curr) + curr.edges.get(next);
					if(vertexMap.get(next)>dist) {
						vertexMap.put(next, dist);
					}
				}
			}
			vertexMap.remove(curr);
		}
		return distMap;
	}

	private static Vertex getMinVertex(Map<Vertex, Integer> vertexMap) {
		Vertex min = null;
		int minDist = Integer.MAX_VALUE;
		for(Vertex v:vertexMap.keySet()) {
			if(vertexMap.get(v)<minDist) {
				minDist = vertexMap.get(v);
				min=v;
			}
		}
		return min;
	}

}
