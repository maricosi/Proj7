package perg6b;

import java.util.concurrent.CountDownLatch;

public class Perg6Task1234 implements Runnable {

	private int task;
	private CountDownLatch counter1;
	private CountDownLatch counter2;
	

	public Perg6Task1234(int task, CountDownLatch counter1 , CountDownLatch counter2 ) {
		this.counter1= counter1;
		this.counter2= counter2;
		this.task=task;
	}

	@Override
	public void run() {
		try {
			counter2.await();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("I am thread " + Thread.currentThread().getId() +". I do " + task);
		counter1.countDown();
	}
}
