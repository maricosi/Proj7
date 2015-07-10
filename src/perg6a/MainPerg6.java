package perg6a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg6 {
	
	protected static final int NUMBER_TASK=4;
	protected static final int NUMBER_THREAD=5;
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);
		CountDownLatch count = new CountDownLatch(NUMBER_TASK);
		for(int i = 1; i <= NUMBER_TASK ; i++){
			executor.submit(new Perg6(i, count));
		}
		
		executor.submit(new Perg6Task5(NUMBER_TASK+1, count));
		
		executor.shutdown();
	}

}
