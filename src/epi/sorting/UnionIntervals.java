package epi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author vcpaks
 * 13.7 Compute the union of intervals
 */
public class UnionIntervals {

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<>();
		
		input.add(new Interval(new Endpoint(16,false),new Endpoint(17,false)));
		input.add(new Interval(new Endpoint(13,false),new Endpoint(15,false)));
		input.add(new Interval(new Endpoint(12,false),new Endpoint(16,true)));
		input.add(new Interval(new Endpoint(12,true),new Endpoint(14,true)));
		input.add(new Interval(new Endpoint(9,false),new Endpoint(11,true)));
		input.add(new Interval(new Endpoint(8,true),new Endpoint(11,false)));
		input.add(new Interval(new Endpoint(7,true),new Endpoint(8,false)));
		input.add(new Interval(new Endpoint(5,true),new Endpoint(7,false)));
		input.add(new Interval(new Endpoint(3,true),new Endpoint(4,false)));
		input.add(new Interval(new Endpoint(2,true),new Endpoint(4,true)));
		input.add(new Interval(new Endpoint(1,true),new Endpoint(1,true)));
		input.add(new Interval(new Endpoint(0,false),new Endpoint(3,false)));
		
		List<Interval> result = union(input);
		System.out.println("Final result:");
		for(Interval i:result) {
			System.out.println(i.start.value+":"+i.start.closed+","+i.end.value+":"+i.end.closed);
		}
	}
	
	public static class Interval implements Comparable<Interval>{
		Endpoint start;
		Endpoint end;
		
		public Interval(Endpoint start, Endpoint end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval i) {
			if(this.start.value!=i.start.value)
				return Integer.compare(this.start.value, i.start.value);
			
			return this.start.closed && !i.start.closed?-1:(!this.start.closed && i.start.closed)?1:0;
		}
		
		
	}
	
	public static class Endpoint{
		int value;
		boolean closed;
		
		public Endpoint(int value, boolean closed) {
			super();
			this.value = value;
			this.closed = closed;
		}
		
		
	}
	
	private static List<Interval> union(List<Interval> input){
		Collections.sort(input);
		for(Interval i:input) {
			System.out.println(i.start.value+":"+i.start.closed+","+i.end.value+":"+i.end.closed);
		}
		List<Interval> result = new ArrayList<>();
		Interval temp = input.get(0);
		int i=1;
		int n = input.size();
		while(i<n) {
			if(temp.end.value>input.get(i).start.value || (temp.end.value==input.get(i).start.value && (temp.end.closed || input.get(i).start.closed))) {
				if(temp.end.value<input.get(i).end.value || (temp.end.value==input.get(i).end.value && (!temp.end.closed && input.get(i).end.closed))) {
					temp.end = input.get(i).end;
				}
			}else {
				result.add(temp);
				temp = input.get(i);
			}
			i++;
		}
		result.add(temp);
		return result;
	}

}
