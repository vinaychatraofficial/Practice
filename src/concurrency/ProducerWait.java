package concurrency;

import java.util.List;
import java.util.concurrent.Semaphore;

public class ProducerWait implements Runnable {
	
	List<Integer> shared;
	Integer i=0;
	int maxSize;
	
	public ProducerWait(List<Integer> list, int maxSize) {
		this.shared = list;
		this.maxSize=maxSize;
	}

	@Override
	public void run() {
		synchronized (shared) {
			try {
				if(shared.size()==maxSize)
					shared.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shared.add(i);
			System.out.println("Added "+i);
			i++;
			shared.notifyAll();
		}
	}

}
