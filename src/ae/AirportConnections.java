package ae;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Collections;

public class AirportConnections {

	public static int airportConnections(
			ArrayList<String> airports,
			ArrayList<ArrayList<String>> routes,
			String startingAirport
			) {
		Map<String,Node> nodeMap = createAdjList(airports,routes);
		markReachableConnections(startingAirport,nodeMap);
		List<Node> unvisitedNodes = getUnvisitedNodes(nodeMap);
		findReachableConnections(unvisitedNodes);
		int connections = findMinConnections(unvisitedNodes);
		return connections;
	}

	//O(a log(a) + (a+r)) time | O(1) space
	private static int findMinConnections(List<Node> unvisitedNodes){
		Collections.sort(unvisitedNodes, new Comparator<Node>(){
			public int compare(Node n1, Node n2){
				return Integer.compare(n2.reachableConnections.size(),n1.reachableConnections.size());
			}
		});

		int minConnections = 0;
		for(Node node:unvisitedNodes){
			if(node.visited)
				continue;
			minConnections++;
			for(Node reachableConnection:node.reachableConnections){
				reachableConnection.visited=true;
			}
		}
		return minConnections;
	}

	//O(a*(a+r)) time | O(a) space
	private static void findReachableConnections(List<Node> unvisitedNodes){
		for(Node parent:unvisitedNodes){
			Set<Node> visited = new HashSet<>();
			depthFirstReachableConnections(parent,parent,visited);
		}
	}

	//O(a+r) time|O(a) space
	private static void depthFirstReachableConnections(Node parent, Node cur,
			Set<Node> visited){
		if(visited.contains(cur))
			return;
		if(cur.visited)
			return;

		visited.add(cur);
		if(parent!=cur)
			parent.reachableConnections.add(cur);
		for(Node connection:cur.connections)
			depthFirstReachableConnections(parent,connection,visited);
	}

	//O(a) time | O(a) space
	private static List<Node> getUnvisitedNodes(Map<String,Node> nodeMap){
		List<Node> unvisited = new ArrayList<>();
		for(Map.Entry<String,Node> entry:nodeMap.entrySet()){
			Node node = entry.getValue();
			if(node.visited)
				continue;
			unvisited.add(node);
		}
		return unvisited;
	}

	//O(a+r) | O(a) space
	private static void markReachableConnections(String startingAirport,
			Map<String,Node> nodeMap){
		depthFirstMarkConnections(nodeMap.get(startingAirport));
	}

	//O(a+r) | O(a) space
	private static void depthFirstMarkConnections(Node node){
		if(node.visited)
			return;

		node.visited=true;
		for(Node connection:node.connections){
			depthFirstMarkConnections(connection);
		}
	}

	//O(a+r) time | O(a + r) space
	private static Map<String,Node> createAdjList(ArrayList<String> airports,
			ArrayList<ArrayList<String>> routes){
		Map<String,Node> nodeMap= new HashMap<>();
		for(String airport:airports)
			nodeMap.put(airport,new Node(airport));

		for(ArrayList<String> route:routes){
			Node src = nodeMap.get(route.get(0));
			src.connections.add(nodeMap.get(route.get(1)));
		}
		return nodeMap;
	}

	static class Node{
		String name;
		List<Node> connections = new ArrayList<>();
		List<Node> reachableConnections = new ArrayList<>();
		boolean visited;

		public Node(String name){
			this.name =name;
		}
	}
}
