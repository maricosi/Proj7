package perg9;



import java.util.PriorityQueue;

public class Monitor {

	private int numberOFTask=0;
	private PriorityQueue<Integer> priorities = new PriorityQueue<>();
	
	
	public synchronized void enter(int priority){
		
		priorities.add(priority);
		while(priorities.peek() != priority || numberOFTask != 0){
			try {
				
				wait();
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
		numberOFTask++;
		System.out.println("priorities : "+priorities);
		priorities.poll();
	}
	
	public synchronized void leave(){
		numberOFTask--;
		notifyAll();
	}

}
