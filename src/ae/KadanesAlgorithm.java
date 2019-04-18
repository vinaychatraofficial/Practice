package ae;

public class KadanesAlgorithm {

	public static int kadanesAlgorithm(int[] array) {
		return kadanesAlgorithmOne(array);
  }
	
	private static int kadanesAlgorithmOne(int[] array) {
		int maxSum = Integer.MIN_VALUE;
		int prev=0;
    for(int i=0;i<array.length;i++){
			int sum = Math.max(array[i], array[i]+prev);
			if(sum > maxSum)
				maxSum = sum;
			prev = sum;
		}
		return maxSum;
  }
}
