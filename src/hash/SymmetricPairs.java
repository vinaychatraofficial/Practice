package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Problem 8 - Report all symmetric pairs
 * @author vcpaks
 *
 */
public class SymmetricPairs {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>(); 
		
		List list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list.add(list1);
		
		List list2 = new ArrayList<>();
		list2.add(2);
		list2.add(6);
		list.add(list2);
		
		List list3 = new ArrayList<>();
		list3.add(3);
		list3.add(1);
		list.add(list3);
		
		List list4 = new ArrayList<>();
		list4.add(7);
		list4.add(4);
		list.add(list4);
		
		List list5 = new ArrayList<>();
		list5.add(6);
		list5.add(2);
		list.add(list5);
		
		Map<Integer,Integer> finalMap = getSymmetricPairs(list);
		Iterator<Integer> it = finalMap.keySet().iterator();
		System.out.println("Symmetric pairs are");
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key+":"+finalMap.get(key));
		}
	}
	
	public static Map<Integer,Integer> getSymmetricPairs(List<List<Integer>> list) {
		HashMap<Integer,Integer> finalMap = new HashMap<>();
		Hashtable<Integer,Integer> ht = new Hashtable();
		for(List<Integer> innerList:list) {
			int key = innerList.get(0);
			int value = innerList.get(1);
			
			if(ht.get(value)!=null && ht.get(value)==key) {
				finalMap.put(key, value);
			}else {
				ht.put(key, value);
			}
				
			
		}
		
		return finalMap;
	}

}
