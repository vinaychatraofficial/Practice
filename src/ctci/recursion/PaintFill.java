/**
 * 
 */
package ctci.recursion;

/**
 * 9.7
 * @author vcpaks
 *
 */
public class PaintFill {
	
	public enum Color{
		RED,WHITE,GREEN,BLACK,BLUE;
	}

	public static void main(String[] args) {
		Color[][] color = {{Color.BLUE,Color.BLUE,Color.WHITE,Color.BLUE},
						   {Color.BLACK,Color.GREEN,Color.GREEN,Color.RED},
						   {Color.BLUE,Color.GREEN,Color.GREEN,Color.GREEN},
						   {Color.BLUE,Color.GREEN,Color.BLACK,Color.WHITE}
						};
		for(int i=0;i<color.length;i++) {
			for(int j=0;j<color[i].length;j++) {
				System.out.print(color[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Paint fill");
		paintFill(color,1,2,Color.GREEN,Color.RED);
		for(int i=0;i<color.length;i++) {
			for(int j=0;j<color[i].length;j++) {
				System.out.print(color[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void paintFill(Color[][] color, int x, int y, Color oldColor, Color newColor) {
		if(y<0 || y>=color.length || x<0 || x>=color[y].length)
			return;
		
		if(color[y][x]==oldColor) {
			color[y][x] = newColor;
			paintFill(color,x-1,y,oldColor,newColor);
			paintFill(color,x+1,y,oldColor,newColor);
			paintFill(color,x,y-1,oldColor,newColor);
			paintFill(color,x,y+1,oldColor,newColor);
		}
	}

}
