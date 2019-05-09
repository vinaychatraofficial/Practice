package ae;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static ArrayList<Integer> longestIncreasingSubsequence(int[] array) {
		//return longestIncreasingSubsequence1(array);
		return longestIncreasingSubsequence2(array);
	}

	private static ArrayList<Integer> longestIncreasingSubsequence2(int[] array){
		ArrayList<Integer> indices = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		int[] prev = new int[array.length];
		Arrays.fill(prev,-1);
		indices.add(0);
		prev[0]=-1;
		for(int i=1;i<array.length;i++){
			int index = binarySearch(indices,array[i],array);
			System.out.println("index for "+i+" :"+index);
			if(index==indices.size())
				indices.add(i);
			else{
				indices.set(index,i);
			}
			prev[i] = index>0? indices.get(index-1):-1;
		}
		int maxIndex = indices.get(indices.size()-1);
		while(maxIndex!=-1){
			list.add(0,array[maxIndex]);
			maxIndex = prev[maxIndex];
		}
		for(int elem:list)
			System.out.print(elem+" ");	
		return list;
	}

	private static int binarySearch(ArrayList<Integer> indices, int num,
			int[] array){
		int left=0;
		int right = indices.size()-1;
		while(left<=right){
			int mid = left+(right-left)/2;
			if(mid==0 && array[indices.get(mid)] >= num)
				return mid;
			else if(array[indices.get(mid)] >= num && array[indices.get(mid-1)] <num)
				return mid;
			if(array[indices.get(mid)]<num)
				left=mid+1;
			else
				right=mid-1;
		}

		return left;
	}

	private static ArrayList<Integer> longestIncreasingSubsequence1(int[] array){
		int[] lengths = new int[array.length];
		int[] prev = new int[array.length];
		Arrays.fill(lengths,1);
		Arrays.fill(prev,-1);
		ArrayList<Integer> list = new ArrayList<>();

		int maxIndex = 0;
		for(int i=1;i<array.length;i++){
			for(int j=0;j<i;j++){
				if(array[j]<array[i] && lengths[j]+1>=lengths[i]){
					lengths[i]=lengths[j]+1;
					prev[i]=j;
				}
			}
			if(lengths[i]>lengths[maxIndex])
				maxIndex=i;
		}

		while(maxIndex!=-1){
			list.add(0,array[maxIndex]);
			maxIndex = prev[maxIndex];
		}
		for(int elem:list)
			System.out.print(elem+" ");	
		return list;
	}
}
