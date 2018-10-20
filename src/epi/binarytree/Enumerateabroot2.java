package epi.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcpaks
 * Enumerate numbers of the form a+b*(square root of 2)
 */
public class Enumerateabroot2 {

	public static void main(String[] args) {
		List<Double> result = findFirstK(8);
		System.out.println(result);
	}
	
	private static List<Double> findFirstK(int k) {
		List<Double> result = new ArrayList<>();
		result.add(0.0);
		int a=0,b=0;
		
		//Increment 1 and increment square root 2 for every result. Choose minimum
		for(int i=1;i<=k-1;i++) {
			Double first = result.get(a)+1;
			Double second = result.get(b)+Math.sqrt(2);
			if(first<second) {
				a++;
				result.add(first);
			}else if(first>second) {
				b++;
				result.add(second);
			}else {
				a++;
				b++;
				result.add(first);
			}
		}
		return result;
	}

}
