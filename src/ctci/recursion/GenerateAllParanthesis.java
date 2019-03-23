package ctci.recursion;

import java.util.ArrayList;

/**
 * 9.6
 * @author vcpaks
 *
 */
public class GenerateAllParanthesis {

	public static void main(String[] args) {
		int n=3;
		ArrayList<String> res = new ArrayList<>();
		genParanthesis(0,0,n,res,new StringBuilder());
		for(String str:res)
			System.out.println(str);

	}

	private static void genParanthesis(int left, int right, int n,ArrayList<String> res,StringBuilder sb) {
		if(left==n+1 || right==n+1 || right>left)
			return;
		
		if(left==n && right==n) {
			res.add(sb.toString());
			return;
		}
		
		if(left<n) {
			sb.append("(");
			left++;
			genParanthesis(left, right, n, res, sb);
			left--;
			sb.setLength(sb.length()-1);
		}
		
		if(right<n && right<left) {
			sb.append(")");
			right++;
			genParanthesis(left, right, n, res, sb);
			right--;
			sb.setLength(sb.length()-1);
		}
		
	}

}
