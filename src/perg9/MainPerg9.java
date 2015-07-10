package perg9;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg9 {

	protected static final int NUMBER_TASK=8;
	protected static final int NUMBER_THREAD=8;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);
		Monitor monitor= new Monitor();
		Random r = new Random();

		for (int i = 1; i <= NUMBER_TASK ; i++){
			int priority=r.nextInt(5);
			executor.submit(new Perg9Task(i, priority , monitor));
		}
		executor.shutdown();

	}

}
