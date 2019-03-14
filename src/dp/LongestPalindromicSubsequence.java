package dp;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String str = "agbdba";
		int length = findLongestSubseq(str);
		System.out.println(length);
	}

	private static int findLongestSubseq(String str) {
		int[][] longestSub = new int[str.length()][str.length()];
		for(int i=0;i<str.length();i++)
			longestSub[i][i]=1;
		for(int length=2;length<=str.length();length++) {
			for(int i=0;i<=str.length()-length;i++) {
				int j=i+length-1;
				if(str.charAt(i)==str.charAt(j)) {
					longestSub[i][j]=2+ ((i+1<=j-1)?longestSub[i+1][j-1]:0);
				}else {
					longestSub[i][j]=Math.max(longestSub[i][j-1], longestSub[i+1][j]);
				}
			}
		}
		int i=0,j=str.length()-1;
		char[] pal = new char[longestSub[0][str.length()-1]];
		int start=0,end=longestSub[0][str.length()-1]-1;
		while(i<=j) {
			if(str.charAt(i)==str.charAt(j)) {
				if(i==j) {
					pal[start]=str.charAt(i);
					break;
				}else {
					pal[start]=str.charAt(i);
					pal[end]=str.charAt(j);
					i=i+1;
					j=j-1;
					start++;
					end--;
				}
			}else {
				if(longestSub[i][j]==longestSub[i+1][j]) {
					i=i+1;
				}else {
					j=j-1;
				}
			}
		}
		System.out.println(pal);
		return longestSub[0][str.length()-1];
	}

}
