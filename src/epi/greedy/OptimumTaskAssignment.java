package epi.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author vcpaks
 * 17.1 Compute an optimum assignment of tasks
 */
public class OptimumTaskAssignment {

	public static void main(String[] args) {
		int[] tasks = {5,2,1,6,4,4};
		List<Integer> taskList = new ArrayList<>();
		taskList.add(5);
		taskList.add(2);
		taskList.add(1);
		taskList.add(6);
		taskList.add(4);
		taskList.add(4);
		System.out.println(computeOptimumAssignment(taskList));

	}
	
	private static List<String> computeOptimumAssignment(List<Integer> tasks){
		List<String> optimumTasks = new ArrayList<String>();
		
		Collections.sort(tasks);
		
		for(int i=0,j=tasks.size()-1;i<j;i++,j--) {
			System.out.println("adding"+tasks.get(i));
			optimumTasks.add(tasks.get(i)+":"+tasks.get(j));
		}
		
		return optimumTasks;
		
	}

}
