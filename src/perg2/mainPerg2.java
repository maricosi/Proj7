package perg2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mainPerg2 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(8);

		for (int i = 1; i <= 8 ; i++){
			executor.submit(new Pergunta2(i));
		}
		executor.shutdown();
	}

}
