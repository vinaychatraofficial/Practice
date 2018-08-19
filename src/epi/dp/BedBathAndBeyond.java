package epi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author vcpaks
 * 16.7 BedBathAndBeyond.com problem
 */
public class BedBathAndBeyond {

	public static void main(String[] args) {
		List<String> decompositions = new ArrayList<>();
		Set<String> dictionary = new HashSet();
		dictionary.add("bed");
		dictionary.add("bat");
		dictionary.add("bath");
		dictionary.add("hand");
		dictionary.add("beyond");
		dictionary.add("a");
		findDecompositions("bedbathandbeyond", dictionary, decompositions);
		Collections.reverse(decompositions);
		System.out.println(decompositions);
	}
	
	/**
	 * @param domain
	 * @param dictionary
	 * @param decompositions
	 */
	private static void findDecompositions(String domain, Set<String> dictionary, List<String> decompositions) {
		int[] lastLength = new int[domain.length()];
		Arrays.fill(lastLength, -1);
		if(dictionary.contains(domain)) {
			lastLength[domain.length()-1]=domain.length();
		}else {
			for(int i=0;i<domain.length();i++) {
				if(dictionary.contains(domain.substring(0, i+1))) {
					lastLength[i]=i+1;
				}
				
				if(lastLength[i]==-1) {
					for(int j=0;j<i;j++) {
						if(lastLength[j]!=-1 && dictionary.contains(domain.substring(j+1,i+1))) {
							lastLength[i]=i-j;
							break;
						}
					}
				}
			}
				
			int index = domain.length()-1;
				if(lastLength[index]!=1) {
					
					System.out.println(index);
					while(index>=0) {
						int length = lastLength[index];
						index = index - length;
						System.out.println(index);
						decompositions.add(domain.substring(index+1,index+length+1));
					}
				}
			}
		}
		
		
		
	}

