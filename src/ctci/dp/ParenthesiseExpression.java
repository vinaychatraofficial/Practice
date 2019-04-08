package ctci.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vcpaks
 * 9.11
 */
public class ParenthesiseExpression {

	public static void main(String[] args) {
		String exp = "1^0|0|1";
		//String exp = "1^0|0";
		//String exp = "1^0";
		boolean res = true;
		int ways = f(exp,res,0,exp.length()-1,new HashMap<>());
		System.out.println(ways);
	}
	
	public static int f(String exp,boolean res, int s, int e,Map<String,Integer> map) {
		String key = ""+res+s+e;
		if(map.containsKey(key))
			return map.get(key);
		
		if(s==e) {
			if(exp.charAt(s)=='1' && res)
				return 1;
			else if(exp.charAt(s)=='0'&& !res)
				return 1;
			return 0;
		}
		
		int ans=0;
		//if true has to be achieved use the following table
		if(res) {
			for(int i=s+1;i<=e;i=i+2) {
				char op = exp.charAt(i);
				if(op=='&') {
					ans+=f(exp, true, s, i-1, map)*f(exp, true, i+1, e, map);
				}else if(op=='|') {
					ans+=f(exp, true, s, i-1, map)*f(exp, true, i+1, e, map);
					ans+=f(exp, true, s, i-1, map)*f(exp, false, i+1, e, map);
					ans+=f(exp, false, s, i-1, map)*f(exp, true, i+1, e, map);
				}else if(op=='^') {
					ans+=f(exp, true, s, i-1, map)*f(exp, false, i+1, e, map);
					ans+=f(exp, false, s, i-1, map)*f(exp, true, i+1, e, map);
				}
			}
		}else { //if false to be achieved
			for(int i=s+1;i<=e;i=i+2) {
				char op = exp.charAt(i);
				if(op=='&') {
					ans+=f(exp, true, s, i-1, map)*f(exp, false, i+1, e, map);
					ans+=f(exp, false, s, i-1, map)*f(exp, true, i+1, e, map);
					ans+=f(exp, false, s, i-1, map)*f(exp, false, i+1, e, map);
				}else if(op=='|') {
					ans+=f(exp, false, s, i-1, map)*f(exp, false, i+1, e, map);
				}else if(op=='^') {
					ans+=f(exp, true, s, i-1, map)*f(exp, true, i+1, e, map);
					ans+=f(exp, false, s, i-1, map)*f(exp, false, i+1, e, map);
				}
			}
		
		}
		map.put(key, ans);
		return ans;
	}

}
