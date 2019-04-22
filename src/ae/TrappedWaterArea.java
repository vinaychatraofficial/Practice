package ae;

public class TrappedWaterArea {

	public static int waterArea(int[] heights) {
		if(heights.length==0)
			return 0;
		int[] leftMax = new int[heights.length];
		int[] rightMax = new int[heights.length];
		leftMax[0]=0;
		rightMax[heights.length-1]=0;

		for(int i=1;i<heights.length;i++){
			leftMax[i] = Math.max(leftMax[i-1],heights[i-1]);
		}

		for(int i=heights.length-2;i>=0;i--){
			rightMax[i] = Math.max(rightMax[i+1],heights[i+1]);
		}

		int res=0;
		for(int i=0;i<heights.length;i++){
			int waterOnTop = Math.min(leftMax[i],rightMax[i]) - heights[i];
			if(waterOnTop < 0)
				waterOnTop=0;
			res+=waterOnTop;
		}
		return res;
	}
}
