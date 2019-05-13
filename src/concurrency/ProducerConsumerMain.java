package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		BlockingQueue<Integer> q = new ArrayBlockingQueue<>(3);
		int noOfThreads= 10;
		Producer producer = new Producer(q);
		Consumer consumer = new Consumer(q);
		
		for(int i=0;i<noOfThreads;i++) {
			new Thread(producer).start();
			new Thread(consumer).start();
		}
	}

}
