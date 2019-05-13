package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ProducerConsumerSemaphoreMain {

	public static void main(String[] args) {
		int noOfThreads= 10;
		Semaphore s = new Semaphore(3);
		List<Integer> list = new ArrayList<>();
		ProducerSemaphore producer = new ProducerSemaphore(list,s);
		ConsumerSemaphore consumer = new ConsumerSemaphore(list,s);
		
		for(int i=0;i<noOfThreads;i++) {
			new Thread(producer).start();
			new Thread(consumer).start();
		}
	}

}
