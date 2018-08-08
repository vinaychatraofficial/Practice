package epi.string;

/**
 * @author vcpaks
 * 6.9 Decimal to Roman
 * I-1,V-5, X -10, L - 50, C-100, D-500,M-1000
 */
public class IntegerRoman {

	public static void main(String[] args) {
		System.out.println(convertIntegerToRoman(33));
	}
	
	private static String convertIntegerToRoman(int number) {
		StringBuilder sb = new StringBuilder();
		while(number!=0) {
			if(number>=1000) {
				updateDigits(number,1000,sb,'M');
				number = number%1000;
			}else if(number>=500) {
				if(number<900) {
					updateDigits(number, 500, sb, 'D');
					number=number%500;
				}else {
					sb.append("CM");
					number=number%900;
				}
			}else if(number>=100) {
				if(number<400) {
					updateDigits(number, 100, sb, 'C');
					number=number%100;
				}else {
					sb.append("CD");
					number=number%400;
				}
			}else if(number>=50) {
				if(number<90) {
					updateDigits(number, 50, sb, 'L');
					number=number%50;
				}else {
					sb.append("XC");
					number=number%90;
				}
			}else if(number>=10) {
				if(number<40) {
					updateDigits(number, 10, sb, 'X');
					number=number%10;
				}else {
					sb.append("XL");
					number=number%40;
				}
			}else if(number>=5) {
				if(number<9) {
					updateDigits(number, 5, sb, 'V');
					number=number%5;
				}else {
					sb.append("IX");
					number=number%9;
				}
			}else if(number>=1) {
				if(number<4) {
					updateDigits(number, 1, sb, 'I');
					number=number%1;
				}else {
					sb.append("IV");
					number=number%4;
				}
			}
		}
		return sb.toString();
	}

	private static void updateDigits(int number, int div, StringBuilder sb, char ch) {
		int n = number/div;
		for(int i=0;i<n;i++) {
			sb.append(ch);
		}
	}

}
