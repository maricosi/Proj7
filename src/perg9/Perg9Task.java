package perg9;



public class Perg9Task implements Runnable {

	private int task;
	private int priority;
	private Monitor monitor;


	public Perg9Task(int task, int priority , Monitor monitor) {
		this.task = task;
		this.priority = priority;
		this.monitor = monitor;
	}

	@Override
	public void run() {

		monitor.enter(priority);
		try {
			Thread.sleep(1000);
			System.out.println( "-------I do task " + task +" and I have priority " + priority + ".-------\n");
			monitor.leave();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

	}


}
