package epi.dp;

import java.util.Hashtable;

import hash.HashTable;

/**
 * @author vcpaks
 * 16.5 Search for a sequence in a 2d array
 */
public class Sequence2DArr {
	
	private static Hashtable<String, Integer> ht = new Hashtable<String,Integer>();

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{3,4,5},{5,6,7}};
		int[] pattern = {1,3,4,6,7};
		System.out.println(findSequenceInArr(arr, pattern));
		System.out.println(findSequenceInArrIt(arr, pattern));
	}
	
	private static boolean findSequenceInArr(int[][] arr, int[] pattern) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(checkSequenceInArr(i,j,arr,pattern,0))
					return true;
			}
		}
		return false;
	}

	private static boolean checkSequenceInArr(int i, int j, int[][] arr, int[] pattern, int sequence) {
		if(sequence==pattern.length)
			return true;
		
		if(i<0 || i>=arr.length || j<0 || j>=arr[i].length || arr[i][j]!=pattern[sequence] || ht.contains(i+":"+j+":"+sequence)) {
			return false;
		}
		
		if(checkSequenceInArr(i-1, j, arr, pattern, sequence+1) || checkSequenceInArr(i+1, j, arr, pattern, sequence+1)||
				checkSequenceInArr(i, j-1, arr, pattern, sequence+1) || checkSequenceInArr(i, j+1, arr, pattern, sequence+1))
			return true;
		
		ht.put(i+":"+j+":"+sequence, 1);
		return false;
		
	}
	
	private static boolean findSequenceInArrIt(int[][] arr, int[] pattern) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(checkSequenceInArrIt(arr,pattern,i,j))
					return true;
			}
		}
		return false;
	}

	private static boolean checkSequenceInArrIt(int[][] arr, int[] pattern, int i, int j) {
		int count=1;
		while(count<pattern.length) {
			if(ht.contains(i+":"+j+":"+count))
				return false;
			if(i>0 && arr[i-1][j]==pattern[count]) {
				count++;
				i=i-1;
			}else if(i+1<arr.length && arr[i+1][j]==pattern[count]) {
				count++;
				i=i+1;
			}else if(j>0 && arr[i][j-1]==pattern[count]) {
				count++;
				j=j-1;
			}else if(j+1<arr[i].length && arr[i][j+1]==pattern[count]) {
				count++;
				j=j+1;
			}else {
				ht.put(i+":"+j+":"+count, 1);
				return false;
			}
		}
		return true;
	}

}
