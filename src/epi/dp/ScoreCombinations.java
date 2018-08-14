package epi.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcpaks
 * 16.1 Count the number of score combinations
 */
public class ScoreCombinations {

	public static void main(String[] args) {
		List<Integer> scores = new ArrayList<>();
		scores.add(2);
		scores.add(3);
		scores.add(7);
		System.out.println(countScoreCombinations(scores, 12));
	}
	
	private static int countScoreCombinations(List<Integer> scores, int finalScore) {
		int[][] scoreArr = new int[scores.size()][finalScore+1];
		
		for(int i=0;i<scores.size();i++) {
			scoreArr[i][0]=1;
			for(int j=1;j<=finalScore;j++) {
				int withoutScore = i>=1?scoreArr[i-1][j]:0;
				int withScore = j>=scores.get(i)?scoreArr[i][j-scores.get(i)]:0;
				scoreArr[i][j] = withoutScore+withScore;
			}
		}
		
		return scoreArr[scores.size()-1][finalScore];
	}

}
