package epi.string;

/**
 * 6.3 Compute the spreadsheet column encoding
 * @author vcpaks
 *
 */
public class SpreadSheetColumnEncoding {

	public static void main(String[] args) {
		System.out.println(convertStringToDec("ZZ"));
		System.out.println(convertDecToString(702));
	}
	
	private static int convertStringToDec(String columnStr) {
		int result =0;
		for(int i=0;i<columnStr.length();i++) {
			result=result*26+columnStr.charAt(i)-'A'+1;
		}
		return result;
	}
	
	private static String convertDecToString(int number) {
		StringBuilder sb = new StringBuilder();
		while(number!=0) {
			sb.append((char)(Math.abs((number-1)%26)+'A'));
			number=(number-1)/26;
		}
		sb.reverse();
		return sb.toString();
	}

}
