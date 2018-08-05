package epi.string;

import org.omg.PortableInterceptor.InterceptorOperations;

/**
 * 6.1 String Integer conversion
 * @author vcpaks
 *
 */
public class StringInteger {

	public static void main(String[] args) {
		System.out.println(intToString(0));
		System.out.println(intToString(423));
		System.out.println(intToString(-321));
		
		System.out.println(stringToInt("0"));
		System.out.println(stringToInt("123"));
		System.out.println(stringToInt("-345"));
	}
	
	private static String intToString(int i) {
		StringBuilder sb = new StringBuilder();
		boolean isNegative = false;
		if(i<0)
			isNegative =true;
		else if(i==0) {
			sb.append("0");
			return sb.toString();
		}
		while(i!=0) {
			sb.append(Math.abs(i%10));
			i=i/10;
		}
		if(isNegative)
			sb.append('-');
		sb.reverse();
		return sb.toString();
	}
	
	private static int stringToInt(String s) {
		int result=0;
		boolean isNegative=false;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='-') {
				isNegative=true;
				continue;
			}
			result=result*10+(s.charAt(i)-'0');
		}
		if(isNegative)
			result = -result;
		return result;
	}

}
