package ae;

public class LongestPalindromicSubstring {

	public static String longestPalindromicSubstring(String str) {
		if(str.isEmpty())
			return "";
		int fstart=0;
		int fend=0;
		int longest=1;
		
		for(int i=1;i<str.length();i++){
			//odd length
			int start = i-1;
			int end = i+1;
			while(start>=0 && end<str.length()){
				if(str.charAt(start)!=str.charAt(end))
					break;
				start--;
				end++;
			}
			start++;
			end--;
			if(end+1-start > longest){
				longest = end+1-start;
				fstart=start;
				fend=end;
			}
			
			//even length
			start = i-1;
			end = i;
			while(start>=0 && end<str.length()){
				if(str.charAt(start)!=str.charAt(end))
					break;
				start--;
				end++;
			}
			start++;
			end--;
			if(end+1-start > longest){
				longest = end+1-start;
				fstart=start;
				fend=end;
			}
		}
		return str.substring(fstart,fend+1);
  }
}
