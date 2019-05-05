package ae;

import java.util.Arrays;

public class MinRewards {

	public static int minRewards(int[] scores) {
		int[] reward = new int[scores.length];
		if(scores.length==1)
			return 1;
		if(scores.length==0)
			return 0;
		Arrays.fill(reward,1);
		int left = 1;
		int right = scores.length-2;
		while(left<scores.length){
			if(scores[left]>scores[left-1])
				reward[left]=Math.max(reward[left],reward[left-1]+1);
			left++;
		}
		while(right>=0){
			if(scores[right]>scores[right+1])
				reward[right]=Math.max(reward[right],reward[right+1]+1);
			right--;
		}
		int sum=0;
		for(int i=0;i<reward.length;i++)
			sum+=reward[i];
		System.out.println(sum);
		return sum;
	}
}
