package perg5;

import java.util.concurrent.Exchanger;

public class Perg5Thread implements Runnable {

	private Exchanger <Boolean> exchanger;
    private boolean change;
    private String task;
    
	public Perg5Thread( boolean change, Exchanger <Boolean> exchanger , String task ) {
		this.exchanger= exchanger;
		this.change=change;
		this.task=task;
	}

	@Override
	public void run() {
		
		while(true){
			try {
				this.change=exchanger.exchange(change);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			if(change){
				System.out.println("I am thread " + Thread.currentThread().getId() +". I do "+task+".");	
			}
		}
	}
	
}
