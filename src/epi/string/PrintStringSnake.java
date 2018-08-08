package epi.string;

/**
 * @author vcprabha
 * 6.11
 */
public class PrintStringSnake {

	public static void main(String[] args) {
		String str = "Hello World!";
		char[] result = new char[str.length()];
		printString(str, result);
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]);
	}
	
	private static void printString(String str, char[] result){
		int index=0;
		for(int i=1;i<str.length();i=i+4){
			result[index++] = str.charAt(i);
		}
		
		for(int i=0;i<str.length();i=i+2){
			result[index++] = str.charAt(i);
		}
		
		for(int i=3;i<str.length();i=i+4){
			result[index++] = str.charAt(i);
		}
		

	}

}
