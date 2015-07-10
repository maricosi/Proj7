package perg6b;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg6B {
	protected static final int NUMBER_TASK=5;
	protected static final int NUMBER_THREAD=5;
	
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);
		CountDownLatch count1 = new CountDownLatch(NUMBER_TASK-1);
		CountDownLatch count2 = new CountDownLatch(1);
		
		for(int i = 1; i <= NUMBER_TASK-1 ; i++){
			executor.submit(new Perg6Task1234(i, count1, count2));
		}
		
		executor.submit(new Perg6Task5(NUMBER_TASK, count1, count2));
		
		executor.shutdown();
	}

}
