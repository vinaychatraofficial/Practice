package epi.sorting;

import java.util.ArrayList;
import java.util.List;

import epi.sorting.RenderCalendar.Event;

/**
 * @author vcprabha
 * 13.6 Merging intervals
 */
public class MergingIntervals {

	public static void main(String[] args) {
		Event e1 = new Event(-4,-1);
		Event e2 = new Event(0,2);
		Event e3 = new Event(3,6);
		Event e4 = new Event(7,9);
		Event e5 = new Event(11,12);
		Event e6 = new Event(14,17);
		List<Event> input = new ArrayList<>();
		input.add(e1);
		input.add(e2);
		input.add(e3);
		input.add(e4);
		input.add(e5);
		input.add(e6);
		List<Event> result = mergeIntervals(input,new Event(1,8));
		for(Event e:result)
			System.out.println(e.start+","+e.end);
	}
	
	public static class Event{
		int start;
		int end;
		
		public Event(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		
	}
	
	private static List<Event> mergeIntervals(List<Event> input,Event newInterval){
		int i=0;
		List<Event> result = new ArrayList<>();
		int n = input.size();
		//add all events occuring before
		while(i<n && input.get(i).end<newInterval.start){
			result.add(input.get(i));
			i++;
		}
		
		//merge intersecting intervals
		while(i<n && newInterval.end>=input.get(i).start){
			int start = Math.min(input.get(i).start, newInterval.start);
			int end = Math.max(input.get(i).end, newInterval.end);
			newInterval = new Event(start,end);
			i++;
		}
		result.add(newInterval);
		
		//add all events occuring later
		while(i<n){
			result.add(input.get(i));
			i++;
		}
		
		return result;
		
	}

}
