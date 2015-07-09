package perg7;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

;

public class MainPerg7 {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("All thread finish!!!!!!!!");
				
			}
		});
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		for(int i = 1; i <= 4 ; i++){
			executor.submit(new Perg7(i, barrier));
		}
		
		executor.shutdown();

	}

}
