package epi.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author vcpaks
 * 13.9 Team photo day-1
 */
public class TeamPhotoDay {

	public static void main(String[] args) {
		Integer[] arr1 = {10,6,8,2,4};
		Integer[] arr2 = {1,7,9,5,3};
		List<Integer> teamA = Arrays.asList(arr1);
		List<Integer> teamB = Arrays.asList(arr2);
		System.out.println(place(teamA,teamB));
	}
	
	private static boolean place(List<Integer> teamA, List<Integer> teamB) {
		Collections.sort(teamA);
		Collections.sort(teamB);
		
		if(teamA.get(0)<teamB.get(0)) {
			for(int i=0;i<teamA.size();i++) {
				if(teamA.get(i)>=teamB.get(i))
					return false;
			}
			return true;
		}else {
			for(int i=0;i<teamA.size();i++) {
				if(teamB.get(i)>=teamA.get(i))
					return false;
			}
		}
		return true;
	}

}
