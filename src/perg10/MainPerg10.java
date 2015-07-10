package perg10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg10 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Monitor monitor= new Monitor();

		for (int i = 1; i <= 10 ; i++){
			executor.submit(new Perg10Thread( i, monitor));
		}
		executor.shutdown();

	}

}
