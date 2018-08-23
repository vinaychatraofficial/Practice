package epi.greedy;

public class MakeChange {

	public static void main(String[] args) {
		int[] denominations = {100,50,25,10,5,1};
		System.out.println(makeChange(365, denominations));
		System.out.println(makeChangeRec(363, denominations, 0));
	}
	
	private static int makeChange(int totalCost, int[] denominations) {
		int numCoins=0;
		for(int i=0;i<denominations.length;i++) {
			numCoins += totalCost/denominations[i];
			totalCost = totalCost % denominations[i];
		}
		
		return numCoins;
	}
	
	private static int makeChangeRec(int totalCost, int[] denominations,  int i) {
		if(totalCost<=0)
			return 0;
		
		int presentCoins = totalCost/denominations[i];
		totalCost = totalCost % denominations[i];
		
		int totalCoins = presentCoins + makeChangeRec(totalCost, denominations, i+1);
		
		return totalCoins;
	}

}
