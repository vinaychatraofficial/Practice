package heap;

class NewHeap{
	
	StackElement[] data;
	int count;
	int size;
	
	public NewHeap(int size){
		this.size = size;
		this.data = new StackElement[size];
	}
	
	public void insertElement(StackElement elem){
		if(this.count==this.size){
			StackElement olddata[] = new StackElement[this.size];
			for(int i=0;i<this.count;i++)
				olddata[i]=this.data[i];
			this.data=new StackElement[this.size*2];
			for(int i=0;i<this.count;i++)
				this.data[i]=olddata[i];
			this.size=this.size*2;
		}
			this.count++;
			int temp = this.count-1;
			while(temp>=1 && elem.priority<this.data[(temp-1)/2].priority){
				this.data[temp]=this.data[(temp-1)/2];
				temp=(temp-1)/2;
			}
			this.data[temp]=elem;
	}
	
	public StackElement deleteMin(){
		StackElement data = this.data[0];
		this.data[0]=this.data[this.count-1];
		this.count--;
		percolateDown(0);
		return data;
	}
	
	public void percolateDown(int i) {
		int l=2*i+1;
		int r = 2*i+2;
		int min;
		if(l<=count-1 && this.data[l].priority<this.data[i].priority)
			min=l;
		else
			min=i;
		if(r<=count-1 && this.data[r].priority<this.data[min].priority)
			min=r;
		if(min!=i){
			StackElement temp=this.data[min];
			this.data[min]=this.data[i];
			this.data[i]=temp;
			percolateDown(min);
		}
	}
	
	public void printArray(){
		for(int i=0;i<this.count;i++)
			System.out.print(this.data[i].data+" ");
	}
	
}

class StackElement{
	int data;
	int priority;
	
	public StackElement(int data, int priority){
		this.data=data;
		this.priority=priority;
	}
}

public class StackHeap {
	
	NewHeap heap;
	int priority;
	
	
	public StackHeap(){
		this.heap = new NewHeap(1);
	}

	public static void main(String[] args) {
		StackHeap s = new StackHeap();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.size());
		System.out.println(s.pop());
		System.out.println(s.top());
	}
	
	public void push(int data){
		heap.insertElement(new StackElement(data,priority));
		priority--;
	}
	
	public int pop(){
		return heap.deleteMin().data;
	}
	
	public int top(){
		return heap.data[0].data;
	}
	
	public int size(){
		return heap.count;
	}
	
	public boolean isEmpty(){
		return heap.count==0;
	}

}
