package perg8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg8 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(8);
		Monitor monitor= new Monitor();

		for (int i = 1; i <= 8 ; i++){
			executor.submit(new Perg8Thread( i, monitor));
		}
		executor.shutdown();

	}

}
