package ctci.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StackBoxes {

	public static void main(String[] args) {
		ArrayList<Box> boxes = new ArrayList<>();
		Map<Box,ArrayList<Box>> dpMap = new HashMap<>();
		for(int i=0;i<4;i++) {
			Box b = new Box(i,i+1,i+2);
			boxes.add(b);
		}
		
		ArrayList<Box> maxStack = new ArrayList<>();
		for(int i=0;i<boxes.size();i++) {
			//System.out.println("Checking for box --"+boxes.get(i));
			ArrayList<Box> stack = getStack(boxes,boxes.get(i),dpMap);
			if(stack.size()>maxStack.size())
				maxStack = stack;
		}
		
		for(Box box:maxStack)
			System.out.println(box);
	}
	
	private static ArrayList<Box> getStack(ArrayList<Box> boxes, Box box, Map<Box, ArrayList<Box>> dpMap) {
		if(dpMap.get(box)!=null) {
			//System.out.println("Returning for "+box);
			return dpMap.get(box);
		}
		
		ArrayList<Box> maxStack = new ArrayList<>();
		for(int i=0;i<boxes.size() && boxes.get(i)!=box;i++) {
			if(boxes.get(i).smallerThan(box)) {
				//System.out.println("Checking for box "+boxes.get(i));
				ArrayList<Box> prevStack = getStack(boxes, boxes.get(i),dpMap);
				if(prevStack.size()>maxStack.size())
					maxStack = prevStack;
			}
		}
		maxStack.add(box);
		dpMap.put(box, maxStack);
		return maxStack;
	}

	static class Box{
		int height;
		int width;
		int depth;
		
		public Box(int height, int width, int depth) {
			super();
			this.height = height;
			this.width = width;
			this.depth = depth;
		}
		
		public boolean smallerThan(Box other) {
			return this.height<other.height && this.width<other.width && this.depth<other.depth;
		}
		
		@Override
		public String toString() {
			return height+","+width+","+depth;
		}
		
	}

}
