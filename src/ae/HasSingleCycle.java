package ae;

public class HasSingleCycle {

	public static boolean hasSingleCycle(int[] array) {
		int cur = 0;
		int count = 1;

		while(count < array.length){
			cur = cur + array[cur];
			while(cur<0)
				cur = array.length+cur;
			cur = cur%array.length;
			System.out.println("visiting "+cur);
			if(cur==0){
				System.out.println("return false");
				return false;
			}
			count++;
		}
		cur = cur + array[cur];
		while(cur<0)
			cur = array.length+cur;
		cur = cur%array.length;
		return cur==0;
	}
}
