package epi.string;

public class RunLengthEncoding {

	public static void main(String[] args) {
		System.out.println(encode("aaaabcccaa"));
		System.out.println(decode("3e4f2e"));
	}
	
	private static String encode(String str) {
		StringBuilder sb  = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			int count=1;
			while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
				i++;
				count++;
			}
			
			sb.append(count);
			sb.append(str.charAt(i));
				
		}
		return sb.toString();
	}
	
	private static String decode(String str) {
		StringBuilder sb= new StringBuilder();
		int digit=0;
		for(int i=0;i<str.length();i++) {
			if(Character.isDigit(str.charAt(i))) {
				digit=digit*10+Integer.parseInt(""+str.charAt(i));
			}else {
				int count=digit;
				while(count>0) {
					sb.append(str.charAt(i));
					count--;
				}
				digit=0;
			}
		}
		return sb.toString();
	}

}
