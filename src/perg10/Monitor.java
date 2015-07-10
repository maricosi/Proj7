package perg10;



public class Monitor {

	private ImplementLock lock = new ImplementLock();;
	
	
	public void enter(){
		System.out.println("MOnitor:Ask for permission: " + Thread.currentThread().getId());
		lock.lock();

	}
	
	public void leave(){
		System.out.println("Monitor: Stop to Do the task: " + Thread.currentThread().getId());
		lock.unlock();
	}

}
