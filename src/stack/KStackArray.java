package stack;

public class KStackArray {
	int[] arr;
	int[] top;
	int[] next;
	int k,n,free;
	
	public KStackArray(int k, int n) {
		this.k=k;
		this.n=n;
		arr = new int[n];
		top = new int[k];
		next = new int[n];
		free=0;
		for(int i=0;i<n-1;i++)
			next[i]=i+1;
		next[n-1]=-1;
		for(int i=0;i<k;i++)
			top[i]=-1;
	}
	
	public void push(int data, int stack) {
		if(free==-1) {
			System.out.println("Stack is full");
			return;
		}
		
		int i=free;
		System.out.println("Pushing at "+i);
		free=next[i];
		arr[i]=data;
		next[i]=top[stack];
		top[stack]=i;
	}
	
	public int pop(int stack) {
		if(top[stack]==-1) {
			System.out.println("Stack is empty");
			return -1;
		}
		
		int i=top[stack];
		int data = arr[i];
		top[stack]=next[i];
		next[i]=free;
		free=i;
		return data;
	}

	public static void main(String[] args) {
		KStackArray ks = new KStackArray(3,10);
		ks.push(100, 0);
		ks.push(200, 1);
		ks.push(300, 0);
		ks.push(400, 2);
		System.out.println(ks.pop(0));
		System.out.println(ks.pop(1));
		System.out.println(ks.pop(2));
		System.out.println(ks.pop(0));
	}

}
