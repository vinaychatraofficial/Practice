package epi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import epi.graph.MakingWiredConnections.Vertex;

public class PrimsMST {

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
		
		Map<Vertex,Vertex> parentMap = performMst(v);
		for(Vertex vertex:v)
			if(parentMap.get(vertex)!=null)
				System.out.println(vertex.label+"->"+parentMap.get(vertex).label);
	}
	
	private static class Vertex{
		int label;
		Map<Vertex,Integer> edges = new HashMap<>();
		
		public Vertex(int label){
			this.label=label;
		}
	}
	
	private static Map<Vertex,Vertex> performMst(List<Vertex> vertices){
		Vertex source = vertices.get(0);
		Map<Vertex,Integer> distMap = new HashMap<>();
		List<Vertex> mstList = new ArrayList<PrimsMST.Vertex>();
		Map<Vertex,Vertex> parentMap = new HashMap<>();
		
		for(Vertex v:vertices){
			distMap.put(v, Integer.MAX_VALUE);
		}
		distMap.put(source, 0);
		
		while(!distMap.isEmpty()){
			Vertex minVertex = getMinVertex(distMap);
			mstList.add(minVertex);
			for(Vertex next:minVertex.edges.keySet()){
				if(distMap.containsKey(next)){
					int nextDist = minVertex.edges.get(next);
					if(distMap.get(next)>nextDist){
						distMap.put(next, nextDist);
						parentMap.put(next, minVertex);
					}
				}
			}
			distMap.remove(minVertex);
		}
		return parentMap;
	}

	private static Vertex getMinVertex(Map<Vertex, Integer> distMap) {
		int minDist = Integer.MAX_VALUE;
		Vertex minVertex = null;
		for(Vertex v:distMap.keySet()){
			if(distMap.get(v)<minDist){
				minDist = distMap.get(v);
				minVertex = v;
			}
		}
		return minVertex;
	}

}
