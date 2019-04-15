package ae;

public class CaesarCypherEncryptor {

	public static String caesarCypherEncryptor(String str, int key) {
		StringBuilder sb = new StringBuilder();
    for(char ch:str.toCharArray()){
			char res = (char)((ch-97+key)%26 +97);
			sb.append(res);
		}
		return sb.toString();
  }
}
