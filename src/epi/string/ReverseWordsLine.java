package epi.string;

/**
 * @author vcpaks
 * 6.6 Reverse words in a sentence
 */
public class ReverseWordsLine {

	public static void main(String[] args) {
		char[] arr = "hi my name is vinay".toCharArray();
		reverseWords(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);

	}
	
	private static void reverseWords(char[] arr) {
		int start=0;
		int end=0;
		reverse(arr,start,arr.length-1);
		int count=0;
		int index=0;
		while(index<arr.length) {
			while(index<arr.length && arr[index]==' ') {
				index++;
			}
			start=index;
			while(index<arr.length && arr[index]!=' ') {
				index++;
			}
			end=index;
			reverse(arr, start, end-1);
			count++;
			/*if(count==3)
				break;*/
		}
	}
	
	private static void reverse(char[] arr, int start, int end) {
		while(start<end) {
			char temp = arr[end];
			arr[end--]=arr[start];
			arr[start++]=temp;
		}
	}

}
