package ae;

import java.util.HashMap;

public class SuffixTrieConstruction {
	static class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	}

	static class SuffixTrie {
		TrieNode root = new TrieNode();
		char endSymbol = '*';

		public SuffixTrie(String str) {
			populateSuffixTrieFrom(str);
		}

		public void populateSuffixTrieFrom(String str) {
			for(int i=0;i<str.length();i++){
				insertNode(i,str.substring(i));
			}
		}

		private void insertNode(int i, String str){
			TrieNode cur = root;
			for(int j=0;j<str.length();j++){
				Character letter = str.charAt(j);
				if(!cur.children.containsKey(letter)){
					TrieNode newNode = new TrieNode();
					cur.children.put(letter,newNode);
				}
				cur = cur.children.get(letter);
			}
			cur.children.put(endSymbol,null);
		}

		public boolean contains(String str) {
			TrieNode cur = root;
			for(int i=0;i<str.length();i++){
				if(!cur.children.containsKey(str.charAt(i)))
					return false;
				cur = cur.children.get(str.charAt(i));
			}
			return cur.children.containsKey('*');
		}
	}
}
