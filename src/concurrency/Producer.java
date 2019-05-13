package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
	
	BlockingQueue<Integer> q;
	Integer i=1;
	
	public Producer(BlockingQueue<Integer> q) {
		this.q = q;
	}

	public void run() {
		synchronized (i) {
			
		try {
			
			q.put(i);
			System.out.println("Putting "+i);
			i++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
