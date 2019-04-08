package ae;

import java.util.Map;
import java.util.HashMap;

class Program {
  public static int[] largestRange(int[] array) {
		int n = array.length;
		int[] res = new int[2];
		Map<Integer,Boolean> nodes = new HashMap<>();
		for(int i=0;i<n;i++){
			nodes.put(array[i],false);
		}
		
		int maxRange = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			int cur = array[i];
			if(nodes.get(cur)==false){
				Integer left = cur;
				Integer right = cur;
				nodes.put(cur,true);
				while(nodes.containsKey(left-1) || nodes.containsKey(right+1)){
					if(nodes.containsKey(left-1)){
						left--;
						nodes.put(left,true);
					}
					if(nodes.containsKey(right+1)){
						right++;
						nodes.put(right,true);
					}
				}
				if(right-left>maxRange){
					maxRange=right-left;
					res[0]=left;
					res[1]=right;
				}
			}
		}
		return res;
  }
}

