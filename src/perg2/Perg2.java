package perg2;

import java.util.concurrent.Semaphore;

public class Perg2 implements Runnable{
	private int numberOftask;
	
	public Perg2(int numberOftask) {
		this.numberOftask = numberOftask;
	}

	@Override
	public void run() {

		System.out.println("Hello World, I am thread " + Thread.currentThread().getId() +" running task " + numberOftask + ".");


	}
}
