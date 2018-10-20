package epi.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author vcpaks
 * 14.6 Find the closest entries in three sorted arrays
 */
public class ComputeClosestEntries {

	public static void main(String[] args) {
		Integer[] arr1 = {5,10,15};
		Integer[] arr2 = {3,6,9,12,15};
		Integer[] arr3 = {8,16,24};
		List<Integer> list1 = Arrays.asList(arr1);
		List<Integer> list2 = Arrays.asList(arr2);
		List<Integer> list3 = Arrays.asList(arr3);
		List<List<Integer>>  input = new ArrayList<>();
		input.add(list1);
		input.add(list2);
		input.add(list3);
		List<Integer> result = findClosest(input);
		System.out.println(result);
	}
	
	public static class Data implements Comparable<Data>{

		int data;
		int arrIndx;
		
		public Data(int data, int arrIndx) {
			this.data=data;
			this.arrIndx=arrIndx;
		}
		
		@Override
		public int compareTo(Data o) {
			return Integer.compare(data, o.data);
		}
		
	}
	
	private static List<Integer> findClosest(List<List<Integer>> input){
		int[] arrIdx = {0,0,0};
		List<Data> triple = new ArrayList<Data>();
		List<Data> minList = null;
		triple.add(new Data(input.get(0).get(0),0));
		triple.add(new Data(input.get(1).get(0),1));
		triple.add(new Data(input.get(2).get(0),2));
		int minDiff = Integer.MAX_VALUE;
		
		while(true) {
			Collections.sort(triple);
			Data min = triple.get(0);
			Data max = triple.get(2);
			System.out.println("Min:"+min.data+" max:"+max.data);
			int diff = max.data-min.data;
			if(diff<minDiff)
				minList = triple;
			int minArr = min.arrIndx;
			arrIdx[minArr]++;
			if(arrIdx[minArr]==input.get(minArr).size())
				break;
			triple.remove(min);
			triple.add(new Data(input.get(minArr).get(arrIdx[minArr]),minArr));
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for(Data elem:minList)
			result.add(elem.data);
		
		return result;
		
	}

}
