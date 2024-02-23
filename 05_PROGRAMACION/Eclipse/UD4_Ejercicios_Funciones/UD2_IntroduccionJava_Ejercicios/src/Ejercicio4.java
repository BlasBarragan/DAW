import java.util.Scanner;

/**
 * Blas Barragan Roman
 * 
 * UD2 Introduccion a Java
 * 
 * Ejercicio 4
 * Un colegio desea saber qué porcentaje de niños y qué porcentaje de niñas
 * hay en el curso actual.
 * El usuario introducirá el número de niños y de niñas.
 * Diseñar un algoritmo para este propósito.
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		// Definicion variables 
		int ninos = 0;
		int ninas = 0;
		float porcentaje_ninas = 0;
		float porcentaje_ninos = 0;
		
		// Inicializacion scanner para entrada por teclado
		Scanner sc = new Scanner(System.in);
		// Consulta a usuario
		System.out.println("Cuantos niños hay en la clase?: ");
		ninos = sc.nextInt();
		System.out.println("Cuantas niñas hay en la clase?: ");
		ninas = sc.nextInt();
		// Calculo de porcentajes
		porcentaje_ninos = ninos*100 / (ninos + ninas);
		porcentaje_ninas = ninas*100 / (ninos + ninas);
		// Respuesta resultado
		System.out.println("El porcentaje de niños en clase es del: " + porcentaje_ninos);
		System.out.println("El porcentaje de niñas en clase es del: " + porcentaje_ninas);
	}

}
