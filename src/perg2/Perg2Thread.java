package perg2;

import java.util.concurrent.Semaphore;

public class Perg2Thread implements Runnable{

	private int numberOfThread;
	private static Semaphore [] semaphores= new Semaphore[8];

	public Perg2Thread(int numberOftask) {
		this.numberOfThread = numberOftask;
	}

	static{
		for (int i = 0; i< semaphores.length; i++){
			if(i == 1){
				semaphores[i]=new Semaphore(1);

			}else {
				semaphores[i]=new Semaphore(0);
			}
		}		
	}

	@Override
	public void run() {
		try {
			semaphores[numberOfThread-1].acquire();
		} catch (InterruptedException e) {
			e.getMessage();
		}
		System.out.println("Hello World, I am thread " + Thread.currentThread().getId() +
				" with task "+numberOfThread+".");

		if(numberOfThread % 2 == 0){
			semaphores[numberOfThread-2].release();		
		} else if (numberOfThread % 2 != 0 && numberOfThread != (semaphores.length -1)){
			semaphores[numberOfThread+2].release();	
		}
	}

}
