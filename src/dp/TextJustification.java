package dp;

public class TextJustification {

	public static void main(String[] args) {
		String[] words = {"Tushar","Roy","likes","to","code"};
		int lineLength = 10;
		int length = justifyText(words, lineLength);
		System.out.println(length);
	}

	private static int justifyText(String[] words, int lineLength) {
		int[] messiness = new int[words.length];
		int blanks = lineLength - words[0].length();
		messiness[0] = blanks*blanks;
		for(int i=1;i<words.length;i++) {
			blanks = lineLength - words[i].length();
			messiness[i] = messiness[i-1] + blanks*blanks;
			for(int j=i-1;j>=0;j++) {
				blanks = blanks - (words[j].length()+1);
				if(blanks<0) {
					break;
				}
				int prevMessiness = j-1>=0?messiness[j-1]:0;
				int curMessiness = blanks*blanks;
				messiness[i] = Math.min(messiness[i], prevMessiness+curMessiness);
			}
		}
		return messiness[words.length-1];
	}

}
