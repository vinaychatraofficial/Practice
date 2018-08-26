package epi.greedy;

/**
 * @author vcpaks
 * 17.7 Compute the maximum water trapped by a pair of vertical lines
 */
public class MaximumWaterTrapped {

	public static void main(String[] args) {
		int[] a = {1,2,1,3,4,4,5,6,2,1,3,1,3,2,1,2,4,1};
		System.out.println(findMaxWaterTrapped(a));
	}
	
	private static int findMaxWaterTrapped(int[] a) {
		int i=0,j=a.length-1;
		int maxWaterLevel = 0;
		
		while(i<j) {
			int waterLevel = (j-i)*Math.min(a[i], a[j]);
			if(waterLevel>maxWaterLevel)
				maxWaterLevel=waterLevel;
			if(a[i]<=a[j]) {
				i++;
			}else {
				j--;
			}
		}
		
		return maxWaterLevel;
		
	}

}
