package epi.string;

/**
 * 6.4 Replace and remove characters
 * @author vcpaks
 *
 */
public class ReplaceAndRemove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] arr = {'a','c','d','b','b','c','a','f'};
		int finalSize = replaceAndRemove(arr, 7);
		System.out.println(finalSize);
		for(int i=0;i<finalSize;i++)
			System.out.print(arr[i]);
		
	}
	
	private static int replaceAndRemove(char[] arr,int size) {
		int index=0;
		int aCount=0;
		for(int i=0;i<size;i++) {
			if(arr[i]!='b')
				arr[index++]=arr[i];
			if(arr[i]=='a') {
				aCount++;
			}
		}
		
		int finalSize = index+aCount;
		int originalIndex=index-1;
		for(int i=finalSize-1;i>=0;i--) {
			if(arr[originalIndex]=='a') {
				arr[i--]='d';
				arr[i]='d';
			}else {
				arr[i]=arr[originalIndex];
			}
			originalIndex--;
		}
		return finalSize;
	}

}
