package perg5;

import java.util.concurrent.Exchanger;

public class Perg5 implements Runnable {

	
	private Exchanger <String> exchanger;
    private String task;
	

	public Perg5( String task, Exchanger <String> exchanger ) {
		this.exchanger= exchanger;
		this.task=task;
	}

	@Override
	public void run() {
		
		while(true){
			System.out.println("I am thread " + Thread.currentThread().getId() +". I do " + task);
			try {
				this.task=exchanger.exchange(task);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

}
