/**
 * Unidad 2b: Ejercicio 8
 * 
 * @author jrsimo
 * 
 */

package U02bEjercicios;

import java.util.Scanner;

public class U02bEjercicio7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Pido el número del alumno y lo guardo en una variable de tipo entero
		System.out.println("Introduce el número del alumno: ");
		int numeroAlumno = sc.nextInt();
		sc.nextLine(); // Para consumir el retorno de carro (prueba a quitarlo para ver que ocurre)
		
		// Pido el nombre del alumno y lo guardo en una variable de tipo cadena
		System.out.println("Introduce el nombre del alumno: ");
		String nombreAlumno = sc.nextLine();
		
		// Pido las notas de los exámenes y las guardo en variables tipo float (podrían ser double)
		System.out.print("Introduce la nota del 1r. Examen: ");
		float notaExamen1Alumno = sc.nextFloat();
		
		System.out.print("Introduce la nota del 2o. Examen: ");
		float notaExamen2Alumno = sc.nextFloat();
		
		System.out.print("Introduce la nota del 3r. Examen: ");
		float notaExamen3Alumno = sc.nextFloat();
		
		// Calculo la media...
		float notaMediaAlumno = (notaExamen1Alumno + notaExamen2Alumno + notaExamen3Alumno) / 3.0f;
		
		
		System.out.println("\n\n"); // \n es un retorno de carro (enter)
		
		// Muestro los resultados formateados con printf para jugar con el padding...
		System.out.println("============================ Notas Alumno ============================");
		System.out.printf("Alumno: %d - %-20s", numeroAlumno,  nombreAlumno);
		System.out.printf("%-10s %-10s %-10s %-10s %n", "ex.1", "ex.2", "ex.3", "media");
		System.out.printf("%-31s %-10.2f %-10.2f %-10.2f %-10.2f", "Notas 1a. Evaluación: ",
				notaExamen1Alumno, notaExamen2Alumno, notaExamen3Alumno, notaMediaAlumno);
		
	}
}
