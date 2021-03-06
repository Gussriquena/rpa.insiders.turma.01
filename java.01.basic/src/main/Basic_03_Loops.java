package main;

public class Basic_03_Loops {
	
	public static void main(String[] args) {
		
		tabuada(5);
		
		String nome = "Gustavo,de,Oliveira,Riquena";
		
		char[] charSequence = nome.toCharArray();
		int[] numbers = {1, 2, 3, 4, 5, 6};
		double[] doubleNumbers = {1.0, 2.5, 3.3};
		boolean[] booleanValues = {true, false, false};
		String[] textValues = {"Gustavo", "Kris", "Diego"};
		
		// La?os de repeti??o
		
		// while
		int counter = 0;
		while(counter < charSequence.length) {
			//System.out.println(charSequence[counter]);
			counter++;
		}
		
		// Do while
		int counterDoWhile = 0;
		do {
			//System.out.println(charSequence[counterDoWhile]);
			counterDoWhile++;
		} while(counterDoWhile < charSequence.length);
		
		// FOR
		// declara??o; condi??o; incremento/decremento
		for(int counterFor=10; counterFor >= 0; counterFor--) {
			//System.out.println(counterFor);
		}
		
		for(int counterFor=0; counterFor < charSequence.length; counterFor++) {
			//System.out.println(charSequence[counterFor]);
		}
		
		// FOREACH - para cada
		// for(cada elemento : no objeto)
		for(char character : charSequence) {
			//System.out.println(character);
		}
		
		String[] splitingString = nome.split(",");
		
		for(String item : splitingString) {
			//System.out.println(item);
		}
	}
	
	public static void tabuada(int mainNumber) {
		int finalNumber = 10;
		
		for(int index=0; index < finalNumber; index++) {
			System.out.println(index + " x " + mainNumber + " = " + index*mainNumber);
		}
	}
}



