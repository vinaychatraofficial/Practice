package epi.string;

/**
 * @author vcpaks
 * 6.10 Compute all valid IP addresses
 */
public class ValidIPs {

	public static void main(String[] args) {
		computeValidIP("19216811");
	}
	
	private static void computeValidIP(String str) {
		for(int i=1;i<4 && i<str.length();i++) {
			String first = str.substring(0, i);
			if(isValid(first)) {
				for(int j=1;j<4 && (i+j)<str.length();j++) {
					String second = str.substring(i,i+j);
					if(isValid(second)) {
						for(int k=1;k<4 && (i+j+k)<str.length();k++) {
							String third = str.substring(i+j, i+j+k);
							String fourth = str.substring(i+j+k);
							if(isValid(third) && isValid(fourth)) {
								System.out.println(first+"."+second+"."+third+"."+fourth);
							}
						}
					}
				}
			}
		}
	}

	private static boolean isValid(String ip) {
		if(ip.length()>3)
			return false;
		
		if(ip.startsWith("0") && ip.length()>1)
			return false;
		
		int ipInt = Integer.parseInt(ip);
		if(ipInt<0 || ipInt>255)
			return false;
		return true;
	}

}
