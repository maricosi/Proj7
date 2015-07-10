package perg9;

public class Perg9Task implements Runnable {

	private int task;
	private int priority;
	private int orderNo = -1;
	private Monitor monitor;


	public Perg9Task(int task, int priority , Monitor monitor) {
		this.task = task;
		this.priority = priority;
		this.monitor = monitor;
	}

	@Override
	public void run() {
		monitor.enter(this);
		try {
			Thread.sleep(1000);
			System.out.println( "-------I Thread: " + Thread.currentThread().getId() + ". I do task: " + task + 
					". I have priority: " + priority + ". Order nº: " + getOrderNo()+".-------\n");
			monitor.leave();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

	}

	public int getPriority() {
		return priority;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

}
