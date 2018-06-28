package string;

public class RabinKarp {
	
	private static final int PRIME = 101;

	public static void main(String[] args) {
		String text = "ebcdefghabci";
		String pattern = "abc";
		
		int index = findStringMatch(text, pattern);
		if(index==-1)
			System.out.println("pattern not found");
		else
			System.out.println("pattern found at index "+index);
		
	}
	
	public static int findStringMatch(String text, String pattern) {
		int patternHash = computeHash(pattern);
		int textLength = text.length();
		int patternLength= pattern.length();
		char prevChar = 0;
		int subStringHash =0;
		for(int i=0;i<(textLength-patternLength+1);i++) {
			String subStr = text.substring(i, i+3);
			
			if(i==0)
				subStringHash = computeHash(subStr);
			else
				subStringHash = recomputeHash(subStr,subStringHash, prevChar);
			
			if((subStringHash==patternHash) && subStr.equals(pattern)){
				return i;
			}
			
			prevChar = text.charAt(i);
					
		}
		return -1;
	}
	
	private static int recomputeHash(String subStr, int subStringHash, char prevChar) {
		subStringHash = (subStringHash - prevChar)/PRIME;
		subStringHash+=(subStr.charAt(subStr.length()-1)*Math.pow(PRIME, subStr.length()-1));
		return subStringHash;
	}

	private static int computeHash(String text) {
		int length = text.length();
		char[] arr = text.toCharArray();
		int sum=0;
		for(int i=0;i<length;i++) {
			sum=(int) (sum+(arr[i]*Math.pow(PRIME, i)));
		}
		return sum;
	}

}
