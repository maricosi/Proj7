package perg2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MainPerg2test {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(8);

		ArrayList <Integer> tasks= new ArrayList<>();
		
		

		

		for (int i = 1; i <= 8 ; i++){
			executor.submit(new Perg2(i));
		}
		executor.shutdown();
	}



}
