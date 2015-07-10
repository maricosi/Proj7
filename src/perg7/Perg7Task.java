package perg7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Perg7Task implements Runnable {

	private int task;
	private CyclicBarrier barrier;
	

	public Perg7Task(int task, CyclicBarrier barrier ) {
		this.barrier= barrier;
		this.task=task;
	}

	@Override
	public void run() {
		
		while(true){
			try {
				Thread.sleep(1000);
				System.out.println("I am thread " + Thread.currentThread().getId() +". I do " + task);
				barrier.await();
			} catch (BrokenBarrierException | InterruptedException e) {
				System.out.println(e.getMessage());
			}	
		}
	}

}
