package perg4;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg4 {
	
	protected static final int NUMBER_TASK=10;
	protected static final int NUMBER_THREAD=10;

	public static void main(String[] args) {
		ArrayBlockingQueue<Double> numbers=new ArrayBlockingQueue<>(NUMBER_TASK);
		Random r=new Random();
		
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);
		
		for(int i = 1; i <= NUMBER_TASK ; i++){
			executor.submit(new CalculateSquare(numbers));
		}
		
		executor.shutdown();
		
		while(true){
			try {
				numbers.put(100* r.nextDouble());
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}	
		}	
	}
}