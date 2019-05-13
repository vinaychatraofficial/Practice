package concurrency;

import java.util.List;
import java.util.concurrent.Semaphore;

public class ProducerSemaphore implements Runnable {
	
	List<Integer> shared;
	Integer i=0;
	Semaphore s;
	
	public ProducerSemaphore(List<Integer> list, Semaphore s) {
		this.shared = list;
		this.s=s;
	}

	@Override
	public void run() {
		synchronized (i) {
			
			try {
				s.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shared.add(i);
			System.out.println("Putting "+i);
			i++;
			
		}
	}

}
