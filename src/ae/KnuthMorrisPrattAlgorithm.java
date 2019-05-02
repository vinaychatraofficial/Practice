package ae;

import java.util.Arrays;

public class KnuthMorrisPrattAlgorithm {

	public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
		//form a prefix array
		int[] prefix = buildPrefix(substring);

		//use prefix array to check if substring is present in string
		return search(string,substring,prefix);
	}

	private static boolean search(String str, String substr, int[] prefix){
		int i=0,j=0;
		while(i<str.length()){
			if(str.charAt(i)==substr.charAt(j)){
				if(j==substr.length()-1)
					return true;
				i++;
				j++;
			}else if(j>0){
				j = prefix[j-1] + 1;
			}else{
				i++;
			}
		}
		return false;
	}

	private static int[] buildPrefix(String substring){
		int j=0,i=1;
		int[] prefix = new int[substring.length()];
		Arrays.fill(prefix,-1);

		while(i<substring.length()){
			if(substring.charAt(j)==substring.charAt(i)){
				prefix[i]=j;
				i++;
				j++;
			}else if(j>0){
				j = prefix[j-1] + 1;
			}else{
				i++;
			}
		}
		return prefix;
	}
}
