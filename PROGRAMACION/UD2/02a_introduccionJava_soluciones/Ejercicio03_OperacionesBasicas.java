package ud2_introduccionJava;

import java.util.Scanner;

public class Ejercicio03_OperacionesBasicas {

	public static void main(String[] args) {

		int a = 144;
		int b = 999;
		double res = 0;

		//La variable "sc" se usará para leer los datos
		Scanner sc = new Scanner(System.in);

		//Preguntar el valor de A
		System.out.println("Introducir valor de A: ");    	    

		//Leer un entero
		a = sc.nextInt();	    

		//Preguntar el valor de B
		System.out.println("Introducir valor de B: ");

		//Leer un entero
		b = sc.nextInt();

		//Realizar los cálculos
		res = a + b;
		System.out.println("La suma es: " + res);
		res = a - b;
		System.out.println("La resta es: " + res);
		res = a * b;
		System.out.println("La multiplicación es: " + res);
		res = (double) a / b;
		System.out.print("La división es: " + res);
	}

}