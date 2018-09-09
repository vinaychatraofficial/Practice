package epi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author vcpaks
 * Find shortest path with minimum edges
 */
public class ShortestPathMinimumEdge {

	public static void main(String[] args) {
		List<Vertex> v = new ArrayList<>();
		Vertex zero = new Vertex(0);
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		zero.edges.put(one,2);
		zero.edges.put(three,2);
		one.edges.put(two,4);
		one.edges.put(three,5);
		two.edges.put(one,4);
		two.edges.put(three,6);
		two.edges.put(four,1);
		three.edges.put(one,5);
		three.edges.put(four,5);
		four.edges.put(two,1);
		four.edges.put(three,5);
		
		v.add(zero);
		v.add(one);
		v.add(two);
		v.add(three);
		v.add(four);
		
		DistanceWithEdge shortest = findShortestPath(v, zero, four);
		System.out.println(shortest.distance+":"+shortest.noOfEdges);
	}
	
	private static class Vertex{
		int label;
		Map<Vertex,Integer> edges = new HashMap<>();
		
		public Vertex(int label) {
			this.label = label;
		}
	}
	
	private static class DistanceWithEdge{
		int distance;
		int noOfEdges;
		public DistanceWithEdge(int distance, int noOfEdges) {
			this.distance=distance;
			this.noOfEdges=noOfEdges;
		}
		
	}
	
	private static DistanceWithEdge findShortestPath(List<Vertex> vertices, Vertex source, Vertex dest) {
		Map<Vertex, DistanceWithEdge> distMap = new HashMap<>();
		Map<Vertex, Vertex> parentMap = new HashMap<>();
		
		for(Vertex v:vertices) {
			distMap.put(v, new DistanceWithEdge(Integer.MAX_VALUE,Integer.MAX_VALUE));
		}
		
		distMap.put(source, new DistanceWithEdge(0,0));
		
		while(!distMap.isEmpty()) {
			Vertex min = getMinVertex(distMap);
			if(min==dest) {
				return distMap.get(min);
			}
			for(Vertex next:min.edges.keySet()) {
				int nextDist = distMap.get(min).distance + min.edges.get(next);
				int nextEdges = distMap.get(min).noOfEdges+1;
				if(distMap.get(next)!=null) {
					if(nextDist<distMap.get(next).distance || (nextDist==distMap.get(next).distance && nextEdges<distMap.get(next).noOfEdges)) {
						distMap.remove(next);
						DistanceWithEdge de = new DistanceWithEdge(nextDist, nextEdges);
						distMap.put(next, de);
						parentMap.put(next, min);
					}
				}
			}
			distMap.remove(min);
		}
		return null;
	}

	private static Vertex getMinVertex(Map<Vertex, DistanceWithEdge> distMap) {
		int minDist=Integer.MAX_VALUE; Vertex min = null; int minEdges=Integer.MAX_VALUE;
		for(Vertex v:distMap.keySet()) {
			DistanceWithEdge curr = distMap.get(v);
			if(curr.distance<minDist || (curr.distance==minDist && curr.noOfEdges<minEdges)) {
				minDist = curr.distance;
				minEdges = curr.noOfEdges;
				min=v;
			}
				
		}
		return min;
	}

}
