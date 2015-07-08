package perg6a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg6 {
	
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CountDownLatch count = new CountDownLatch(4);
		for(int i = 1; i <= 4 ; i++){
			executor.submit(new Perg6(i, count));
			
		}
		
		executor.submit(new Perg6Task5(5, count));
		
		executor.shutdown();
	}

}
