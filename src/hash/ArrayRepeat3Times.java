package hash;

import java.util.Hashtable;

/**
 * prob 10 find elem in an array which is repeated 3 times
 * @author vcprabha
 *
 */
public class ArrayRepeat3Times {

	public static void main(String[] args) {
		int[] arr = {1,2,3,1,1,4};
		System.out.println(findElemRepeated(arr));
	}
	
	private static Integer findElemRepeated(int[] arr){
		java.util.Hashtable<Integer, Integer> ht = new Hashtable<>();
		for(int i=0;i<arr.length;i++){
			if(ht.get(arr[i])!=null){
				int count = ht.get(arr[i]);
				count++;
				if(count==3)
					return arr[i];
				ht.put(arr[i], count);
			}else{
				ht.put(arr[i], 1);
			}
		}
		return -1;
	}

}
