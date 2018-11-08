package epi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author vcpaks
 * 13.5 Render a calendar
 */
public class RenderCalendar {

	public static void main(String[] args) {
		Event e1 = new Event(1,5);
		Event e2 = new Event(2,7);
		Event e3 = new Event(4,5);
		Event e4 = new Event(6,10);
		Event e5 = new Event(8,9);
		Event e6 = new Event(11,13);
		Event e7 = new Event(14,15);
		Event e8 = new Event(9,17);
		Event e9 = new Event(12,15);
		List<Event> input = new ArrayList<>();
		input.add(e1);
		input.add(e2);
		input.add(e3);
		input.add(e4);
		input.add(e5);
		input.add(e6);
		input.add(e7);
		input.add(e8);
		input.add(e9);
		System.out.println(findMaxEvents(input));
	}
	
	public static class Event{
		int start;
		int end;
		
		public Event(int start, int end) {
			this.start=start;
			this.end=end;
		}
	}
	
	public static class Endpoint implements Comparable<Endpoint>{

		int time;
		boolean isStart;
		
		@Override
		public int compareTo(Endpoint e) {
			if(this.time!=e.time) {
				return Integer.compare(this.time, e.time);
			}
			
			if(this.isStart && !e.isStart)
				return -1;
			else if(!this.isStart && e.isStart)
				return 1;
			else
				return 0;
		}
		
		public Endpoint(int time, boolean isStart) {
			this.time=time;
			this.isStart=isStart;
		}
		
	}
	
	private static int findMaxEvents(List<Event> events) {
		List<Endpoint> endpointList = new ArrayList<>();
		for(Event e:events) {
			endpointList.add(new Endpoint(e.start,true));
			endpointList.add(new Endpoint(e.end,false));
		}
		
		Collections.sort(endpointList);
		int max = 0,current = 0;
		for(Endpoint ep:endpointList) {
			if(ep.isStart) {
				current++;
				max=Math.max(current, max);
			}else {
				current--;
			}
		}
		return max;
	}

}

