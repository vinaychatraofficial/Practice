/**
 * 
 */
package epi.greedy;

import java.util.Arrays;

/**
 * @author vcpaks
 * 17.4 3-Sum problem
 */
public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {11,2,5,7,3};
		System.out.println(threeSum(a, 21));
	}
	
	private static boolean threeSum(int a[], int total) {
		Arrays.sort(a);
		for(int i=0;i<a.length;i++) {
			int j=0,k=a.length-1;
			while(j<=k) {
				if(a[j]+a[k]==total-a[i]) {
					System.out.println(a[i]+":"+a[j]+":"+a[k]);
					return true;
				}else if(a[j]+a[k]<total-a[i]) {
					j++;
				}else if(a[j]+a[k]>total-a[i]) {
					k--;
				}
					
			}
		}
		return false;
	}

}
