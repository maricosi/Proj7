package perg8;

import java.util.LinkedList;
import java.util.List;

public class Monitor {

	private int numberOFThreads=0;
	private List<Long> idThreads = new LinkedList<>();
	
	
	public synchronized void enter(){
		idThreads.add(Thread.currentThread().getId());
		while(numberOFThreads != 0 || idThreads.get(0) != Thread.currentThread().getId()){
			try {
				wait();
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
		numberOFThreads++;
		System.out.println("Id Threads: " + idThreads);
		idThreads.remove(0);
	}
	
	public synchronized void leave(){
		numberOFThreads--;
		notifyAll();
	}

}
