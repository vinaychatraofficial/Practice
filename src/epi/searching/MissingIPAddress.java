package epi.searching;

import java.util.BitSet;
import java.util.List;

/**
 * @author vcprabha
 * 11.9 Find the missing IP Address
 */
public class MissingIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static int findMissingIp(List<Integer> list){
		java.util.Iterator<Integer> it = list.iterator();
		int BUCKETS = 1<<16;
		int[] arr = new int[BUCKETS];
		
		while(it.hasNext()){
			Integer num = it.next();
			arr[num>>>16]++;
		}
		
		for(int i=0;i<BUCKETS;i++){
			if(arr[i]<BUCKETS){
				BitSet set = new BitSet(BUCKETS);
				java.util.Iterator<Integer> it1 = list.iterator();
				while(it1.hasNext()){
					Integer x = it1.next();
					if(i==x>>>16){
						//set lower bits
						set.set((BUCKETS-1)&x);
					}
				}
				
				for(int j=0;j<BUCKETS;j++){
					if(!set.get(j)){
						return i<<16|j;
					}
				}
			}
		}
		return -1;
	}

}
