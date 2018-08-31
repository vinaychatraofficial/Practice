package epi.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vcprabha
 * 18.2 Paint a boolean matrix
 */
public class PaintBooleanMatrix {
	
	public static class Coordinate{
		int x;
		int y;
		
		public Coordinate(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

	public static void main(String[] args) {
		int[][] image = {{0,1,0,1},{1,1,0,1},{0,0,0,1},{1,0,1,0}};
		for(int[] row:image){
			for(int elem:row)
				System.out.print(elem+" ");
			System.out.println();
		}
		flipImage(image, new Coordinate(0, 1));
		System.out.println("After flipping");
		for(int[] row:image){
			for(int elem:row)
				System.out.print(elem+" ");
			System.out.println();
		}
		
		System.out.println("DFS");
		int[][] image1 = {{0,1,0,1},{1,1,0,1},{0,0,0,1},{1,0,1,0}};
		for(int[] row:image1){
			for(int elem:row)
				System.out.print(elem+" ");
			System.out.println();
		}
		flipImageDFS(image1, new Coordinate(0, 1));
		System.out.println("After flipping");
		for(int[] row:image1){
			for(int elem:row)
				System.out.print(elem+" ");
			System.out.println();
		}
		
	}
	
	private static void flipImage(int[][] image, Coordinate point){
		if(point.x<0 || point.x>=image.length || point.y<0 || point.y>=image[point.x].length)
			return;
		
		int color = image[point.x][point.y];
		
		Queue<Coordinate> q = new LinkedList<>();
		q.add(point);
		
		while(!q.isEmpty()){
			Coordinate curr = q.remove();
			invert(image,curr);
			
			int[][] entries = {{1,0},{-1,0},{0,-1},{0,1}};
			for(int[] next:entries){
				int nextX = curr.x+next[0];
				int nextY = curr.y+next[1];
				
				if(nextX>=0 && nextX<image.length && nextY>=0 && nextY<image[nextX].length
						&& image[nextX][nextY]==color){
					q.add(new Coordinate(nextX, nextY));
				}
			}
		}
	}

	private static void invert(int[][] image, Coordinate curr) {
		int color = image[curr.x][curr.y];
		if(color==0)
			image[curr.x][curr.y]=1;
		else
			image[curr.x][curr.y]=0;
		
	}
	
	private static void flipImageDFS(int[][] image, Coordinate point){
		int color = image[point.x][point.y];
		flipImageDFS(image, point, color);
	}

	private static void flipImageDFS(int[][] image, Coordinate point, int color) {
		if(point.x<0 || point.x>=image.length || point.y<0 || point.y>=image[point.x].length)
			return;
		
		if(image[point.x][point.y]!=color)
			return;
		
		invert(image, point);
		
		int[][] entries = {{1,0},{-1,0},{0,-1},{0,1}};
		
		for(int[] next:entries){
			flipImageDFS(image, new Coordinate(point.x+next[0], point.y+next[1]),color);
		}
	}

}
