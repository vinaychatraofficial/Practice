package hash;

/**
 * prob 13 remove chars of a string present in another string	
 * @author vcprabha
 *
 */
public class RemoveCharsAnotherString {

	public static void main(String[] args) {
		String str1 = "milk";
		String str2 = "hello";
		System.out.println(removeChars(str1,str2));
	}

	private static String removeChars(String str1, String str2) {
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		java.util.Hashtable<Character, Integer> ht = new java.util.Hashtable<>();
		StringBuffer strBuffer = new StringBuffer();
		for(int i=0;i<arr1.length;i++){
			if(ht.get(arr1[i])==null)
				ht.put(arr1[i], 1);
		}
		
		for(int i=0;i<arr2.length;i++){
			if(ht.get(arr2[i])==null)
				strBuffer.append(arr2[i]);
		}
		return strBuffer.toString();
	}

}
