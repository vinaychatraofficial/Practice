package epi.dp;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import hash.HashTable;

/**
 * @author vcpaks
 * 16.5 Search for a sequence in a 2d array
 */
public class Sequence2DArr2 {
	
	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{3,4,5},{5,6,7}};
		int[] pattern = {1,3,4,6,7};
		Map<String,Boolean> dpMap = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==pattern[pattern.length-1]) {
					
					if(findSeqInArr(arr, pattern, i-1, j, pattern.length-2,dpMap) ||
							findSeqInArr(arr, pattern, i+1, j, pattern.length-2,dpMap) ||
							findSeqInArr(arr, pattern, i, j-1, pattern.length-2,dpMap) || 
							findSeqInArr(arr, pattern, i, j+1, pattern.length-2,dpMap)) {
						System.out.println(i+","+j);
						System.out.println("found");
						System.exit(1);
					}
					
				}
			}
		}
		System.out.println("not found");
	}
	
	public static boolean findSeqInArr(int[][] arr, int[] pattern, int i, int j, int offset,Map<String,Boolean> dpMap) {
		if(offset<0)
			return true;
		String key = i+""+j+""+offset;
		//System.out.println("key:"+key);
		if(dpMap.containsKey(key)) {
			return dpMap.get(key);
		}
		if(i<0 || i==arr.length || j<0 || j==arr[i].length)
			return false;
		if(arr[i][j]!=pattern[offset]) {
			dpMap.put(key, false);
			return false;
		}
		
		
		
		if(findSeqInArr(arr, pattern, i-1, j, offset-1,dpMap) ||
				findSeqInArr(arr, pattern, i+1, j, offset-1,dpMap) ||
				findSeqInArr(arr, pattern, i, j-1, offset-1,dpMap) || 
				findSeqInArr(arr, pattern, i, j+1, offset-1,dpMap)) {
			System.out.println(i+","+j);
			dpMap.put(key, true);
			return true;
		}
		
		dpMap.put(key, false);
		return false;
	}

}
