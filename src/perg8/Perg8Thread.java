package perg8;



public class Perg8Thread implements Runnable {

	private int task;
	private Monitor monitor;


	public Perg8Thread(int task, Monitor monitor) {
		this.task=task;
		this.monitor=monitor;
	}

	@Override
	public void run() {

		monitor.enter();
		try {
			Thread.sleep(1000);
			System.out.println("-----I am thread " + Thread.currentThread().getId() +". I do task " + task +".-------");
			monitor.leave();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

	}


}
