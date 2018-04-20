package heap;

public class BinaryHeap {
	
	int count;
	int size;
	int[] data;
	
	public BinaryHeap(int size) {
		this.size = size;
		this.data = new int[size];
	}
	
	private void insertElement(int d) {
		if(this.count==this.size) {
			int[] temp = new int[size];
			for(int i=0;i<count;i++)
				temp[i]=this.data[i];
			
			this.data = new int[size*2];
			for(int i=0;i<this.count;i++)
				this.data[i]=temp[i];
			
			this.size=this.size*2;
		}
		
		this.count++;
		int temp=count-1;
		while(temp>=1 && d>this.data[(temp-1)/2]) {
			this.data[temp]=this.data[(temp-1)/2];
			temp=(temp-1)/2;
		}
		this.data[temp]=d;
		
	}
	
	private void deleteMax() {
		int top = this.data[0];
		this.data[0] = this.data[count-1];
		this.count--;
		percolateDown(0);
	}
	
	private void percolateDown(int i) {
		if(i>=count-1)
			return;
		int l = 2*i+1;
		int r = 2*i+2;
		int max;
		if(l<=count-1 && this.data[l]>this.data[i])
			max=l;
		else
			max=i;
		if(r<=count-1 && this.data[r]>max)
			max=r;
		
		int temp = this.data[i];
		if(max!=i) {
			this.data[i]=this.data[max];
			this.data[max]=temp;
			percolateDown(max);
		}
	}

	public static void main(String args[]) {
		BinaryHeap heap = new BinaryHeap(11);
		
		
		int[] data = {31, 10,16, 9, 8, 14, 12, 3,1, 5,7};
		for(int i=0;i<data.length;i++) {
			heap.data[i] = data[i];
		}
		heap.count=11;
		
		heap.insertElement(19);
		for(int i=0;i<heap.count;i++)
			System.out.print(heap.data[i]+" ");
		
		System.out.println();
		
		heap.deleteMax();
		for(int i=0;i<heap.count;i++)
			System.out.print(heap.data[i]+" ");
		
		
	}
	

}
