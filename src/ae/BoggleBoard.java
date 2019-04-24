package ae;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class BoggleBoard {
  public static ArrayList<String> boggleBoard(char[][] board, String[] words) {
    Trie trie = constructTrie(words);
		Set<String> res = new HashSet<>();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				Set<Grid> visited = new HashSet<>();
				Grid grid = new Grid(i,j);
				traverse(trie,board,grid,visited, new StringBuilder(""),res,trie.root);
			}
		}
		return new ArrayList(res);
  }
	
	private static void traverse(Trie trie, char[][] board, Grid grid, Set<Grid> visited,
													StringBuilder builder, Set<String> res,TrieNode cur){
		
		if(!cur.children.containsKey(board[grid.row][grid.col])){
			return;
		}else{
			visited.add(grid);
			builder.append(board[grid.row][grid.col]);
			cur = cur.children.get(board[grid.row][grid.col]);
			if(cur.children.containsKey('*')){
				//System.out.println("adding "+builder.toString());
				if(!res.contains(builder.toString()))
					res.add(builder.toString());
			}
		}
		
		int[] row = {1,0,-1,-1,-1,0,1,1};
		int[] col = {-1,-1,-1,0,1,1,1,0};
		for(int i=0;i<8;i++){
			Grid neighbour = new Grid(grid.row+row[i],grid.col+col[i]);
			if(checkBoundaries(board,neighbour) && !visited.contains(neighbour))
				traverse(trie,board,neighbour,visited, builder,res,cur);
		}
		builder.setLength(builder.length()-1);
		visited.remove(grid);
	}
	
	private static boolean checkBoundaries(char[][] board, Grid neighbour){
		int x = neighbour.row;
		int y = neighbour.col;
		if(x < 0 || x >board.length-1 || y<0 || y>board[0].length-1)
			return false;
		return true;
	}
	
	private static Trie constructTrie(String [] words){
		Trie trie = new Trie();
		for(String word:words)
			trie.insert(word);
		//System.out.println("Constructed trie");
		return trie;
	}
	
	static class Grid{
		int row;
		int col;
		
		public Grid(int row, int col){
			this.row=row;
			this.col=col;
		}
		
		public int hashCode(){
			return this.row+this.col;
		}
		
		public boolean equals(Object o){
			if(!(o instanceof Grid))
				return false;
			Grid other = (Grid)o;
			return this.row==other.row && this.col==other.col;
		}
	}
	
	static class TrieNode{
		Map<Character,TrieNode> children = new HashMap<>();
	}
	
	static class Trie{
		TrieNode root = new TrieNode();
		
		public void insert(String word){
			TrieNode cur = root;
			for(Character ch:word.toCharArray()){
				if(!cur.children.containsKey(ch)){
					TrieNode newNode = new TrieNode();
					cur.children.put(ch,newNode);
				}
				cur = cur.children.get(ch);
			}
			cur.children.put('*',null);
		}
		
		public boolean contains(String word){
			TrieNode cur = root;
			for(Character ch:word.toCharArray()){
				if(!cur.children.containsKey(ch))
					return false;
				cur = cur.children.get(ch);
			}
			return cur.children.containsKey('*');
		}
	}
}
