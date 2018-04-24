package heap;

public class MinHeap {
	
	int[] data;
	int count;
	int size;
	
	public MinHeap(int size){
		this.size = size;
		this.data = new int[size];
	}
	
	public void insertElem(int data) {
		if(this.count==this.size) {
			int[] olddata = new int[this.count];
			for(int i=0;i<this.count;i++)
				olddata[i]=this.data[i];
			this.data=new int[this.size*2];
			this.size=this.size*2;
			for(int i=0;i<this.count;i++)
				this.data[i]=olddata[i];
		}
		this.count++;
		int temp = this.count-1;
		while(temp>1 && this.data[temp]<this.data[(temp-1)/2]) {
			this.data[temp]=this.data[(temp-1)/2];
			temp=(temp-1)/2;
		}
		this.data[temp]=data;
		System.out.println("inserting "+data);
	}
	
	private void heapifyArray(int[] arr, int n){
		if(this.size<n){
			data = new int[n];
			this.size=n;
		}
		
		for(int i=0;i<n;i++)
			this.data[i]=arr[i];
		
		this.count=n;
		for(int i=(this.count-1-1)/2;i>=0;i--){
			percolateDown(i);
		}
	}

	public void percolateDown(int i) {
		int l=2*i+1;
		int r = 2*i+2;
		int min;
		if(l<=count-1 && this.data[l]<this.data[i])
			min=l;
		else
			min=i;
		if(r<=count-1 && this.data[r]<this.data[min])
			min=r;
		if(min!=i){
			int temp=this.data[min];
			this.data[min]=this.data[i];
			this.data[i]=temp;
			percolateDown(min);
		}
	}
	
	public int deleteMin() {
		int data = this.data[0];
		this.data[0]=this.data[this.count-1];
		this.count--;
		percolateDown(0);
		return data;
	}
	
	public void printArray(){
		for(int i=0;i<this.count;i++)
			System.out.print(this.data[i]+" ");
	}
	
	public static MinHeap initialize(){
		int arr[] = {6,2,1,7,3,4,5};
		MinHeap heap = new MinHeap(0);
		heap.heapifyArray(arr, 7);
		//heap.printArray();
		return heap;
	}
	
	public static MinHeap initialize1(){
		int arr[] = {9,2,1,7,8};
		MinHeap heap = new MinHeap(9);
		heap.heapifyArray(arr, 5);
		//heap.printArray();
		return heap;
	}
	
	public static MinHeap initialize2(){
		int arr[] = {5,3,4,6};
		MinHeap heap = new MinHeap(0);
		heap.heapifyArray(arr, 4);
		//heap.printArray();
		return heap;
	}

	public static void main(String[] args) {
		int arr[] = {6,2,1,5,3,4,7};
		MinHeap heap = new MinHeap(0);
		heap.heapifyArray(arr, 7);
		heap.printArray();
	}

}
