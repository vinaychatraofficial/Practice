package epi.string;

/**
 * 6.2 Convert a number from base b1 to b2
 * @author vcpaks
 *
 */
public class BaseConversion {

	public static void main(String[] args) {
		System.out.println(convertToBase("615", 7));
		System.out.println(convertFromBase(306, 13));
	}
	
	private static int convertToBase(String input,int b1) {
		boolean isNegative = false;
		if(input.startsWith("-"))
			isNegative=true;
		int result =0;
		for(int i=(isNegative?1:0);i<input.length();i++) {
			int digit = Character.isDigit(input.charAt(i))?input.charAt(i)-'0':input.charAt(i)-'A'+10;
			result = result*b1+digit;
		}
		if(isNegative)
			result = -result;
		return result;
	}
	
	private static String convertFromBase(int num,int b2) {
		boolean isNegative = false;
		StringBuilder sb = new StringBuilder();
		if(num==0)
			return "0";
		else if (num<0)
			isNegative = true;
		
		while(num!=0) {
			if(Math.abs(num%b2)<10)
				sb.append(Math.abs(num%b2));
			else
				sb.append((char)((Math.abs(num%b2)-10)+'A'));
			num=num/b2;
		}
		
		if(isNegative)
			sb.append("-");
		sb.reverse();
		return sb.toString();
	}

}
