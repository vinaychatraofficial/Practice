package epi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author vcpaks
 * 18.3 Compute enclosed region
 */
public class EnclosedRegion {
	
	public static class Coordinate{
		int x;
		int y;
		
		public Coordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this==obj)
				return true;
			
			if(obj==null)
				return false;
			
			if(obj.getClass()!=this.getClass())
				return false;
			
			Coordinate o = (Coordinate)obj;
			if(o.x==this.x && o.y==this.y)
				return true;
			
			return false;
		}
		
		@Override
		public int hashCode() {
			return this.x+this.y;
		}
		
	}

	public static void main(String[] args) {
		int[][] region = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		for(int[] row:region){
			for(int elem:row)
				System.out.print(elem+" ");
			System.out.println();
		}
		
		markEnclosed(region);
		System.out.println("After");
		for(int[] row:region){
			for(int elem:row)
				System.out.print(elem+" ");
			System.out.println();
		}
		
		System.out.println("BFS");
		int[][] region1 = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		for(int[] row:region1){
			for(int elem:row)
				System.out.print(elem+" ");
			System.out.println();
		}
		
		markEnclosed(region1);
		System.out.println("After");
		for(int[] row:region1){
			for(int elem:row)
				System.out.print(elem+" ");
			System.out.println();
		}
		
	}
	
	private static void markEnclosed(int[][] region) {
		Map<Coordinate,Boolean> visited = new HashMap<>();
		List<Coordinate> prevVisited;
		for(int i=0;i<region.length;i++) {
			for(int j=0;j<region[0].length;j++) {
				prevVisited = new ArrayList<>();
				if(region[i][j]==1)
					if(!markEnclosed(region,new Coordinate(i,j),visited, prevVisited))
						region[i][j]=0;
			}
				
		}
	}

	private static boolean markEnclosed(int[][] region, Coordinate point,Map<Coordinate,Boolean> visited, List<Coordinate> prevVisited) {
		if(visited.get(point)!=null)
			return visited.get(point);
		
		if(point.x<0 || point.x>=region.length || point.y<0 || point.y>=region[point.x].length )
			return false;
		//if reaches boundary and white return true
		if(region[point.x][point.y]==1 && (point.x==0 || point.y==0 || point.x==region.length-1 || point.y==region[point.x].length-1)) {
			visited.put(point, true);
			return true;
		}
		
		int[][] neighbours = {{-1,0},{1,0},{0,1},{0,-1}};
		prevVisited.add(point);
		
		for(int[] next:neighbours) {
			int nextX = point.x+next[0];
			int nextY = point.y+next[1];
			if(region[nextX][nextY]==1 && !prevVisited.contains(new Coordinate(nextX,nextY)) 
					&& markEnclosed(region, new Coordinate(nextX,nextY), visited, prevVisited)) {
				visited.put(point, true);
				return true;
			}
		}
		
		visited.put(point, false);
		region[point.x][point.y]=0;
		return false;
	}
	
	private static void markEnclosedBFS(int[][] region) {
		for(int i=0;i<region.length;i++) {
			if(region[i][0]==1)
				markEnclosedBFS(region, new Coordinate(i,0));
			if(region[i][region[i].length-1]==1)
				markEnclosedBFS(region, new Coordinate(i,region[i].length-1));
		}
		
		for(int j=0;j<region[0].length;j++) {
			if(region[0][j]==1)
				markEnclosedBFS(region,new Coordinate(0, j));
			if(region[region.length-1][j]==1)
				markEnclosedBFS(region, new Coordinate(region.length-1, j));
		}
		
		for(int i=0;i<region.length;i++) {
			for(int j=0;j<region[i].length;j++) {
				if(region[i][j]==2)
					region[i][j]=1;
			}
		}
	}

	private static void markEnclosedBFS(int[][] region, Coordinate point) {
		Queue<Coordinate> q = new LinkedList<>();
		q.add(point);
		
		while(!q.isEmpty()) {
			Coordinate curr = q.remove();
			region[curr.x][curr.y]=2;
			int[][] entries = {{-1,0},{1,0},{0,1},{0,-1}};
			for(int[] next:entries) {
				int nextX = curr.x+next[0];
				int nextY = curr.y+next[1];
				if(nextX>=0 && nextY>=0 && nextX<region.length && nextY<region[nextX].length && region[nextX][nextY]==1) {
					q.add(new Coordinate(nextX,nextY));
				}
			}
		}
		
	}

}
