package ae;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {

	public static String longestSubstringWithoutDuplication(String str) {
		Map<Character,Integer> charIdx = new HashMap<>();
		int start=0,maxStart=0,maxEnd=0;
		int end =0;
		for(int i=0;i<str.length();i++){
			if(!charIdx.containsKey(str.charAt(i)) ||
					charIdx.get(str.charAt(i)) < start){
				charIdx.put(str.charAt(i),i);
			}else{	
				end = i;
				if(end-start > maxEnd - maxStart){
					maxEnd = end;
					maxStart = start;
				}
				start = charIdx.get(str.charAt(i))+1;
				charIdx.put(str.charAt(i),i);
			}
		}
		end = str.length();
		if(end-start > maxEnd - maxStart){
			maxEnd = end;
			maxStart = start;
		}
		return str.substring(maxStart,maxEnd);
	}
}
