package epi.greedy;

/**
 * @author vcpaks
 * 17.6 Gasup problem
 */
public class Gasup {
	
	private static final int MILEAGE = 20;

	public static void main(String[] args) {
		int[] cities = {50,20,5,30,25,10,10};
		int[] dist = {900, 600, 200,400,600,200,100};
		System.out.println(getAmple(cities, dist));
	}
	
	private static int getAmple(int[] cities, int[] dist) {
		int remainingGas=0;
		int minGas = Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<cities.length;i++) {
			System.out.println("Remaining gas at "+i+" is "+remainingGas);
			if(remainingGas<minGas) {
				minGas = remainingGas;
				minIndex=i;
			}
			remainingGas += cities[i] - (dist[i]/MILEAGE);
		}
		System.out.println("Remaining gas at "+0+" is "+remainingGas);
		if(remainingGas<minGas) {
			minGas = remainingGas;
			minIndex=cities.length;
		}
		System.out.println(cities[minIndex]);
		return minIndex;
	}

}
