package ae;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeNumberSum {
	public static ArrayList<Integer[]> threeNumberSum(int[] array, int targetSum) {
		Arrays.sort(array);
		ArrayList<Integer[]> ans = new ArrayList<>();

		for(int i=0;i<array.length-2;i++){
			int left =i+1;
			int right=array.length-1;
			int cur = array[i];

			while(left<right){
				Integer[] res = new Integer[3];
				if(array[left]+array[right]==targetSum-cur){
					res[0]=cur;
					//System.out.println(array[left]);
					res[1]=array[left];
					//System.out.println(array[right]);
					res[2]=array[right];
					ans.add(res);
					left++;
					right--;
					//break;
				}else if(array[left]+array[right]<targetSum-cur){
					left++;
				}else{
					right--;
				}
			}
		}
		//	for(Integer[] arr:ans)
		//		System.out.println(arr[0]+":"+arr[1]+":"+arr[2]);
		return ans;
	}
}
