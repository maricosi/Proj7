package perg9;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class MainPerg9 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(8);
		Monitor monitor= new Monitor();
		Random r = new Random();

		for (int i = 1; i <= 8 ; i++){
			int priority=r.nextInt(1000);
			executor.submit(new Perg9Task( i, priority , monitor));
		}
		executor.shutdown();

	}

}
