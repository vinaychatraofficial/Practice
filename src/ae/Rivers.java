package ae;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Rivers {
  public static ArrayList<Integer> riverSizes(int[][] matrix) {
    
		int m=matrix.length;
		int n=matrix[0].length;
		ArrayList<Integer> res = new ArrayList<Integer>();
		Set<Node> visited = new HashSet<>();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				Node node = new Node(i,j);
				int count=0;
				if(matrix[i][j]==1 && !visited.contains(node)){
					count = findSize(matrix,visited,i,j,m,n,0);
					res.add(count);
				}
			}
		}
		return res;
  }
	
	private static int findSize(int[][] matrix, Set<Node> visited, int i, int j, int m, int n,
											 int count){
		Node node = new Node(i,j);
		visited.add(node);
		count++;
		Node next = new Node(i+1,j);
		if(i+1<m && !visited.contains(next) && matrix[i+1][j]==1)
			count += findSize(matrix,visited,i+1,j,m,n,0);
		next = new Node(i-1,j);
		if(i-1>=0 && !visited.contains(next) && matrix[i-1][j]==1)
			count += findSize(matrix,visited,i-1,j,m,n,0);
		next = new Node(i,j+1);
		if(j+1<n && !visited.contains(next) && matrix[i][j+1]==1)
			count += findSize(matrix,visited,i,j+1,m,n,0);
		next = new Node(i,j-1);
		if(j-1>=0 && !visited.contains(next) && matrix[i][j-1]==1)
			count += findSize(matrix,visited,i,j-1,m,n,0);
		return count;
	}
	
	static class Node{
		int row;
		int col;
		
		public Node(int row, int col){
			this.row=row;
			this.col=col;
		}
		
		public int hashCode(){
			return (this.row+this.col)%31;
		}
		
		public boolean equals(Object o){
			if(o==null || !(o instanceof Node))
					return false;
			Node other = (Node)o;
			return this.row==other.row && this.col==other.col;
		}
	}
}
