package concurrency;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
	BlockingQueue<Integer> q;
	
	public Consumer(BlockingQueue<Integer> q) {
		this.q = q;
	}
	
	public void run() {
		synchronized (this) {
			
		Integer i = null;
		try {
			Thread.sleep(3000);
			i = q.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Taking "+i);
		}
	}

}
