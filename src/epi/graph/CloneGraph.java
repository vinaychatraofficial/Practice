package epi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author vcprabha
 * 18.5 Clone a graph
 */
public class CloneGraph {

	public static void main(String[] args) {
		Vertex zero = new Vertex(0);
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		zero.edges.add(one);
		Vertex three = new Vertex(3);
		one.edges.add(two);
		one.edges.add(three);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		two.edges.add(four);
		two.edges.add(five);
		five.edges.add(one);
		printGraph(zero);
		System.out.println("Cloning graph");
		Vertex newVertex = cloneGraph(zero);
		printGraph(newVertex);
	}
	
	public static class Vertex{
		Integer label;
		List<Vertex> edges;
		
		public Vertex(Integer label){
			this.label = label;
			edges = new ArrayList<Vertex>();
		}
	}
	
	public static Vertex cloneGraph(Vertex g){
		Map<Vertex,Vertex> vertexMap = new HashMap<>();
		Vertex newVertex = new Vertex(g.label);
		Queue<Vertex> q = new LinkedList<>();
		q.add(g);
		vertexMap.put(g, newVertex);

		while(!q.isEmpty()){
			Vertex curr = q.remove();
			for(Vertex next:curr.edges){
				if(!vertexMap.containsKey(next)){
					Vertex nextVertex = new Vertex(next.label);
					q.add(next);
					vertexMap.put(next, nextVertex);
				}
				vertexMap.get(curr).edges.add(vertexMap.get(next));
			}

		}
		return vertexMap.get(g);
	}
	
	private static void printGraph(Vertex g){
		Queue<Vertex> q = new LinkedList<>();
		List<Vertex> visited = new ArrayList<>();
		q.add(g);
		visited.add(g);
		
		while(!q.isEmpty()){
			Vertex curr = q.remove();
			System.out.println("Children of "+curr.label+":");
			for(Vertex next:curr.edges){
				if(!visited.contains(next)){
					q.add(next);
					visited.add(next);
				}
				System.out.println(next.label);
			}
		}
	}

}
