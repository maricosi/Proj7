package perg5;

import java.util.concurrent.Exchanger;


public class MainPerg5 {
	
	//protected static final int NUMBER_THREAD=2;

	public static void main(String[] args) {
		Exchanger<Boolean> exchanger = new Exchanger<>();
		
		/*ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREAD);
		executor.submit(new Perg5Thread(true, exchanger));
		executor.submit(new Perg5Thread(false, exchanger));
		*/
		
		Thread t1 = new Thread(new Perg5Thread(true,exchanger,"pong"));
		t1.start();
		Thread t2 = new Thread( new Perg5Thread(false, exchanger, "ping")); 
		t2.start();

	}

}
