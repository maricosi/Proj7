package perg3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConjOfNumbers {

	private List<Double> numbers = new ArrayList<>();
	private int amountOfNumbers;
	private final static int MAXIMO=100;

	public ConjOfNumbers(int number){
		this.amountOfNumbers = number;
		Random random = new Random();
		for (int i = 0; i <= amountOfNumbers; i++ ){
			numbers.add((MAXIMO) * random.nextDouble());
		}	
	}

	public double getAverage(){
		double totalNumber=0;
		for(Double num : numbers){
			totalNumber=totalNumber+num;
		}
		return totalNumber/numbers.size();
	}


	public double getMin (){
		double numberMin=MAXIMO;
		for (Double num: numbers){
			if(num<numberMin){
				numberMin=num;
			}
		}
		return  numberMin;
	}
	
	public double getMax(){
		double numberMax=0;
		for (Double num: numbers){
			if(num>numberMax){
				numberMax=num;
			}
		}
		return  numberMax;
	}

}
