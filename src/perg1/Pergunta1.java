package perg1;



public class Pergunta1 implements Runnable{

	private int numberOftask;
	

	public Pergunta1(int numberOftask) {
		this.numberOftask = numberOftask;
	}

	@Override
	public void run() {
		System.out.println("Hello World, I am thread " + Thread.currentThread().getId() +" running task " + numberOftask + ".");
		
	}
	

}
