package heap;

public class MinHeap {
	
	int[] data;
	int count;
	int size;
	
	public MinHeap(int size){
		this.size = size;
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

	public static void main(String[] args) {
		int arr[] = {6,2,1,5,3,4,7};
		MinHeap heap = new MinHeap(0);
		heap.heapifyArray(arr, 7);
		heap.printArray();
	}

}
