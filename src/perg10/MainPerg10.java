package perg10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg10 {
	
	protected static final int NUMBER_TASK=10;
	protected static final int NUMBER_THREAD=10;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);
		Monitor monitor= new Monitor();

		for (int i = 1; i <= NUMBER_TASK ; i++){
			executor.submit(new Perg10Thread( i, monitor));
		}
		executor.shutdown();

	}

}
