package ud2_introduccionJava;

import java.util.Scanner;

public class Ejercicio06_CalculoNota {

	public static void main(String[] args) {
		/*
		 * Realiza un programa que calcule la nota que hace falta sacar en el segundo
		 * examen de la asignatura Programación para obtener la media deseada.
		 * Hay que tener en cuenta que la nota del primer examen cuenta el 40% y la
		 * del segundo examen un 60%. 
		 * */

		Scanner sc = new Scanner(System.in);
		
		double primerExamen, segundoExamen, notaFinal;
		
		System.out.println("Introduce la nota del primer examen:");
		primerExamen = sc.nextDouble();
		
		System.out.println("¿Qué nota quieres sacar en el trimestre?");
		notaFinal = sc.nextDouble();
		
		segundoExamen = ((notaFinal) - (0.4 * primerExamen)) / 0.6;
		
		System.out.println("Para tener un " + notaFinal + " en el trimestre necesitas " +
		"sacar un " + segundoExamen + " en el segundo examen.");		
	}

}