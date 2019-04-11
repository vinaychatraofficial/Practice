package test;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowString {

	public static void main(String[] args) {
		String str = "this is a test string"; 
        String pat = "tist";
        String sub = findPattern(str,pat);
        System.out.println(sub);
	}

	private static String findPattern(String str, String pat) {
		String res = "";
		int minLength = Integer.MAX_VALUE;
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<pat.length();i++) {
			if(!map.containsKey(pat.charAt(i)))
				map.put(pat.charAt(i), 1);
			else
				map.put(pat.charAt(i), map.get(pat.charAt(i))+1);
		}
		int count = pat.length();
		int start=0;
		for(int end=0;end<str.length();end++) {
			if(map.containsKey(str.charAt(end))) {
				map.put(str.charAt(end), map.get(str.charAt(end))-1);
				if(map.get(str.charAt(end))>=0)
					count--;
			}
			while(count==0) {
				if(end-start+1<minLength) {
					minLength = end-start+1;
					res = str.substring(start, end+1);
				}
					
				if(map.containsKey(str.charAt(start))) {
					map.put(str.charAt(start), map.get(str.charAt(start))+1);
					if(map.get(str.charAt(start))>0)
						count++;
				}
				start++;
			}
		}
		return res;
	}

}
