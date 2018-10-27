package epi.bst;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author vcpaks
 * 14.11 Add credits
 */
public class AddCredits {
	
	private static Map<String,Integer> clientCredit = new HashMap<>();
	private static NavigableMap<Integer,Set<String>> treeMap = new TreeMap<>();
	private static Integer offset = 0;

	public static void main(String[] args) {
		add("A",1);
		add("B",2);
		add("C",3);
		System.out.println(lookup("B"));
		System.out.println(max());
		add("D",3);
		System.out.println(max());
		remove("C");
		System.out.println(max());
		addAll(5);
		System.out.println(lookup("B"));
		add("E",6);
		System.out.println(lookup("E"));
		System.out.println(lookup("A"));
	}
	
	private static void add(String clientId, Integer credit) {
		remove(clientId);
		clientCredit.put(clientId, credit - offset);
		Set<String> clients = treeMap.get(credit - offset);
		if(clients==null) {
			clients = new HashSet<>();
			treeMap.put(credit - offset, clients);
		}
		clients.add(clientId);
	}

	private static void remove(String clientId) {
		if(clientCredit.get(clientId)!=null) {
			Integer credit = clientCredit.get(clientId);
			clientCredit.remove(clientId);
			Set<String> clients = treeMap.get(credit);
			clients.remove(clientId);
			if(clients.isEmpty())
				treeMap.remove(credit);
		}
	}
	
	private static Integer lookup(String clientId) {
		if(clientCredit.get(clientId)!=null)
			return clientCredit.get(clientId)+offset;
		return -1;
	}
	
	private static void addAll(int increment) {
		offset+=increment;
	}
	
	private static String max() {
		if(!treeMap.isEmpty()) {
			Set<String> clients = treeMap.lastEntry().getValue();
			return clients.iterator().next();
		}
		return "";
	}

}
