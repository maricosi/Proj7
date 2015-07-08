package perg6a;

import java.util.concurrent.CountDownLatch;

public class Perg6Task5 implements Runnable {

	private int task;
	private CountDownLatch counter;

	public Perg6Task5(int task,CountDownLatch counter ) {
		this.counter= counter;
		this.task=task;
	}

	@Override
	public void run() {
		try {
			counter.await();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("I am thread " + Thread.currentThread().getId() +". I do " + task + ". I´m the last task.");
	}


}
