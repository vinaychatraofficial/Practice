package ae;

import java.util.ArrayList;

public class MinHeapConstruction {

	static class MinHeap {
	    ArrayList<Integer> heap = new ArrayList<Integer>();

	    public MinHeap(ArrayList<Integer> array) {
	      heap = buildHeap(array);
	    }

	    public ArrayList<Integer> buildHeap(ArrayList<Integer> array) {
	      for(int i=(array.size()-2)/2;i>=0;i--){
					siftDown(i,array.size()-1,array);
				}
				return array;
	    }

	    public void siftDown(int currentIdx, int endIdx, ArrayList<Integer> heap) {
	      int childOneIdx = 2*currentIdx+1;
				int childTwoIdx = 2*currentIdx+2;
				int idxToSwap = -1;
				while(childOneIdx<=endIdx){
					if(childTwoIdx<=endIdx){
						if(heap.get(childTwoIdx)<heap.get(childOneIdx))
							idxToSwap = childTwoIdx;
						else
							idxToSwap = childOneIdx;
					}else if(childOneIdx<=endIdx){
						idxToSwap = childOneIdx;
					}else{ //this can never occur because it is checked in while condition itself
						return;
					}
					
					if(heap.get(currentIdx)>heap.get(idxToSwap)){
						swap(currentIdx,idxToSwap,heap);
						currentIdx = idxToSwap;
						childOneIdx = 2*currentIdx+1;
						childTwoIdx = 2*currentIdx+2;
					}else{
						return;
					}
				}

	    }

	    public void siftUp(int currentIdx, ArrayList<Integer> heap) {
	      int parent = (currentIdx-1)/2;
				while(currentIdx>0 && heap.get(currentIdx)<heap.get(parent)){
					swap(currentIdx,parent, heap);
					currentIdx = parent;
					parent = (currentIdx-1)/2;
				}
				
	    }

	    public int peek() {
	      return heap.get(0);
	    }

	    public int remove() {
	      swap(0,heap.size()-1,heap);
				int elem = heap.remove(heap.size()-1);
				siftDown(0,heap.size()-1,heap);
				return elem;
	    }

	    public void insert(int value) {
	      heap.add(value);
				siftUp(heap.size()-1,heap);
	    }
			
			private void swap(int i, int j, ArrayList<Integer> heap){
				int temp = heap.get(i);
				heap.set(i,heap.get(j));
				heap.set(j,temp);
			}
	  }
}
