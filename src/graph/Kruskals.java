package graph;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EdgeComparator implements Comparator<Edge>{

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

public class Kruskals {
	
	static List<Edge> result;

	public static void main(String[] args) {
		Graph g = Graph.initializeWeightedGraph();
		result = new ArrayList<>();
		findMST(g);
		for(Edge e:result)
			System.out.println(e.source+" "+e.destination+" "+e.weight);
	}
	
	private static void findMST(Graph g) {
		List<Edge> edges = g.edges;
		Collections.sort(edges, new EdgeComparator());
		DisjointSet set = new DisjointSet();
		
		for(int i=0;i<g.vertexCount;i++)
			set.makeSet(i);
		
		for(Edge e:edges) {
			DisjointNode sourceParent = set.findSet(e.source);
			DisjointNode destParent = set.findSet(e.destination);
			
			if(sourceParent==destParent)
				continue;
			
			set.union(e.source, e.destination);
			result.add(e);
		}
	}

}
