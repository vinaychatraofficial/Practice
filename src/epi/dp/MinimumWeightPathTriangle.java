package epi.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author vcpaks
 * 16.8 Find the minimum weight path in a triangle
 */
public class MinimumWeightPathTriangle {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList();
		List<Integer> firstRow = new ArrayList<>();
		List<Integer> secondRow = new ArrayList<>();
		List<Integer> thirdRow = new ArrayList<>();
		List<Integer> fourthRow = new ArrayList<>();
		List<Integer> fifthRow = new ArrayList<>();
		firstRow.add(2);
		triangle.add(firstRow);
		secondRow.add(4);
		secondRow.add(4);
		triangle.add(secondRow);
		thirdRow.add(8);
		thirdRow.add(5);
		thirdRow.add(6);
		triangle.add(thirdRow);
		fourthRow.add(4);
		fourthRow.add(2);
		fourthRow.add(6);
		fourthRow.add(2);
		triangle.add(fourthRow);
		fifthRow.add(1);
		fifthRow.add(5);
		fifthRow.add(2);
		fifthRow.add(3);
		fifthRow.add(4);
		triangle.add(fifthRow);
		System.out.println(minWeightTriangle(triangle));
	}
	
	private static int minWeightTriangle(List<List<Integer>> triangle) {
		List<Integer> currRow;
		List<Integer> prevRow;
		
		prevRow = triangle.get(0);
		for(int i=1;i<triangle.size();i++) {
			currRow = triangle.get(i);
			currRow.set(0, prevRow.get(0)+currRow.get(0));
			currRow.set(currRow.size()-1, prevRow.get(prevRow.size()-1)+currRow.get(currRow.size()-1));
			for(int j=1;j<currRow.size()-1;j++) {
				currRow.set(j, currRow.get(j)+Math.min(prevRow.get(j-1), prevRow.get(j)));
			}
			prevRow=currRow;
		}
		return Collections.min(prevRow);
	}

}
