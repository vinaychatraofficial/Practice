package epi.searching;

/**
 * @author vcprabha
 * 11.4 Compute the integer square root
 */
public class IntegerSquareRoot {

	public static void main(String[] args) {
		System.out.println(computeSquareRoot(21));
	}
	
	private static int computeSquareRoot(int num){
		int low=0,high=num;
		while(low<=high){
			int mid = low+(high-low)/2;
			long square = mid*mid;
			if(square==num)
				return mid;
			else if(square<num)
				low=mid;
			else
				high=mid-1;
		}
		return low-1;
	}

}
