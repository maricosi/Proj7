package perg3;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainPerg3 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Pergunta 3");

		System.out.print("Numbers of numbers:");
		int numberOfnumbers=sc.nextInt();

		System.out.println("*****Serie******");
		timeSerie(numberOfnumbers);

		System.out.println("*****Parallel******");
		timeParallel(numberOfnumbers);

	}

	public static void timeSerie (int number){
		ConjOfNumbers serie= new ConjOfNumbers(number);

		long startTime = System.nanoTime();

		System.out.println("MAximum: "+serie.getMax());	
		System.out.println("Minimum: "+serie.getMin());
		System.out.println("Average: "+serie.getAverage());

		long finishTime= System.nanoTime();

		System.out.println("Finish time: " +(finishTime-startTime)/1000000.0 + " ms");
	}

	public static void timeParallel (int number){
		final ConjOfNumbers serie= new ConjOfNumbers(number);
		ExecutorService executor = Executors.newFixedThreadPool(2);

		long startTime = System.nanoTime();
		
		//Maximum
		Future <Double> futureMax=executor.submit(new ParallelCallabel(0, serie.getMax()));
		
		//Minimum
		Future <Double> futureMin=executor.submit(new ParallelCallabel(1,serie.getMin()));
		executor.shutdown();
		
		//Average
		System.out.println("Average: "+serie.getAverage());

		long finishTime= System.nanoTime();
		
		try {
			System.out.println("Max: " +futureMax.get());
		} catch (InterruptedException | ExecutionException e) {
			e.getMessage();
		}
		
		try {
			System.out.println("Min: " +futureMin.get());
		} catch (InterruptedException | ExecutionException e) {
			e.getMessage();
		}
		
		System.out.println("Finish time: " +(finishTime-startTime)/1000000.0 + " ms");
	}
}
