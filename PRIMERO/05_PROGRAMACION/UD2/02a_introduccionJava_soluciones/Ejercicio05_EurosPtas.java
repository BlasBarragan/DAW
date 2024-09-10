package ud2_introduccionJava;

import java.util.Scanner;

public class Ejercicio05_EurosPtas {

	public static void main(String[] args) {

		final double VALOR_PTAS = 166.386;
		
		double euros;
		int pesetas;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime la cantidad en euros:");
		euros = sc.nextDouble();
		
		pesetas = (int) (euros * VALOR_PTAS);
		
		System.out.println(euros + "€ = " + pesetas + "ptas");
	}

}