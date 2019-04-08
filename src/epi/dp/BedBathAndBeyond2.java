package epi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author vcpaks
 * 16.7 BedBathAndBeyond.com problem
 */
public class BedBathAndBeyond2 {

	public static void main(String[] args) {
		ArrayList<String> decompositions = new ArrayList<>();
		Set<String> dictionary = new HashSet();
		Map<String, ArrayList<String>> dpMap = new HashMap<>();
		dictionary.add("bed");
		dictionary.add("bat");
		dictionary.add("bath");
		dictionary.add("hand");
		dictionary.add("beyond");
		dictionary.add("a");
		//dictionary.add("anger");
		List<String> res = findDecompositions("bedbathandbeyond", dictionary, decompositions,0,dpMap);
		//List<String> res = findDecompositions("bedbathanger", dictionary, decompositions,0,dpMap);
		System.out.println(res);
		findWords("bedbathandbeyond", dictionary);
	}
	
	/**
	 * @param domain
	 * @param dictionary
	 * @param decompositions
	 * @param dpMap 
	 */
	private static ArrayList<String> findDecompositions(String domain, Set<String> dictionary, ArrayList<String> decompositions, int start,
			Map<String, ArrayList<String>> dpMap) {
		System.out.println(domain.substring(start));
		String key = domain.substring(start);
		if(dpMap.containsKey(key)) {
			System.out.println("found "+key);
			dpMap.get(key);
		}
		
		for(int i=start+1;i<=domain.length();i++) {
			String pre = domain.substring(start, i);
			if(dictionary.contains(pre)) {
				decompositions.add(pre);
				if(i==domain.length())
					return decompositions;
				else {
					ArrayList<String> arr = findDecompositions(domain, dictionary, decompositions, i, dpMap);
					if(arr!=null) {
						//decompositions.addAll(arr);
						dpMap.put(key, decompositions);
						return decompositions;
					}else {
						decompositions.remove(pre);
					}
				}
					
			}
		}
		System.out.println("returning from "+key);
		return null;
	}
	
	private static void findWords(String domain,Set<String> dictionary) {
		int[] length = new int[domain.length()];
		
		/*int max =0;
		for(String s:dictionary) {
			max = Math.max(max, s.length());
		}*/
		
		for(int i=0;i<domain.length();i++) {
			if(dictionary.contains(domain.substring(0, i+1))) {
				length[i]=i+1;
			}
			
			for(int j=0;j<i;j++) {
				if(length[j]!=0 && dictionary.contains(domain.substring(j+1,i+1))) {
					length[i]=i-j;
				}
			}
			
		}
		
		int index = domain.length()-1;
		if(length[index]!=0) {
			while(index>=0) {
				int len = length[index];
				System.out.print(domain.substring(index-len+1,index+1)+" ");
				index = index-len;
			}
		}
	}
		
		
		
	}

