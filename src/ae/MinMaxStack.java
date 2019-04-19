package ae;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStack {
	
	List<Integer> list = new ArrayList<>();
	List<Integer> minList = new ArrayList<>();
	List<Integer> maxList = new ArrayList<>();

	public Integer peek() {
		return list.get(list.size()-1);
	}

	public Integer pop() {
		Integer elem = list.remove(list.size()-1);
		minList.remove(minList.size()-1);
		maxList.remove(maxList.size()-1);
		return elem;
	}


	public void push(Integer number) {
		list.add(number);
		maxList.add(!maxList.isEmpty() ? Math.max(number, maxList.get(maxList.size()-1)):number);
		minList.add(!minList.isEmpty() ? Math.min(number,minList.get(minList.size()-1)):number);
	}


	public Integer getMin() {
		return minList.get(minList.size()-1);
	}


	public Integer getMax() {
		return maxList.get(maxList.size()-1);
	}
}
