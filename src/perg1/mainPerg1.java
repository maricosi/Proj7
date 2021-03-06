package perg1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg1 {
	
	protected static final int NUMBER_TASK=8;
	protected static final int NUMBER_THREAD=2;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);
		
		for (int i = 1; i <= NUMBER_TASK ; i++){
			executor.submit(new Perg1Task(i));
		}
		executor.shutdown();
	}
}
