package ae;

public class LevenshteinDistance {
	
	public static void main(String[] args) {
		levenshteinDistance("abc","abc");
	}

	public static int levenshteinDistance(String str1, String str2) {
	    
		//return levenshteinDistanceOne(str1,str2);
		return levenshteinDistanceTwo(str1,str2);
  }
	
	public static int levenshteinDistanceOne(String str1, String str2) {
    int[][] dist = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<=str1.length();i++)
			dist[i][0]=i;
		for(int i=0;i<=str2.length();i++)
			dist[0][i]=i;
		for(int i=1;i<=str1.length();i++){
			for(int j=1;j<=str2.length();j++){
				if(str1.charAt(i-1)==str2.charAt(j-1))
					dist[i][j] = dist[i-1][j-1];
				else{
					dist[i][j] = 1+Math.min(dist[i-1][j-1],Math.min(dist[i][j-1],dist[i-1][j]));
				}
			}
		}
		return dist[str1.length()][str2.length()];
  }
	
	public static int levenshteinDistanceTwo(String str1, String str2) {
    int[] currDist = new int[str2.length()+1];
		int[] prevDist = new int[str2.length()+1];
		for(int i=0;i<=str2.length();i++)
			currDist[i]=i;
		prevDist = currDist.clone();
		for(int i=1;i<=str1.length();i++){
			currDist[0]=i;
			for(int j=1;j<=str2.length();j++){
				if(str1.charAt(i-1)!=str2.charAt(j-1))
					currDist[j] = 1+Math.min(prevDist[j-1],Math.min(currDist[j-1],prevDist[j]));
				else
					currDist[j] = prevDist[j-1];
			}
			prevDist = currDist.clone();
		}
		System.out.println(currDist[str2.length()]);
		return currDist[str2.length()];
  }
}
