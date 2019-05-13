package concurrency;

import java.util.List;
import java.util.concurrent.Semaphore;

public class ConsumerSemaphore implements Runnable {
	Semaphore s;
	List<Integer> shared;
	
	public ConsumerSemaphore(List<Integer> list, Semaphore s) {
		this.s=s;
		this.shared=list;
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s.release();
			Integer i = shared.remove(shared.size()-1);
			System.out.println("Taking "+i);
		}
	}

}
