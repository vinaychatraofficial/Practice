package dp;

import java.util.ArrayList;
import java.util.List;

public class MinWeightPathTriangle {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> one = new ArrayList<>();
		one.add(2);
		list.add(new ArrayList(one));
		one = new ArrayList<>();
		one.add(4);
		one.add(4);
		list.add(new ArrayList(one));
		one = new ArrayList<>();
		one.add(8);
		one.add(5);
		one.add(6);
		list.add(new ArrayList(one));
		one = new ArrayList<>();
		one.add(4);
		one.add(2);
		one.add(6);
		one.add(2);
		list.add(new ArrayList(one));
		one = new ArrayList<>();
		one.add(1);
		one.add(5);
		one.add(2);
		one.add(3);
		one.add(4);
		list.add(new ArrayList(one));
		int path = findMinWeightPath(list);
		System.out.println(path);
	}

	private static int findMinWeightPath(ArrayList<ArrayList<Integer>> list) {
		List<Integer> cur = new ArrayList<>();
		ArrayList<ArrayList<Integer>> parent = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(-1);
		parent.add(temp);
		List<Integer> prev;
		cur = list.get(0);
		prev=cur;
		
		for(int i=1;i<list.size();i++) {
			temp = new ArrayList(list.get(i));
			cur = new ArrayList(list.get(i));
			cur.set(0, cur.get(0)+prev.get(0));
			temp.set(0,0);
			//System.out.println("i:"+i+":"+cur.size()+":"+list);
			for(int j=1;j<cur.size()-1;j++) {
				int min = Integer.MAX_VALUE;
				int minIndex=0;
				if(prev.get(j-1)<min) {
					minIndex = j-1;
					min = prev.get(j-1);
				}
				if(prev.get(j)<min) {
					minIndex = j;
					min = prev.get(j);
				}
				cur.set(j, cur.get(j)+Math.min(prev.get(j-1), prev.get(j)));
				temp.set(j,minIndex);
			}
			cur.set(cur.size()-1, cur.get(cur.size()-1)+prev.get(prev.size()-1));
			temp.set(cur.size()-1,prev.size()-1);
			prev=cur;
			parent.add(temp);
		}
		int min = Integer.MAX_VALUE;
		int minIndex=0;
		for(int i=0;i<cur.size();i++) {
			if(cur.get(i)<min) {
				min=cur.get(i);
				minIndex=i;
			}
		}
		for(int j=list.size()-1;j>=0;j--) {
			System.out.print(list.get(j).get(minIndex)+" ");
			minIndex = parent.get(j).get(minIndex);
		}
		System.out.println();
		return min;
	}

}
