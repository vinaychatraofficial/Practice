package epi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author vcpaks
 * 13.3 Remove first name duplicates
 */
public class RemoveFirstNameDuplicates {

	public static void main(String[] args) {
		Name n1 = new Name("Ian","Botham");
		Name n2 = new Name("David","Gower");
		Name n3 = new Name("Ian","Bell");
		Name n4 = new Name("Ian","Chappell");
		List<Name> list = new ArrayList<>();
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		removeDups(list);
		for(Name name:list)
			System.out.println(name.firstName+":"+name.lastName);
	}
	
	public static class Name implements Comparable<Name>{
		String firstName;
		String lastName;
		
		public Name(String firstName,String lastName){
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@Override
		public int compareTo(Name name) {
			return this.firstName.compareTo(name.firstName);
		}
		
	}
	
	private static void removeDups(List<Name> input) {
		Collections.sort(input);
		int index=0;
		Name prev = null;
		for(int i=0;i<input.size();i++) {
			if(prev==null || (prev!=null && !input.get(i).firstName.equals(prev.firstName))) {
				input.set(index, input.get(i));
				index++;
			}
			prev = input.get(i);
		}
		int n = input.size();
		
		input.subList(index, n).clear();
		
	}

}
