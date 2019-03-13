package dp;

public class MinEditDistance {

	public static void main(String[] args) {
		String str1="abcdef";
		String str2="azced";
		int min = findMinEditDist(str1,str2);
		System.out.println(min);
	}

	private static int findMinEditDist(String str1, String str2) {
		int[][] minOps = new int[str2.length()+1][str1.length()+1];
		minOps[0][0]=0;
		for(int i=1;i<=str1.length();i++) {
			
			minOps[0][i]=str1.substring(0, i).length();
		}
		for(int i=1;i<=str2.length();i++) {
			
			minOps[i][0]=str2.substring(0, i).length();
		}
		for(int i=1;i<=str2.length();i++) {
			for(int j=1;j<=str1.length();j++) {
				if(str1.charAt(j-1)==str2.charAt(i-1)) {
					minOps[i][j]=minOps[i-1][j-1];
				}else {
					minOps[i][j]=Math.min(minOps[i-1][j], Math.min(minOps[i-1][j-1], minOps[i][j-1]))+1;
				}
			}
		}
		int i=str2.length();
		int j=str1.length();
		while(i>0 && j>0) {
			if(str1.charAt(j-1)==str2.charAt(i-1)) {
				System.out.println(str1.charAt(j-1)+" retained");
				i=i-1;
				j=j-1;
			}else {
				int minIndex=0;
				int min = minOps[i][j];
				if(minOps[i-1][j]<min) {
					min=minOps[i-1][j];
					minIndex=1;
				}else if(minOps[i-1][j-1]<min) {
					min=minOps[i-1][j-1];
					minIndex=2;
				}else {
					min=minOps[i][j-1];
					minIndex=3;
				}
				switch(minIndex) {
				case 1: System.out.println(str2.charAt(i-1)+" deleted");
						i=i-1;
						break;
				case 2: System.out.println(str1.charAt(j-1)+" -> "+str2.charAt(i-1));
						i=i-1;
						j=j-1;
						break;
				case 3: System.out.println(str1.charAt(j-1)+" deleted");
						j=j-1;
						break;
				default: System.out.println("error");
				}
			}
		}
		return minOps[str2.length()][str1.length()];
	}

}
