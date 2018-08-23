package epi.greedy;

/**
 * @author vcpaks
 * Given a sorted array find two elements whose sum = sum
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] a = {-2,1,2,4,7,11};
		System.out.println(findTwoSum(a, 6));
	}
	
	private static boolean findTwoSum(int[] a, int total) {
		int i=0;
		int j=a.length-1; 
		while(i<=j) {
			if(a[i]+a[j]==total) {
				System.out.println(a[i]+":"+a[j]);
				return true;
			}else if(a[i]+a[j]<total) {
				i++;
			}else if(a[i]+a[j]>total) {
				j--;
			}
				
		}
		return false;
	}

}
