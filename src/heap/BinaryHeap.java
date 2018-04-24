package heap;

public class BinaryHeap {
	
	int count;
	int size;
	int[] data;
	
	public BinaryHeap(int size) {
		this.size = size;
		this.data = new int[size];
	}
	
	public void insertElement(int d) {
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
	
	public int deleteMax() {
		int top = this.data[0];
		this.data[0] = this.data[count-1];
		this.count--;
		percolateDown(0);
		return top;
	}
	
	private void heapifyArray(int[] arr, int n) {
		if(n>this.size) {
			this.data = new int[n];
			this.size=n;
		}
		for(int i=0;i<n;i++)
			this.data[i]=arr[i];
		this.count=n;
		
		for(int i=(n-1)/2;i>=0;i--)
			percolateDown(i);
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
		if(r<=count-1 && this.data[r]>this.data[max])
			max=r;
		
		int temp = this.data[i];
		if(max!=i) {
			this.data[i]=this.data[max];
			this.data[max]=temp;
			percolateDown(max);
		}
	}
	
	public void printArray() {
		for(int i=0;i<this.count;i++)
			System.out.print(this.data[i]+" ");
	}
	
	private void heapSort(int arr[], int n) {
		if(this.size<n) {
			this.data = new int[n];
			this.size=n;
		}
		for(int i=0;i<n;i++)
			this.data[i]=arr[i];
		this.count=n;
		
		//heapify array
		for(int i=(n-1)/2;i>=0;i--) {
			percolateDown(i);
		}
		
		System.out.println("Array after heapifying");
		this.printArray();
		
		//delete one by one and move it to end
		int tempCount = this.count;
		for(int i=0;i<tempCount;i++) {
			int temp = this.data[0];
			this.data[0]=this.data[this.count-1];
			this.data[this.count-1]=temp;
			this.count--;
			percolateDown(0);
		}
		this.count=n;
	}

	public static void main(String args[]) {
		BinaryHeap heap = new BinaryHeap(11);
		
		
		int[] data = {31, 10,16, 9, 8, 14, 12, 3,1, 5,7};
		for(int i=0;i<data.length;i++) {
			heap.data[i] = data[i];
		}
		heap.count=11;
		
		heap.insertElement(19);
		heap.printArray();
		
		System.out.println();
		
		heap.deleteMax();
		heap.printArray();
		
		System.out.println();
		BinaryHeap newHeap = new BinaryHeap(0);
		int arr[] = {1,2,3,5};
		newHeap.heapifyArray(arr, 4);
		newHeap.printArray();
		
		System.out.println("Heap sort");
		int[] arr1 = {3,2,1,6,7};
		BinaryHeap sortHeap = new BinaryHeap(0);
		sortHeap.heapSort(arr1, 5);
		System.out.println();
		sortHeap.printArray();
	}
	
	public static BinaryHeap initialize() {
		int arr[] = {6,2,1,7,3,4,5};
		BinaryHeap heap = new BinaryHeap(0);
		heap.heapifyArray(arr, 7);
		return heap;
	}
	

}
