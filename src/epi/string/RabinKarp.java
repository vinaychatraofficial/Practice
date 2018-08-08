package epi.string;

public class RabinKarp {
	
	private static final int prime=101;

	public static void main(String[] args) {
		System.out.println(stringMatch("vinay", "ina"));
	}
	
	private static int stringMatch(String text,String pattern) {
		int patternHash = computeHash(pattern,0,pattern.length());
		int textHash = computeHash(text,0,pattern.length());
		if((patternHash==textHash) && checkEquals(text,pattern,0,pattern.length())) {
			return 0;
		}
		
		int m = pattern.length();
		int n = text.length();
		for(int i=1;i<(n-m+1);i++) {
			textHash = recomputeHash(text,textHash,text.charAt(i-1),text.charAt(i+m-1),m);
			System.out.println("patternHash:"+patternHash);
			System.out.println("textHash:"+textHash);
			if((patternHash==textHash) && checkEquals(text,pattern,i,pattern.length())) {
				return i;
			}
		}
		
		return -1;
	}

	private static int recomputeHash(String text, int textHash, int prevChar, int nextChar,int length) {
		textHash = (textHash - prevChar)/prime;
		textHash=(int) (textHash+(nextChar*Math.pow(prime, length-1)));
		return textHash;
	}

	private static boolean checkEquals(String text, String pattern, int i, int length) {
		int count=0;
		while(count<length) {
			System.out.println("i:"+i);
			System.out.println("text char:"+text.charAt(i+count)+" pattern char:"+pattern.charAt(count));
			if(text.charAt(i+count)!=pattern.charAt(count))
				return false;
			count++;
		}
		return true;
	}

	private static int computeHash(String pattern, int i, int length) {
		int hash=0;
		while(i<length) {
			hash+=pattern.charAt(i)*Math.pow(prime, i);
			i++;
		}
		return hash;
	}

}
