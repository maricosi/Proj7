package perg9;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Monitor {

	private int numberOFTask=0;
	private PriorityQueue<Perg9Task> priorities = new PriorityQueue<Perg9Task>(new Comparator<Perg9Task>() {
		public int compare(Perg9Task x, Perg9Task y) {
			if (x.getPriority() < y.getPriority()) return -1;
			if (x.getPriority() > y.getPriority()) return 1;
			if (x.getPriority() == y.getPriority()){
				if(x.getOrderNo() < y.getOrderNo()) return -1;
				if(x.getOrderNo() > y.getOrderNo()) return 1;
			}
			return 0;
		}
	});
	private int nextOrder = 1;

	public synchronized void enter(Perg9Task task){
		task.setOrderNo(nextOrder++);
		priorities.add(task);
		while(priorities.peek() != task || numberOFTask != 0){
			try {
				System.out.println("Thread: "+Thread.currentThread().getId() + 
						". Priotity: " + task.getPriority() );
				wait();
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
		numberOFTask++;
		priorities.poll();
	}

	public synchronized void leave(){
		numberOFTask--;
		notifyAll();
	}

}
