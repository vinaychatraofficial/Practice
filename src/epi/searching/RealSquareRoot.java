package epi.searching;

/**
 * @author vcpaks
 * 11.5 Compute the real square root
 */
public class RealSquareRoot {
	
	public static void main(String[] args) {
		System.out.println(realSquareRoot(22.0));
	}
	
	private static double realSquareRoot(double x) {
		double left,right;
		if(x<1.0) {
			left=x;
			right=1.0;
		}else {
			left=1.0;
			right=x;
		}
		
		while(left<=right) {
			double mid = left+(right-left)/2;
			double square = mid*mid;
			if(square==x)
				return mid;
			else if(square<x)
				left=mid;
			else
				right=mid;
			System.out.println("left:"+left+" right:"+right);
		}
		return left;
	}

}
