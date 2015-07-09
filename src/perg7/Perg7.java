package perg7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Perg7 implements Runnable {

	private int task;
	private CyclicBarrier barrier;
	

	public Perg7(int task, CyclicBarrier barrier ) {
		this.barrier= barrier;
		this.task=task;
	}

	@Override
	public void run() {
		
		while(true){
			System.out.println("I am thread " + Thread.currentThread().getId() +". I do " + task);
			try {
				barrier.await();
			} catch (BrokenBarrierException | InterruptedException e) {
				System.out.println(e.getMessage());
			}	
		}
	}


}
