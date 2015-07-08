package perg6a;

import java.util.concurrent.CountDownLatch;

public class Perg6 implements Runnable {

	private int task;
	private CountDownLatch counter;

	public Perg6(int task,CountDownLatch counter ) {
		this.counter= counter;
		this.task=task;
	}

	@Override
	public void run() {
		
		System.out.println("I am thread " + Thread.currentThread().getId() +". I do " + task);
		counter.countDown();
	}


}
