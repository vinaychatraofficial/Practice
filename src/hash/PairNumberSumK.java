package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairNumberSumK {

	public static void main(String[] args) {
		int[] arr = {1,2,1,3,4,5,6};
		int k = 7;
		Set<Integer> result = sumtoK(arr,k);
		if(result==null||result.isEmpty())
			System.out.println("Pairs dont exist");
		else{
			for(Integer elem:result){
				System.out.println(elem+":"+(k-elem));
			}
		}
	}

	private static Set<Integer> sumtoK(int[] arr, int k) {
		java.util.Hashtable<Integer, Integer> ht = new java.util.Hashtable<>();
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length;i++){
			if(ht.get(k-arr[i])!=null)
				set.add(arr[i]);
			else
				ht.put(arr[i], arr[i]);
		}
		return set;
	}

}
