package bst;

public class CountTrees {

	public static void main(String[] args) {
		System.out.println(countTree(2));
	}
	
	private static int countTree(int n){
		if(n<=1)
			return 1;
		int sum=0;
		for(int root=1;root<=n;root++){
			int left = countTree(root-1);
			int right = countTree(n-root);
			sum+=left*right;
		}
		
		return sum;
	}

}
