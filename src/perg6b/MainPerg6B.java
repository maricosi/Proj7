package perg6b;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg6B {
	
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CountDownLatch count1 = new CountDownLatch(4);
		CountDownLatch count2 = new CountDownLatch(1);
		
		for(int i = 1; i <= 4 ; i++){
			executor.submit(new Perg6(i, count1, count2));
		}
		
		executor.submit(new Perg6Task5(5, count1, count2));
		
		executor.shutdown();
	}

}
