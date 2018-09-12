package epi.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author vcprabha
 * 10.4 Compute the k closest stars
 */
public class KClosestStars {

	public static void main(String[] args) {
		Star s1 = new Star(0, 0, 0);
		Star s2 = new Star(1, 1, 1);
		Star s3 = new Star(2, 3, 4);
		Star s4 = new Star(4, 5, 6);
		Star s5 = new Star(9, 5, 9);
		List<Star> stars = new ArrayList<>();
		stars.add(s1);
		stars.add(s2);
		stars.add(s3);
		stars.add(s4);
		stars.add(s5);
		List<Star> topK = kClosestStars(stars, 2);
		for(Star s:topK){
			System.out.println(s.x+" "+s.y+" "+s.z);
		}
	}
	
	private static class Star implements Comparable<Star>{
		int x;
		int y;
		int z;
		public Star(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		private double distance(){
			return Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z);
		}
		public int compareTo(Star o) {
			return Double.compare(o.distance(),this.distance());
		}
		
	}
	
	private static List<Star> kClosestStars(List<Star> input, int k){
		PriorityQueue<Star> maxHeap = new PriorityQueue<>();
		List<Star> result = new ArrayList<>();
		Iterator<Star> iter = input.iterator();
		
		while(iter.hasNext()){
			maxHeap.add(iter.next());
			if(maxHeap.size()>k)
				maxHeap.poll();
		}
		result = new ArrayList<>(maxHeap);
		Collections.sort((List<Star>) result);
		return result;
	}
	
	private static List<Star> kClosestStarsCom(List<Star> input, int k){
		PriorityQueue<Star> maxHeap = new PriorityQueue<>(new Comparator<Star>() {

			@Override
			public int compare(Star o1, Star o2) {
				return Double.compare(o2.distance(), o1.distance());
			}
		});
		List<Star> result = new ArrayList<>();
		Iterator<Star> iter = input.iterator();
		
		while(iter.hasNext()){
			maxHeap.add(iter.next());
			if(maxHeap.size()>k)
				maxHeap.poll();
		}
		result = new ArrayList<>(maxHeap);
		return result;
	}

}
