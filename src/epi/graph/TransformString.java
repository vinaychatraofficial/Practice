package epi.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author vcpaks
 * 18.7 Transform one string to another
 */
public class TransformString {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("dog");
		dict.add("cog");
		dict.add("bat");
		dict.add("bot");
		dict.add("dot");
		dict.add("cot");
		dict.add("set");
		System.out.println(transformString(dict, "cat", "dog"));
	}
	
	private static int transformString(Set<String> dict, String s, String t) {
		Set<String> visited = new HashSet<>();
		visited.add(s);
		Map<String, Integer> distMap = new HashMap<>();
		distMap.put(s, 0);
		Queue<String> q = new LinkedList<>();
		q.add(s);
		while(!q.isEmpty()) {
			String curr = q.remove();
			System.out.println(curr+" is connected to ");
			if(curr.equals(t))
				return distMap.get(curr);
			for(int i=0;i<curr.length();i++) {
				String prefix = i==0?"":curr.substring(0, i);
				String suffix = i==curr.length()-1?"":curr.substring(i+1);
				for(int c=0;c<26;c++) {
					String next = prefix + (char)('a'+c) + suffix;
					if(dict.contains(next)) {
						if(!visited.contains(next)) {
							q.add(next);
							visited.add(next);
							distMap.put(next, distMap.get(curr)+1);
							System.out.print(next+",");
						}
					}
				}
			}
			System.out.println();
		}
		return -1;
	}

}
