package epi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vcprabha
 * 16.11 Pretty printing problem
 */
public class PrettyPrinting {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("aaa");
		words.add("bbb");
		words.add("c");
		words.add("d");
		words.add("ee");
		//words.add("ff");
		//words.add("ggggggg");
		System.out.println(computeMessiness(11, words));
	}
	
	private static int computeMessiness(int lineLength, List<String> words){
		int wordSize = words.size();
		//messiness[i] is defined as the messiness upto word i
		int[] messiness = new int[wordSize];
		Arrays.fill(messiness, Integer.MAX_VALUE);
		
		int numBlanks =lineLength-words.get(0).length();
		messiness[0] = numBlanks*numBlanks;
		for(int i=1;i<wordSize;i++){
			numBlanks = lineLength-words.get(i).length();
			//i-1 must be optimally placed
			messiness[i]=messiness[i-1]+numBlanks*numBlanks;
			//check if previous words can be put into the current line
			for(int j=i-1;j>=0;j--){
				numBlanks = numBlanks-(words.get(j).length()+1);
				
				//cannot place jth word in the currentline
				if(numBlanks<0){
					break;
				}
				
				int currentLineMessiness = numBlanks*numBlanks;
				System.out.println("currentLineMessiness:"+currentLineMessiness);
				
				int firstJMessiness = j-1>=0?messiness[j-1]:0;
				System.out.println("messiness["+i+"]: Comparing "+messiness[i]+","+(firstJMessiness+currentLineMessiness));
				//j-1 must be optimally placed
				messiness[i]=Math.min(messiness[i], firstJMessiness+currentLineMessiness);
				
			}
		}
		
		for(int mess:messiness)
		System.out.println(mess);
		
		return messiness[wordSize-1];
	}

}
