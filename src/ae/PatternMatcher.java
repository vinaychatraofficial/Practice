package ae;

public class PatternMatcher {

	public static String[] patternMatcher(String pattern, String str) {
		if(pattern.length()==0 || str.length()==0 || pattern.length()>str.length())
			return new String[]{};

		String finalPattern=null;
		if(pattern.charAt(0)=='x')
			finalPattern = pattern;
		else
			finalPattern = swapPattern(pattern);

		int[] arr = new int[3]; //count x, count y, pos y
		findPosAndCount(arr,finalPattern);
		System.out.println(arr[0]+":"+arr[1]+":"+arr[2]);

		if(arr[1]==0){//if only x's are present
			int lenX = str.length()/arr[0];
			String strX = str.substring(0,lenX);
			String match = generatePattern(strX,"",finalPattern);
			if(match.equals(str)){
				if(pattern.charAt(0)=='x')
					return new String[]{strX,""};
				else
					return new String[]{"",strX};
			}
		}else{//if both are present
			//try for all lengths of x
			for(int lenX=1;lenX<=str.length();lenX++){
				String strX = str.substring(0,lenX);
				int lenY = (str.length() - arr[0]*lenX)/arr[1];
				if(lenY<0)
					return new String[]{};
				String strY = str.substring(arr[2]*lenX,arr[2]*lenX+lenY);
				System.out.println(strX+", "+strY);
				String match = generatePattern(strX,strY,finalPattern);
				if(match.equals(str)){
					if(pattern.charAt(0)=='x')
						return new String[]{strX,strY};
					else
						return new String[]{strY,strX};
				}
			}
		}
		return new String[]{};
	}

	private static String generatePattern(String x, String y, String pattern){
		StringBuilder builder = new StringBuilder();
		for(char ch:pattern.toCharArray()){
			if(ch=='x') builder.append(x);
			else builder.append(y);
		}
		return builder.toString();
	}

	private static void findPosAndCount(int[] arr, String pattern){
		int countX=0;
		int countY=0;
		int posY=-1;
		int count=0;
		for(char ch:pattern.toCharArray()){
			if(ch=='x'){
				countX++;
			}else{
				countY++;
				if(posY==-1)
					posY=count;
			}
			count++;
		}
		arr[0]=countX;
		arr[1]=countY;
		arr[2]=posY;
	}

	private static String swapPattern(String str){
		StringBuilder builder = new StringBuilder();
		for(char ch:str.toCharArray()){
			if(ch=='x') builder.append('y');
			else builder.append('x');
		}
		return builder.toString();
	}
}
