package ae;

public class MaxProfitWithKTransactions {

	//O(nk) time | O(n) space
	public static int maxProfitWithKTransactions(int[] prices, int k) {
		if(prices.length==0 || k==0)
			return 0;
		int[] profit = new int[prices.length];
		int[] prev = new int[prices.length];

		//profit with 0 transactions is 0
		for(int i=0;i<prices.length;i++)
			prev[i]=0;		

		for(int i=1;i<=k;i++){
			int prevMax = -prices[0];
			for(int j=1;j<prices.length;j++){
				int withoutThisDay = profit[j-1];
				int maxWithDay = prevMax + prices[j];
				profit[j] = Math.max(withoutThisDay,maxWithDay);
				prevMax = Math.max(prevMax, -prices[j] + prev[j]);
				System.out.print(profit[j]+" ");
			}
			System.out.println();
			prev = profit.clone();
		}
		System.out.println(profit[prices.length-1]);
		return profit[prices.length-1];
	}

	//O(nk) time | O(nk) space
	public static int maxProfitWithKTransactions1(int[] prices, int k) {
		if(prices.length==0 || k==0)
			return 0;
		int[][] profit = new int[k+1][prices.length];

		//profit with 0 transactions is 0
		for(int i=0;i<prices.length;i++)
			profit[0][i]=0;

		//first day profit is always 0
		for(int i=0;i<=k;i++)
			profit[i][0]=0;


		for(int i=1;i<=k;i++){
			int prevMax = -prices[0];
			for(int j=1;j<prices.length;j++){
				int withoutThisDay = profit[i][j-1];
				int maxWithDay = prevMax + prices[j];
				profit[i][j] = Math.max(withoutThisDay,maxWithDay);
				prevMax = Math.max(prevMax, -prices[j] + profit[i-1][j]);
			}
		}
		System.out.println(profit[k][prices.length-1]);
		return profit[k][prices.length-1];
	}

	//O(n^2*k) time | O(nk) space
	public static int maxProfitWithKTransactions2(int[] prices, int k) {
		if(prices.length==0 || k==0)
			return 0;
		int[][] profit = new int[k+1][prices.length];

		//profit with 0 transactions is 0
		for(int i=0;i<prices.length;i++)
			profit[0][i]=0;

		//first day profit is always 0
		for(int i=0;i<=k;i++)
			profit[i][0]=0;

		for(int i=1;i<=k;i++){
			for(int j=1;j<prices.length;j++){
				int withoutThisDay = profit[i][j-1];
				int maxWithDay = Integer.MIN_VALUE;
				for(int l=0;l<j;l++){
					maxWithDay = Math.max(maxWithDay,prices[j]-prices[l]+profit[i-1][l]);
				}
				profit[i][j] = Math.max(withoutThisDay,maxWithDay);
			}
		}
		System.out.println(profit[k][prices.length-1]);
		return profit[k][prices.length-1];
	}
}
