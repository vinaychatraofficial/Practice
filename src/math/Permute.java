package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute {

	public static void main(String[] args) {
		List<String> result = permute("aba");
		System.out.println(result);
	}
	
	private static List<String> permute(String input){
		List<String> result = new ArrayList<>();
		permute(input,0,result);
		Set<String> resSet = new HashSet<>(result);
		result = new ArrayList<>(resSet);
		Collections.sort(result);
		return result;
	}

	private static void permute(String input, int i,List result) {
		if(i==input.length()) {
			result.add(input);
		}
		for(int j=i;j<input.length();j++) {
			char temp = input.charAt(i);
			StringBuilder strB = new StringBuilder(input);
			strB.setCharAt(i, input.charAt(j));
			strB.setCharAt(j, temp);
			input=strB.toString();
			permute(input,j+1,result);
			temp = input.charAt(i);
			strB = new StringBuilder(input);
			strB.setCharAt(i, input.charAt(j));
			strB.setCharAt(j, temp);
			input=strB.toString();
		}
	}

}
