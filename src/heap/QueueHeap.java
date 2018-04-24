package heap;


class NewQueueHeap{
	
	QueueElem[] elems;
	int size;
	int count;
	
	public NewQueueHeap(int size){
		this.size=size;
		this.elems = new QueueElem[this.size];
	}
	
	public void insertElement(QueueElem elem){
		if(this.count==this.size){
			QueueElem olddata[] = new QueueElem[this.size];
			for(int i=0;i<this.count;i++)
				olddata[i]=this.elems[i];
			this.elems=new QueueElem[this.size*2];
			for(int i=0;i<this.count;i++)
				this.elems[i]=olddata[i];
			this.size=this.size*2;
		}
			this.count++;
			int temp = this.count-1;
			while(temp>=1 && elem.priority<this.elems[(temp-1)/2].priority){
				this.elems[temp]=this.elems[(temp-1)/2];
				temp=(temp-1)/2;
			}
			this.elems[temp]=elem;
	}
	
	public QueueElem deleteMin(){
		QueueElem data = this.elems[0];
		this.elems[0]=this.elems[this.count-1];
		this.count--;
		percolateDown(0);
		return data;
	}
	
	public void percolateDown(int i) {
		int l=2*i+1;
		int r = 2*i+2;
		int min;
		if(l<=count-1 && this.elems[l].priority<this.elems[i].priority)
			min=l;
		else
			min=i;
		if(r<=count-1 && this.elems[r].priority<this.elems[min].priority)
			min=r;
		if(min!=i){
			QueueElem temp=this.elems[min];
			this.elems[min]=this.elems[i];
			this.elems[i]=temp;
			percolateDown(min);
		}
	}
	
	public void printArray(){
		for(int i=0;i<this.count;i++)
			System.out.print(this.elems[i].data+" ");
	}
	
}

class QueueElem{
	int data;
	int priority;
	
	public QueueElem(int data, int priority){
		this.data=data;
		this.priority=priority;
	}
}

public class QueueHeap {
	
	NewQueueHeap heap;
	int priority;
	
	public QueueHeap(){
		heap = new NewQueueHeap(1);
	}

	public static void main(String[] args) {
		QueueHeap q = new QueueHeap();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		System.out.println(q.deQueue());
		q.deQueue();
		q.deQueue();
		System.out.println(q.isEmpty());
	}
	
	public void enQueue(int data){
		heap.insertElement(new QueueElem(data,priority));
		priority++;
	}
	
	public int deQueue(){
		return heap.deleteMin().data;
	}
	
	public int size(){
		return heap.count;
	}
	
	public boolean isEmpty(){
		return heap.count==0;
	}

}
