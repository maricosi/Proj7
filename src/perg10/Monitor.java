package perg10;



public class Monitor {

	private ImplementLock lock = new ImplementLock();;
	
	
	public void enter(){
		
		lock.lock();
		System.out.println("MOnitor: Ask for permission: " + Thread.currentThread().getId());
		

	}
	
	public void leave(){
		System.out.println("Monitor: Stop to Do the task: " + Thread.currentThread().getId() + "\n");
		lock.unlock();
	}

}
