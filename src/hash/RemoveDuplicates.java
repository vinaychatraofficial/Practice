package hash;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "hello";
		System.out.println(removeDuplicatesArr(str));
	}
	
	public static String removeDuplicates(String orgStr) {
		java.util.Hashtable<String, Integer> ht = new java.util.Hashtable<>();
		StringBuffer strBuff = new StringBuffer();
		for(int i=0;i<orgStr.length();i++) {
			String character = orgStr.substring(i, i+1);
			if(ht.get(character)==null) {
				ht.put(character, 0);
				strBuff.append(character);
			}
		}
		return strBuff.toString();
	}
	
	public static String removeDuplicatesArr(String orgStr) {
		int[] charArr = new int[26];
		StringBuffer strBuffer = new StringBuffer();
		for(int i=0;i<orgStr.length();i++) {
			char character = orgStr.charAt(i);
			int index = character - 'a';
			if(charArr[index]==0) {
				charArr[index]++;
				strBuffer.append(character);
			}
			
		}
		return strBuffer.toString();
	}

}
