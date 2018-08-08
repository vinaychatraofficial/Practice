package epi.string;

/**
 * @author vcpaks
 * 6.8 Look and say
 */
public class LookAndSay {

	public static void main(String[] args) {
		System.out.println(lookAndSay(7));
	}
	
	private static String lookAndSay(int n) {
		String number = "1";
		if(n==1)
			return number;
		for(int i=2;i<=n;i++) {
			number = lookAndSay(number);
		}
		return number;
	}

	private static String lookAndSay(String number) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<number.length();i++) {
			int count=1;
			while((i+1)<number.length() && number.charAt(i)==number.charAt(i+1)) {
				count++;
				i++;
			}
			sb.append(count);
			sb.append(number.charAt(i));
		}
		return sb.toString();
	}

}
