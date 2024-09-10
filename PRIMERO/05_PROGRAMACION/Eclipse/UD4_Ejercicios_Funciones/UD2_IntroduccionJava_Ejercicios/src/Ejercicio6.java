import java.util.Scanner;

/**
 * Blas Barragan Roman
 * 
 * UD2 Introduccion a Java
 * 
 * Ejercicio 6
 * Realiza un programa que calcule la nota que hace falta sacar en el segundo
 * examen de la asignatura Programación para obtener la media deseada.
 * Hay que tener en cuenta que la nota del primer examen cuenta el 40% y la
 * del segundo examen un 60%.
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		// Declaramos variables
		float nota_examen = 0;
		float nota_segundo = 0;
		float aux = 0;
		Scanner sc = new Scanner(System.in);
		// Solicitamos nota primer examen
		System.out.println("Introduce la note del primer examen: ");
		nota_examen = sc.nextFloat();
		// Solicitamos segunda nota
		System.out.println("¿Que nota quieres sacar en el trimestre? ");
		nota_segundo = sc.nextFloat();
		// Realizamos operaciones
		nota_examen = nota_examen*0.4f; 
		aux = (nota_segundo - nota_examen) / 60 * 100 ;
		// Devolvemos resultado		
		System.out.println("Para tener un " + nota_segundo + " en el trimestre, \nnecesitas sacar un " 
							+ aux + " en el segundo examen");
	}
}
