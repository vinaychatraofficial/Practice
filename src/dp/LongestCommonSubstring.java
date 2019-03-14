package dp;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "zbcdf";
		int length = findCommonSubstr(str1,str2);
		System.out.println(length);
	}

	private static int findCommonSubstr(String str1, String str2) {
		int[][] longestSub = new int[str2.length()+1][str1.length()+1];
		for(int i=0;i<=str2.length();i++)
			longestSub[i][0]=0;
		for(int j=0;j<=str1.length();j++)
			longestSub[0][j]=0;
		for(int i=1;i<str2.length()+1;i++) {
			for(int j=1;j<str1.length()+1;j++) {
				if(str1.charAt(j-1)==str2.charAt(i-1))
					longestSub[i][j]=1+longestSub[i-1][j-1];
			}
		}
		int max = Integer.MIN_VALUE;
		int maxi=0,maxj=0;
		for(int i=0;i<str2.length()+1;i++) {
			for(int j=0;j<str1.length()+1;j++) {
				if(longestSub[i][j]>max) {
					max = longestSub[i][j];
					maxi=i;
					maxj=j;
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		while(longestSub[maxi][maxj]!=0) {
			builder.insert(0, str1.charAt(maxj-1));
			maxi--;
			maxj--;
		}
		System.out.println(builder.toString());
		return max;
	}

}
