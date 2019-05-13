package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ProducerConsumerWaitMain {

	public static void main(String[] args) {
		int noOfThreads= 10;
		List<Integer> list = new ArrayList<>();
		ProducerWait producer = new ProducerWait(list,3);
		ConsumerWait consumer = new ConsumerWait(list);
		
		for(int i=0;i<noOfThreads;i++) {
			new Thread(producer).start();
			new Thread(consumer).start();
		}
	}

}
