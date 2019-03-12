package test;

import java.util.Scanner;

public class Battleship {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int rows = 0,cols = 0;

		String dimStr = s.nextLine();
		String dims[] = dimStr.split(" ");
		rows = Integer.parseInt(dims[0]);
		cols = dims[1].charAt(0)-'A'+1;

		System.out.println("rows="+rows+",cols="+cols);
		int[][] player1=new int[rows][cols];
		int[][] player2=new int[rows][cols];
		int player1count=0;
		int player2count=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				player1[i][j]=-1;
				player2[i][j]=-1;
			}
		}
		int ships = Integer.parseInt(s.nextLine());
		System.out.println("ships="+ships);
		for(int m=0;m<2;m++) {
			String ships1 = s.nextLine();
			String[] ships1arr = ships1.split(" ");
			int ship1Type = ships1arr[0].equals("Q")?2:1;
			int ship1width = Integer.parseInt(ships1arr[1]);
			int ship1height = Integer.parseInt(ships1arr[2]);
			for(int i=3;i<ships1arr.length;i++) {
				String coStr = ships1arr[i];
				int startrow = coStr.charAt(0)-'A';
				int startcol = Integer.parseInt(coStr.substring(1))-1;

				for(int j=startrow;j<startrow+ship1height;j++) {
					for(int k=startcol;k<startcol+ship1width;k++) {
						if(i%2==1) {
							player1[j][k]=ship1Type;
							player1count=player1count+ship1Type;
						}else {
							player2[j][k]=ship1Type;
							player2count=player2count+ship1Type;
						}
					}
				}
			}

		}
		
		String player1Str = s.nextLine();
		String player2Str = s.nextLine();
		String[] p1arr = player1Str.split(" ");
		String[] p2arr = player2Str.split(" ");
		int p1=-1,p2=-1;
		boolean player1Plays = true;
		while(p1<p1arr.length || p2<p2arr.length) {
			if(player1Plays) {
				p1++;
				if(p1>=p1arr.length) {
					System.out.println("Player-1 has no more missiles left to launch");
					player1Plays=false;
				}else {
					
					String coStr = p1arr[p1];
					boolean present = false;
					if(player2[coStr.charAt(0)-'A'][Integer.parseInt(coStr.substring(1))-1]>0) {
						present=true;
					}
					if(present) {
						player2[coStr.charAt(0)-'A'][Integer.parseInt(coStr.substring(1))-1]--;
						player2count--;
						if(player2count==0) {
							System.out.println("Player-1 fires a missile with target "+coStr+" which got hit");
							System.out.println("Player-1 won the battle");
							System.exit(0);
						}
						System.out.println("Player-1 fires a missile with target "+coStr+" which got hit");
						player1Plays=true;
					}else {
						System.out.println("Player-1 fires a missile with target "+coStr+" which got miss");
						player1Plays=false;
					}
				}
			}else {
				p2++;
				if(p2>=p2arr.length) {
					System.out.println("Player-2 has no more missiles left to launch");
					player1Plays=true;
				}else {
					
					String coStr = p2arr[p2];
					boolean present = false;
					if(player1[coStr.charAt(0)-'A'][Integer.parseInt(coStr.substring(1))-1]>0) {
						present=true;
					}
					if(present) {
						player1[coStr.charAt(0)-'A'][Integer.parseInt(coStr.substring(1))-1]--;
						player1count--;
						if(player1count==0) {
							System.out.println("Player-2 fires a missile with target "+coStr+" which got hit");
							System.out.println("Player-2 won the battle");
							System.exit(0);
						}
						System.out.println("Player-2 fires a missile with target "+coStr+" which got hit");
						player1Plays=false;
					}else {
						System.out.println("Player-2 fires a missile with target "+coStr+" which got miss");
						player1Plays=true;
					}
				}
			
			}
		}
		
		
		
	}

}
