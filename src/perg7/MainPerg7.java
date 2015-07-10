package perg7;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

;

public class MainPerg7 {
	
	protected static final int NUMBER_TASK=4;
	protected static final int NUMBER_THREAD=4;

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("All thread finish!!!!!!!!\n");
				
			}
		});
		
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);
		
		for(int i = 1; i <= NUMBER_TASK ; i++){
			executor.submit(new Perg7(i, barrier));
		}
		
		executor.shutdown();

	}

}
