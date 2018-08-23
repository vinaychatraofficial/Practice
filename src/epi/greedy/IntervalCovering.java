package epi.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author vcpaks
 * 17.3 Interval covering problem
 */
public class IntervalCovering {

	public static void main(String[] args) {
		Interval int1 = new Interval(1, 2);
		Interval int2 = new Interval(2, 3);
		Interval int3 = new Interval(3, 4);
		Interval int4 = new Interval(2, 3);
		Interval int5 = new Interval(3, 4);
		Interval int6 = new Interval(4, 5);
		List<Interval> intervals = new ArrayList<>();
		intervals.add(int1);
		intervals.add(int2);
		intervals.add(int3);
		intervals.add(int4);
		intervals.add(int5);
		intervals.add(int6);
		System.out.println(findMinCovering(intervals));
	}
	
	private static class Interval{
		int left, right;
		
		public Interval(int left, int right) {
			this.left=left;
			this.right=right;
		}
	}
	
	private static List<Integer> findMinCovering(List<Interval> intervals){
		List<Integer> minIntervals = new ArrayList<>();
		
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.compare(o1.right, o2.right);
			}
		});
		
		int numVisits=0;
		int lastValue=-1;
		
		
		for(Interval interval:intervals) {
			if(interval.left > lastValue) {
				numVisits++;
				lastValue=interval.right;
				minIntervals.add(lastValue);
			}
		}
		System.out.println("minVisits:"+numVisits);
		return minIntervals;
	}

}
