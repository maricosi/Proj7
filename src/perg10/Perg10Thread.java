package perg10;

public class Perg10Thread implements Runnable {

	private int task;
	private Monitor monitor;


	public Perg10Thread(int task, Monitor monitor) {
		this.task=task;
		this.monitor=monitor;
	}

	@Override
	public void run() {

		monitor.enter();
		try {
			System.out.println("-----I am thread " + Thread.currentThread().getId() +". I do task " + task +".-------");
			Thread.sleep(500);
			monitor.leave();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

}
