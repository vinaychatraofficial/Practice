package ae;

public class NumberOfBinaryTreeTopologies {

	public static int numberOfBinaryTreeTopologies(int n) {
		int[] noOfTrees = new int[n+1];
		noOfTrees[0]=1;
		for(int length=1;length<=n;length++){
			int res=0;
			for(int left=0;left<length;left++){
				int right = length-1-left;
				res+= noOfTrees[left]*noOfTrees[right];
			}
			noOfTrees[length]=res;
		}
		return noOfTrees[n];
	}

	private static int numberOfBinaryTreeTopologiesRec(int n,int[] noOfTrees){
		if(noOfTrees[n]>0)
			return noOfTrees[n];
		int res=0;
		for(int left=0;left<n;left++){
			int right = n-1-left;
			res += numberOfBinaryTreeTopologiesRec(left,noOfTrees) * 
					numberOfBinaryTreeTopologiesRec(right,noOfTrees);
		}

		noOfTrees[n]=res;
		return res;
	}

	public static int numberOfBinaryTreeTopologies1(int n) {
		if(n==0)
			return 1;
		int res = 0;
		for(int i=0;i<n;i++){
			int j = n-1-i;
			res+= numberOfBinaryTreeTopologies1(i)*numberOfBinaryTreeTopologies1(j);
		}
		return res;
	}
}
