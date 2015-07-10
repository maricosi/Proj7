package perg2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mainPerg2 {
	
	protected static final int NUMBER_TASK=8;
	protected static final int NUMBER_THREAD=8;
	

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);
		
		for (int i = 1; i <= NUMBER_TASK ; i++){
			executor.submit(new Pergunta2(i));
		}
		executor.shutdown();
	}

}
