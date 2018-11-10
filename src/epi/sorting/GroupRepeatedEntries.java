package epi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author vcpaks
 * 13.8 Partitioning and sorting an array with repeated entries
 */
public class GroupRepeatedEntries {

	public static void main(String[] args) {
		List<Student> input = new ArrayList<>();
		input.add(new Student("Greg",14));
		input.add(new Student("John",12));
		input.add(new Student("Andy",11));
		input.add(new Student("Jim",13));
		input.add(new Student("Phil",12));
		input.add(new Student("Bob",13));
		input.add(new Student("Chip",13));
		input.add(new Student("Tim",14));
		
		groupEntries(input);
		for(Student s:input) {
			System.out.println(s.name+","+s.age);
		}
	}
	
	public static class Student{
		String name;
		int age;
		public Student(String name,int age) {
			this.name=name;
			this.age=age;
		}
	}
	
	private static void groupEntries(List<Student> input) {
		Map<Integer,Integer> countMap = new HashMap<>();
		for(Student s:input) {
			if(countMap.containsKey(s.age)) {
				int count = countMap.get(s.age);
				countMap.put(s.age, count+1);
			}else {
				countMap.put(s.age, 1);
			}
			
		}
		
		Map<Integer,Integer> offsetMap = new HashMap<>();
		int offset = 0;
		for(Integer age:countMap.keySet()) {
			offsetMap.put(age, offset);
			offset+=countMap.get(age);
		}
		
		while(!offsetMap.isEmpty()) {
			Integer age = offsetMap.keySet().iterator().next();
			//get the first unfilled index
			int index = offsetMap.get(age);
			
			//get student at that index and put it in correct position using offset map
			Student s = input.get(index);
			int newIndex = offsetMap.get(s.age);
			Collections.swap(input, index, newIndex);
			
			//increment the offset for that age
			offsetMap.put(s.age, newIndex+1);
			//decrement count for that age
			int count = countMap.get(s.age);
			count--;
			countMap.put(s.age, count);
			//if count is 0 remove that age from offset map
			if(count==0) {
				offsetMap.remove(s.age);
			}
		}
	}

}
