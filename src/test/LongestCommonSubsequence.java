package test;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "acbcf";
		String longestSubSeq = findLongestSubseq(str1, str2);
		System.out.println("longest sub sequence is "+longestSubSeq);
	}

	private static String findLongestSubseq(String str1, String str2) {
		StringBuilder builder = new StringBuilder();
		int[][] subarr = new int[str2.length()+1][str1.length()+1];
		for(int i=0;i<=str2.length();i++)
			subarr[i][0]=0;
		for(int i=0;i<=str1.length();i++)
			subarr[0][i]=0;
		for(int i=1;i<=str2.length();i++) {
			for(int j=1;j<=str1.length();j++) {
				if(str1.charAt(j-1)==str2.charAt(i-1)) {
					subarr[i][j]=1 + subarr[i-1][j-1];
				}else {
					subarr[i][j] = Math.max(subarr[i-1][j], subarr[i][j-1]);
				}
			}
		}
		System.out.println("max sum is "+subarr[str2.length()][str1.length()]);
		int i = str2.length(),j=str1.length();
		while(i>0 && j>0) {
			if(subarr[i][j]==subarr[i-1][j]) {
				i=i-1;
			}else if(subarr[i][j]==subarr[i][j-1]){
				j=j-1;
			}else {
				builder.insert(0, str1.charAt(j-1));
				System.out.println("inserting "+str1.charAt(j-1));
				i=i-1;
				j=j-1;
			}
		}
		return builder.toString();
	}

}
