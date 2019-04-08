package ctci.recursion;

import java.util.ArrayList;

/**
 * 9.5
 * @author vcpaks
 *
 */
public class GenerateStringPermutations {

	public static void main(String[] args) {
		String inp = "123";
		ArrayList<String> res = genPerms(inp);
		for(String str:res)
			System.out.println(str);
	}
	
	public static ArrayList<String> genPerms(String str){
		if(str==null || str.isEmpty())
			return new ArrayList<String>();
		else if(str.length()==1) {
			ArrayList<String> temp = new ArrayList<>();
			temp.add(str);
			return temp;
		}
		
		char lastChar = str.charAt(str.length()-1);
		ArrayList<String> prevPerms = genPerms(str.substring(0, str.length()-1));
		ArrayList<String> newPerms = new ArrayList<>();
		for(String word:prevPerms) {
			for(int i=0;i<=word.length();i++) {
				String prev = word.substring(0,i);
				String next = word.substring(i);
				newPerms.add(prev+lastChar+next);
			}
		}
		return newPerms;
	}

}
