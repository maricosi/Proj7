package perg1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class mainPerg1 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for (int i = 1; i <= 8 ; i++){
			executor.submit(new Pergunta1(i));
		}
		executor.shutdown();
	}
}
