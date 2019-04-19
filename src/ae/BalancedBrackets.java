package ae;

import java.util.Stack;

public class BalancedBrackets {

	public static boolean balancedBrackets(String str) {
		Stack<Character> stack = new Stack<>();
		for(Character ch:str.toCharArray()){
			if(ch=='(' || ch=='[' || ch=='{')
				stack.push(ch);
			else{
				if(stack.size()==0)
					return false;
				char topCh = stack.pop();
				if(ch==')' && topCh!='(')
					return false;
				else if(ch=='}' && topCh!='{')
					return false;
				else if(ch==']' && topCh!='[')
					return false;	
			}
		}
		return stack.isEmpty();
	}
}
