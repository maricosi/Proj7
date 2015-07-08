package perg4;

import java.util.concurrent.ArrayBlockingQueue;

public class CalculateSquare implements Runnable {

	private ArrayBlockingQueue<Double> array;
	
	
	public CalculateSquare (ArrayBlockingQueue<Double> array)  {
		this.array=array;	
	}

	@Override
	public void run() {
		double squareOfNumber=-1;
		double number=-1;

		while(true){
			try {
				number=array.take();
				squareOfNumber=Math.sqrt(number);
			} catch (InterruptedException e) {
				e.getMessage();
			}
			System.out.format("Square of %.2f is %.3f . The thread is %d.%n", number,squareOfNumber,Thread.currentThread().getId());
		}
		
	}

}
