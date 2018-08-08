package epi.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vcpaks
 * 6.9 Roman to decimal
 */
public class RomanInteger {
	
	private static final Map<Character,Integer> romanMap = new HashMap<Character,Integer>() {
		{
		put('I',1);
		put('V',5);
		put('X',10);
		put('L',50);
		put('C',100);
		put('D',500);
		put('M',1000);
		}
	};

	public static void main(String[] args) {
		System.out.println(convertRomanToDecimal("LIX"));
	}
	
	private static int convertRomanToDecimal(String romanStr) {
		int dec=0;
		for(int i=0;i<romanStr.length();i++) {
			int present = romanMap.get(romanStr.charAt(i));
			if(i==romanStr.length()-1) {
				dec=dec+present;
				break;
			}
			int next = romanMap.get(romanStr.charAt(i+1));
			if(present<next) {
				dec=dec+(next-present);
				i++;
			}else {
				dec=dec+present;
			}
		}
		return dec;
	}

}
