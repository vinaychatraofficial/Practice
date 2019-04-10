package ae;

public class NthFibonacci {

	public static int getNthFib(int n) {
		if(n==1)
			return 0;
		if(n==2)
			return 1;
		int prev1 = 0;
		int prev2 = 1;
		int count=2;
		while(count<n){
			int cur = prev1+prev2;
			count++;
			prev1=prev2;
			prev2=cur;
		}
		return prev2;
  }
}
