package perg5;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg5 {

	public static void main(String[] args) {
		Exchanger<Boolean> exchanger = new Exchanger<>();
		
		/*ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(new Perg5Thread(true, exchanger));
		executor.submit(new Perg5Thread(false, exchanger));
		*/
		Thread t1 = new Thread(new Perg5Thread(true,exchanger,"pong"));
		t1.start();
		Thread t2 = new Thread( new Perg5Thread(false, exchanger, "ping")); 
		t2.start();


	}

}
