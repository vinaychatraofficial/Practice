package ae;

public class PalindromePartitioningMinCuts {

	public static int palindromePartitioningMinCuts(String str) {
		int[] cuts = new int[str.length()];
		cuts[0]=0;
		for(int i=1;i<str.length();i++){
			cuts[i]=Integer.MAX_VALUE;
		}
		boolean[][] palindrome = new boolean[str.length()][str.length()];
		generatePalindrome(palindrome,str);

		for(int i=1;i<str.length();i++){
			for(int j=0;j<=i;j++){
				//String sub = str.substring(j,i+1);
				if(palindrome[j][i]){
					cuts[i]= Math.min(cuts[i],(j==0? -1:cuts[j-1]) +1);
				}
			}
		}
		return cuts[str.length()-1];
	}

	private static void generatePalindrome(boolean[][] palindrome, String str){
		for(int i=0;i<str.length();i++){
			palindrome[i][i]=true;
		}

		for(int length=2;length<=str.length();length++){
			for(int i=0;i<=str.length()-length;i++){
				int j = i+length-1;
				palindrome[i][j] = str.charAt(i)==str.charAt(j) &&
						(length==2 ? true:palindrome[i+1][j-1]);
			}
		}
	}
}
