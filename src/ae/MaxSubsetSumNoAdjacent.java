package ae;

public class MaxSubsetSumNoAdjacent {

	public static int maxSubsetSumNoAdjacent(int[] array) {
		if(array.length==0)
			return 0;
		int oneMinusSum=0;
		int twoMinusSum=0;
		for(int i=0;i<array.length;i++){
			int withoutElem = i-1>=0? oneMinusSum:0;
			int withElem = (i-2>=0? twoMinusSum:0) + array[i];
			int sum = Math.max(withoutElem,withElem);
			twoMinusSum = oneMinusSum;
			oneMinusSum = sum;
		}
		return oneMinusSum;
  }
}
