package ae;

import java.util.ArrayList;

public class LongestCommonSubsequence {

	public static ArrayList<Character> longestCommonSubsequence(String str1, String str2) {
		int[][] length = new int[str2.length()+1][str1.length()+1];
		for(int i=0;i<=str2.length();i++){
			length[i][0]=0;
		}
		for(int i=0;i<=str1.length();i++){
			length[0][i]=0;
		}

		for(int i=1;i<=str2.length();i++){
			for(int j=1;j<=str1.length();j++){
				if(str1.charAt(j-1)==str2.charAt(i-1)){
					length[i][j] = 1+length[i-1][j-1];
				}else{
					length[i][j] = Math.max(length[i][j-1],length[i-1][j]);
				}
			}
		}
		ArrayList<Character> list = new ArrayList<>();

		int i=str2.length(), j=str1.length();

		while(i>0 && j>0){
			if(length[i][j] == length[i-1][j])
				i--;
			else if(length[i][j] == length[i][j-1])
				j--;
			else{
				list.add(0,str1.charAt(j-1));
				i--;
				j--;
			}
		}

		return list;
	}
}
