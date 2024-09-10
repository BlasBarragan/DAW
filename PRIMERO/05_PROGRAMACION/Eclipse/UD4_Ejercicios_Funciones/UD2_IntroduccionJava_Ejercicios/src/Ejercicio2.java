/**
 * Blas Barragan Roman
 * 
 * UD2 introduccion a Java
 * 
 * Ejercicio 2 
 * 
 * Dadas dos variables numéricas A y B, que el usuario debe teclear, se pide
 * realizar un algoritmo que intercambie los valores de ambas variables y
 * muestre por pantalla cuanto valen al final las dos variables.
 */
import java.util.Scanner;
public class Ejercicio2 {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int aux = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa numero a: ");
		a = sc.nextInt();
		System.out.println("Ingresa numero b: ");
		b = sc.nextInt();
		
		aux = a;
		a = b; 
		b = aux;
		
		System.out.println("Ahora la variable a, vale: " + a);
		System.out.println("Ahora la variable b, vale: " + b);
		
	}

}
