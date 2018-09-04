package epi.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author vcpaks
 * 18.6 Making wired connections
 */
public class MakingWiredConnections {

	public static void main(String[] args) {
		List<Vertex> v = new ArrayList<>();
		Vertex zero = new Vertex(0);
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		zero.edges.add(one);
		one.edges.add(two);
		one.edges.add(three);
		two.edges.add(four);
		two.edges.add(four);
		two.edges.add(five);
		//four.edges.add(five);
		v.add(zero);
		v.add(one);
		v.add(two);
		v.add(three);
		v.add(four);
		v.add(five);
		System.out.println(markVertices(v));
		
	}
	
	public static class Vertex{
		int label;
		int color=-1;
		List<Vertex> edges = new ArrayList<>();
		
		public Vertex(int label) {
			this.label=label;
		}
	}
	
	private static boolean markVertices(List<Vertex> vertices) {
		for(Vertex v: vertices) {
			if(v.color==-1) {
				if(!markVertex(v))
					return false;
			}
		}
		return true;
	}

	private static boolean markVertex(Vertex v) {
		Queue<Vertex> q = new LinkedList<>();
		q.add(v);
		v.color=0;
		while(!q.isEmpty()) {
			Vertex curr = q.remove();
			for(Vertex next:curr.edges) {
				if(next.color==-1) {
					q.add(next);
					next.color = curr.color==0?1:0;
				}else if(next.color==curr.color) {
					return false;
				}
			}
		}
		return true;
	}

}
