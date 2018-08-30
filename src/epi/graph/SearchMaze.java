package epi.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcpaks
 * 18.1 Search a maze
 */
public class SearchMaze {

	public static void main(String[] args) {
		int[][] maze = {{1,1,1,1},{0,1,0,1},{0,1,0,0},{1,1,1,1}};
		List<Coordinate> path = searchMaze(maze, new Coordinate(3, 0), new Coordinate(1, 3));
		for(Coordinate c:path)
			System.out.println(c.x+","+c.y);
	}
	
	public static class Coordinate{
		int x;
		int y;
		
		public Coordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	private static List<Coordinate> searchMaze(int[][] maze, Coordinate start, Coordinate end){
		List<Coordinate> path = new ArrayList<SearchMaze.Coordinate>();
		searchMaze(maze,start, end, path);
		return path;
	}

	private static boolean searchMaze(int[][] maze, Coordinate start, Coordinate end, List<Coordinate> path) {
		if(start==end || (start.x==end.x && start.y==end.y))
			return true;
		
		if(start.x<0 || start.x>=maze.length || start.y<0||start.y>=maze[start.x].length)
			return false;
		
		if(maze[start.x][start.y]==0)
			return false;
		
		path.add(start);
		//means it is already visited
		maze[start.x][start.y]=0;
		
		if(searchMaze(maze, new Coordinate(start.x+1,start.y), end, path) || searchMaze(maze, new Coordinate(start.x-1,start.y), end, path)
				|| searchMaze(maze, new Coordinate(start.x,start.y+1), end, path) || searchMaze(maze, new Coordinate(start.x,start.y-1), end, path))
			return true;
		
		path.remove(start);
		return false;
		
	}

}
