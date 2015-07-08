package perg4;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg4 {

	public static void main(String[] args) {
		ArrayBlockingQueue<Double> numbers=new ArrayBlockingQueue<>(10);
		Random r=new Random();
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		for(int i = 1; i <= 10 ; i++){
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
