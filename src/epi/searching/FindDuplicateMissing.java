package epi.searching;

/**
 * @author vcprabha
 * 11.10 Find the duplicate and missing elements
 */
public class FindDuplicateMissing {

	public static void main(String[] args) {
		int[] arr = {3,0,5,2,5,4};
		findDuplicateMissing(arr);
	}
	
	private static void findDuplicateMissing(int[] arr){
		//find m xor t
		//xor array elements
		int mXorT=0;
		for(int i=0;i<arr.length;i++){
			//xor with array elements
			mXorT^=arr[i];
			//xor with elements from 0 to n-1
			mXorT^=i;
		}
		
		int leastSigBit = mXorT&(~(mXorT-1));
		//xor all array elements with this least significant bit
		int mXorTWithBit=0;
		for(int i=0;i<arr.length;i++){
			if((arr[i]&leastSigBit)!=0){
				mXorTWithBit^=arr[i];
			}
			if((i&leastSigBit)!=0){
				mXorTWithBit^=i;
			}
		}
		boolean found = false;
		
		//mXorTWithBit is either the missing element or duplicate element
		for(int i=0;i<arr.length;i++){
			if(arr[i]==mXorTWithBit){
				System.out.println("Duplicate element:"+mXorTWithBit);
				System.out.println("Missing element:"+(mXorTWithBit^mXorT));
				found=true;
				break;
			}
		}
		if(!found){
			System.out.println("Missing element:"+mXorTWithBit);
			System.out.println("Duplicate element:"+(mXorTWithBit^mXorT));
		}
	}

}
