package perg5;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPerg5 {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		
		/*ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(new Perg5("pong", exchanger));
		executor.submit(new Perg5("ping", exchanger));*/
		
		Thread t1 = new Thread(new Perg5("ping",exchanger));
		t1.start();
		Thread t2 = new Thread( new Perg5("pong", exchanger)); 
		t2.start();


	}

}
