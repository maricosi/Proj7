package perg3;

import java.util.concurrent.Callable;

public class ParallelCallabel implements Callable <Double> {

	private int numerofThread;
	private double number;
	
	public ParallelCallabel(int thread, double number2) {
		this.numerofThread=thread;
		this.number=number2;
	}

	@Override
	public Double call() throws Exception {
		return number;
	}
}