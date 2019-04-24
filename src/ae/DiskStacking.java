package ae;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DiskStacking {

	public static ArrayList<Integer[]> diskStacking(ArrayList<Integer[]> disks) {
		Collections.sort(disks,new Comparator<Integer[]>(){
			public int compare(Integer[] disk1, Integer[] disk2){
				return Integer.compare(disk1[2],disk2[2]);
			}
		});
		int[] heights = new int[disks.size()];
		int[] prev = new int[disks.size()];

		Arrays.fill(prev,-1);

		int maxIndex=0;

		for(int i=0;i<disks.size();i++){
			heights[i] = disks.get(i)[2];
			if(heights[i] > maxIndex)
				maxIndex = i;
		}



		for(int i=1;i<disks.size();i++){
			for(int j=0;j<i;j++){
				if(disks.get(i)[0] > disks.get(j)[0] &&  disks.get(i)[1] > disks.get(j)[1] &&
						disks.get(i)[2] > disks.get(j)[2] && (heights[j]+disks.get(i)[2] > heights[i])){
					heights[i] = heights[j]+disks.get(i)[2];
					prev[i] = j;
				}

				if(heights[i] > heights[maxIndex]){
					maxIndex = i;
				}
			}
		}

		//System.out.println("maxIndex:"+maxIndex+" maxHeight:"+heights[maxIndex]);
		int index = maxIndex;
		ArrayList<Integer[]> res = new ArrayList<>();
		while(index!=-1){
			//System.out.println("adding:"+index);
			res.add(0,disks.get(index));
			index = prev[index];
		}

		return res;
	}
}
