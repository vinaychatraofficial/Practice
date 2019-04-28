package ae;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiStringSearch {

	public static ArrayList<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
		Trie trie = new Trie();
		HashMap<String, Boolean> map = new HashMap();
		ArrayList<Boolean> res = new ArrayList<>();
		for(String str: smallStrings){
			trie.insert(str);
			map.put(str,false);
		}

		for(int i=0;i<bigString.length();i++){
			TrieNode cur = trie.root;
			int j=i;
			while(j<bigString.length()){
				if(!cur.children.containsKey(bigString.charAt(j)))
					break;
				cur = cur.children.get(bigString.charAt(j));
				j++;
				//if this substring ends with * that means this is a small string
				if(cur.children.containsKey('*'))
					map.put(bigString.substring(i,j),true);
			}
		}

		for(String str:smallStrings){
			res.add(map.get(str));
		}

		return res;
	}

	static class TrieNode{
		HashMap<Character,TrieNode> children = new HashMap<>();
	}
	static class Trie{
		TrieNode root = new TrieNode();

		public void insert(String str){
			TrieNode cur = root;
			for(char ch:str.toCharArray()){
				if(!cur.children.containsKey(ch)){
					TrieNode node = new TrieNode();
					cur.children.put(ch,node);
				}
				cur = cur.children.get(ch);
			}
			cur.children.put('*',null);
		}
	}
}
