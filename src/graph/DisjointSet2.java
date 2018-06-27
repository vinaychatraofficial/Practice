package graph;

import java.util.ArrayList;
import java.util.List;

class DisjointNode2{
	int data;
	int rank;
	DisjointNode2 parent;
	
	public DisjointNode2(int data){
		this.data = data;
		this.parent=this;
		this.rank=0;
	}
}
public class DisjointSet2 {
	
	List<DisjointNode2> nodes = new ArrayList<DisjointNode2>();
	
	public void makeSet(int data){
		nodes.add(data, new DisjointNode2(data));
	}
	
	public DisjointNode2 findSet(int data){
		DisjointNode2 node = nodes.get(data);
		DisjointNode2 parent = node.parent;
		
		if(node!=parent)
			node.parent = findSet(node.parent.data);
		return node.parent;
	}
	
	public void unionSet(int data1, int data2){
		DisjointNode2 parentNode1 = findSet(data1);
		DisjointNode2 parentNode2 = findSet(data2);
		
		if(parentNode1==parentNode2)
			return;
		
		if(parentNode1.rank<parentNode2.rank)
			parentNode1.parent=parentNode2;
		else if(parentNode1.rank>parentNode2.rank)
			parentNode2.parent=parentNode1;
		else{
			parentNode2.parent=parentNode1;
			parentNode1.rank++;
		}
			
	}

}
