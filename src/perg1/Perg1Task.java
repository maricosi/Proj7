package perg1;



public class Perg1Task implements Runnable{

	private int numberOftask;
	

	public Perg1Task(int numberOftask) {
		this.numberOftask = numberOftask;
	}

	@Override
	public void run() {
		System.out.println("Hello World, I am thread " + Thread.currentThread().getId() +" running task " + numberOftask + ".");
		
	}
	

}
