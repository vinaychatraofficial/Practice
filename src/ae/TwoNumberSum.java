package ae;

import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {
	public static int[] twoNumberSum(int[] array, int targetSum) {
	    int[] res=new int[0];
			Set<Integer> set = new HashSet<Integer>();
			for(int i=0;i<array.length;i++)
				set.add(array[i]);
			for(int i=0;i<array.length;i++){
				int other = targetSum-array[i];
				if(set.contains(other)){
					res = new int[2];
					res[0]=array[i]<=other?array[i]:other;
					res[1]=array[i]>other?array[i]:other;
				}
					 
			}
			return res;
	  }
}
