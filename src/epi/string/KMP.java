package epi.string;

/**
 * @author vcprabha
 * String match using KMP
 */
public class KMP {

	public static void main(String[] args) {
		System.out.println(stringMatch("abcxabcdabcdabcyee", "abcdabcy"));
	}
	
	private static int stringMatch(String text, String pattern){
		int[] prefixArr = computePrefixArray(pattern);
		System.out.println("prefixArr:");
		for(int i=0;i<prefixArr.length;i++)
			System.out.print(prefixArr[i]);
		System.out.println();
		int i=0,j=0;
		while(i<text.length()&&j<pattern.length()){
			if(text.charAt(i)==pattern.charAt(j)){
				i++;
				j++;
			}else{
				if(j==0){
					i++;
				}else{
					j=prefixArr[j-1];
				}
			}
		}
		if(j==pattern.length())
			return i-j;
		
		return -1;
		
	}

	private static int[] computePrefixArray(String str) {
		int[] prefixArr = new int[str.length()];
		int index=0;
		prefixArr[0]=0;
		int i=1;
		while(i<str.length()){
			if(str.charAt(i)==str.charAt(index)){
				prefixArr[i]=index+1;
				i++;
				index++;
			}else{
				if(index==0){
					prefixArr[i]=0;
					i++;
				}else{
					index=prefixArr[index-1];
				}
					
			}
		}
		return prefixArr;
	}

}
