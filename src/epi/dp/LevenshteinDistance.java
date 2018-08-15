package epi.dp;

import java.util.Arrays;

/**
 * @author vcpaks
 * 16.2 Compute the levenshtein distance
 * Check Tushar Roy for proper explanation
 */
public class LevenshteinDistance {

	public static void main(String[] args) {
		System.out.println(computeLSIt("Orchestra", "Carthorse"));
		int[][] lsArr = new int["Orchestra".length()]["Carthorse".length()];
		for(int[] row:lsArr)
		Arrays.fill(row, -1);
		System.out.println(computeLSRec("Orchestra", "Orchestra".length()-1, "Carthorse", "Carthorse".length()-1, lsArr));
	}
	
	private static int computeLSIt(String str1, String str2) {
		int[][] lsArr = new int[str1.length()+1][str2.length()+1];
		lsArr[0][0]=0;
		
		
		for(int i=1;i<str1.length()+1;i++) {
			lsArr[i][0]=1+lsArr[i-1][0];
		}
		for(int j=1;j<str2.length()+1;j++) {
			lsArr[0][j]=1+lsArr[0][j-1];
		}
		for(int i=1;i<str1.length()+1;i++) {
			for(int j=1;j<str2.length()+1;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					lsArr[i][j]=lsArr[i-1][j-1];
				}else {
					int min = Integer.MAX_VALUE;
					String op="";
					if(lsArr[i][j-1]<min) {
						min=lsArr[i][j-1];
						op="add "+str2.charAt(j-1);
					}
					if(lsArr[i-1][j]<min) {
						min=lsArr[i-1][j];
						op="del "+str1.charAt(i-1);
					}
					if(lsArr[i-1][j-1]<min) {
						min=lsArr[i-1][j-1];
						op="sub "+str1.charAt(i-1);
					}
					lsArr[i][j]=1+min;
					//System.out.println(op);
				}
					
			}
		}
		return lsArr[str1.length()][str2.length()];
	}

	private static int computeLSRec(String str1, int index1, String str2, int index2, int[][] lsArr) {
		if(index1<0) {
			return index2+1;
		}else if(index2<0) {
			return index1+1;
		}
		
		if(lsArr[index1][index2]==-1) {
			if(str1.charAt(index1)==str2.charAt(index2)) {
				lsArr[index1][index2] = computeLSRec(str1, index1-1, str2, index2-1, lsArr);
			}else {
				int min = Integer.MAX_VALUE;
				String op="";
				int value = computeLSRec(str1, index1,str2, index2-1,lsArr);
				if(value<min) {
					min=value;
					op="add "+str2.charAt(index2);
				}
				value= computeLSRec(str1, index1-1,str2, index2,lsArr);
				if(value<min) {
					min=value;
					op="del "+str1.charAt(index1);
				}
				value= computeLSRec(str1, index1-1,str2, index2-1,lsArr);
				if(value<min) {
					min=value;
					op="sub "+str2.charAt(index2);
				}
				System.out.println(op);
				lsArr[index1][index2]= 1 + min;
			}
		}
			
		return lsArr[index1][index2];
	}
}
