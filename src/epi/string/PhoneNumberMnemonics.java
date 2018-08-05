package epi.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcpaks
 * 6.7 Compute all mnemonics of a phone number
 */
public class PhoneNumberMnemonics {
	
	private final static String[] mappingMnemonics = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};

	public static void main(String[] args) {
		List<String> sequences = new ArrayList<>();
		String phNo = "9886511592";
		char[] partialSeq= new char[phNo.length()];
		computeSeq(phNo, 0, partialSeq, sequences);
		for(String sequence:sequences) {
			System.out.println(sequence);
		}
		System.out.println("Total sequences="+sequences.size());
	}
	
	private static void computeSeq(String phNo, int digit, char[] partialSeq, List<String> sequences) {
		if(digit==phNo.length()) {
			sequences.add(new String(partialSeq));
		}else {
			for(int i=0;i<mappingMnemonics[Integer.parseInt(""+phNo.charAt(digit))].length();i++) {
				partialSeq[digit]=mappingMnemonics[Integer.parseInt(""+phNo.charAt(digit))].charAt(i);
				computeSeq(phNo, digit+1, partialSeq, sequences);
			}
		}
	}

}
