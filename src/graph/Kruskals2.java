package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EdgeWeightComparator implements Comparator<Edge>{

	@Override
	public int compare(Edge e1, Edge e2) {
		if(e1.weight<e2.weight)
			return -1;
		else if(e1.weight>e2.weight)
			return 1;
		else
			return 0;
	}
	
}

public class Kruskals2 {
	
	static List<Edge> result = new ArrayList<Edge>();

	public static void main(String[] args) {
		Graph g = Graph.initializeWeightedGraph();
		List<Edge> edges = g.edges;
		Collections.sort(edges, new EdgeWeightComparator());
		DisjointSet2 set = new DisjointSet2();
		
		for(int i=0;i<g.vertexCount;i++){
			set.makeSet(i);
		}
		
		for(Edge e:edges){
			DisjointNode2 parentSource = set.findSet(e.source);
			DisjointNode2 parentDest = set.findSet(e.destination);
			
			if(parentSource==parentDest)
				continue;
			
			set.unionSet(e.source, e.destination);
			result.add(e);
		}
		
		for(Edge e:result)
			System.out.println(e.source+" "+e.destination+" "+e.weight);
	}

}
