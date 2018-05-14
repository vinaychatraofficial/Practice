package graph;

import java.util.HashMap;
import java.util.Map;

class DisjointNode{
	int data;
	DisjointNode parent;
	int rank;
	
	public DisjointNode(int data) {
		this.data=data;
	}
}

public class DisjointSet {
	
	Map<Integer, DisjointNode> map;
	
	public DisjointSet() {
		map = new HashMap<>();
	}
	
	public void makeSet(int data) {
		DisjointNode node = new DisjointNode(data);
		node.parent = node;
		map.put(data, node);
	}
	
	public DisjointNode findSet(int data) {
		DisjointNode node = map.get(data);
		DisjointNode parent = node.parent;
		
		if(parent == node)
			return parent;
		
		node.parent = findSet(node.parent.data);
		return node.parent;
		
	}
	
	public void union(int data1, int data2) {
		DisjointNode parent1 = findSet(data1);
		DisjointNode parent2 = findSet(data2);
		
		if(parent1==parent2)
			return;
		
		if(parent1.rank<parent2.rank) {
			parent1.parent=parent2;
		}else if(parent2.rank<parent1.rank) {
			parent2.parent=parent1;
		}else {
			parent1.rank++;
			parent2.parent=parent1;
		}
		
	}

}
