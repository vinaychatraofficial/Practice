package epi.greedy;

/**
 * @author vcprabha
 * 17.5 Find majority element
 */
public class FindMajorityElement {

	public static void main(String[] args) {
		char[] a = {'b','a','c','a','a','b','a','a','c','a'};
		System.out.println(findMajority(a));
	}
	
	private static char findMajority(char[] a){
		char elem = a[0];
		int count=1;
		for(int i=1;i<a.length;i++){
			if(count==0){
				elem = a[i];
				count=1;
			}else if(a[i]==elem){
				count++;
			}else{
				count--;
			}
				
		}
		return elem;
	}

}
