package hash;

import java.util.LinkedList;

/**
 * prob 9 check loop in a singly linked list
 * @author vcprabha
 *
 */
public class LoopLinkedList {

	public static void main(String[] args) {
		java.util.LinkedList list = new java.util.LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		System.out.println(checkLoop(list));
	}
	
	private static boolean checkLoop(LinkedList<Integer> list){
		java.util.Hashtable<Integer, Integer> ht = new java.util.Hashtable<>();
		for(Integer elem:list){
			if(ht.get(elem)!=null){
				return false;
			}else{
				ht.put(elem, elem);
			}
		}
		return true;
	}

}
