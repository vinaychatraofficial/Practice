package epi.searching;

/**
 * @author vcpaks
 * 11.7 Find the min and max simultaneously
 */
public class FindMinMax {

	public static void main(String[] args) {
		int[] arr = {3,2,5,1,2,4,7};
		MinMax minMax = findMinMax(arr);
		System.out.println("min:"+minMax.min+", max:"+minMax.max);
	}
	
	public static class MinMax{
		int min;
		int max;
		
		public MinMax(int min, int max) {
			this.min=min;
			this.max=max;
			
		}
	}
	
	private static MinMax findMinMax(int[] arr) {
		int n = arr.length;
		MinMax minMax = new MinMax(arr[0],arr[0]);
		if(n==1)
			return new MinMax(arr[0],arr[0]);
		
		
		
		for(int i=0;i<=n-2;i=i+2) {
			for(int j=1;j<=n-1;j=j+2) {
				if(arr[i]>arr[j]) {
					if(arr[i]>minMax.max)
						minMax.max=arr[i];
					if(arr[j]<minMax.min)
						minMax.min=arr[j];
				}else {
					if(arr[i]<minMax.min)
						minMax.min=arr[i];
					if(arr[j]>minMax.max)
						minMax.max=arr[j];
				}
			}
		}
		
		if(n%2!=0) {
			if(arr[n-1]>minMax.max)
				minMax.max=arr[n-1];
			else if(arr[n-1]<minMax.min)
				minMax.min=arr[n-1];
		}
		
		return minMax;
			
	}

}
