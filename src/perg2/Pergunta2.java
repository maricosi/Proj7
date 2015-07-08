package perg2;

import java.util.concurrent.Semaphore;



public class Pergunta2 implements Runnable{

	private int numberOfThread;
	private static Semaphore [] semaphores= new Semaphore[8];

	public Pergunta2(int numberOftask) {
		this.numberOfThread = numberOftask;
	}
	
	static{
		for (int i = 0; i< semaphores.length; i++){
			if(i == 1){
				semaphores[i]=new Semaphore(1);
				
			}else {
				semaphores[i]=new Semaphore(0);
			}
			System.out.println(semaphores[i+2].toString());
		}
		
		
	}

	@Override
	public void run() {
		
		try {
			semaphores[numberOfThread-1].acquire();
		} catch (InterruptedException e) {
			e.getMessage();
		}
		System.out.println("Hello World, I am thread " + Thread.currentThread().getId() +" with task "+numberOfThread+".");
		
		if(numberOfThread % 2 == 0){
			semaphores[numberOfThread-2].release();		
		} else if (numberOfThread % 2 != 0){
			System.out.println(numberOfThread);
			System.out.println(semaphores[numberOfThread+2].toString());
			semaphores[numberOfThread+2].release();
			
			
		}
		
		
	}
	

}
