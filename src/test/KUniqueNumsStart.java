package test;

import java.util.ArrayList;
import java.util.Arrays;

public class KUniqueNumsStart {

	public static void main(String[] args) {
		
		Integer[] arr = {1,2,2,2,2,3,5,7};
		ArrayList<Integer> list = (ArrayList<Integer>) new ArrayList(Arrays.asList(arr));
		printList(list);
		System.out.println();
		moveUnique(list);
		printList(list);
	}

	private static void moveUnique(ArrayList<Integer> list) {
		int prev = 0;
		boolean present = false;
		int i=1,count=0;
		while(count<=list.size()) {
			//System.out.println("Processing "+i);
			if(list.get(i)==list.get(prev)) {
				//System.out.println("adding 1--"+i);
				list.add(list.get(i));
				list.remove(i);
				present = true;
				//printList(list);
			}else {
				if(present) {
					//System.out.println("adding 2--"+prev);
					list.add(list.get(prev));
					list.remove(prev);
					//printList(list);
					
				}else {
					prev=i;
					i++;
				}
				present = false;
			}
			count++;
			//System.out.println("count:"+count);
		}
	}
	
	private static void printList(ArrayList<Integer> list ) {
		for(Integer a:list)
			System.out.print(a+" ");
		System.out.println();
	}

}
