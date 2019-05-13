package concurrency;

import java.util.List;
import java.util.concurrent.Semaphore;

public class ConsumerWait implements Runnable {
	List<Integer> shared;
	
	public ConsumerWait(List<Integer> list) {
		this.shared=list;
	}

	@Override
	public void run() {
		synchronized (shared) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(shared.size()==0)
				try {
					shared.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("Removed "+shared.remove(0));
			shared.notifyAll();
		}
	}

}
