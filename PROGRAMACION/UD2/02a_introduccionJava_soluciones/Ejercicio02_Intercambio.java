/**
 * @author Jose Chamorro
 * Fecha: 19/09/2018
 * 
 * Versión: 3.0
 * 
 * Dadas dos variables numéricas A y B, que el usuario debe
 * teclear, se pide realizar un algoritmo que intercambie los valores de ambas variables y
 * muestre cuanto valen al final las dos variables (recuerda la asignación).
 *
 */

package ud2_introduccionJava;

import java.util.Scanner;

public class Ejercicio02_Intercambio {

	public static void main(String[] args) {

		int a;
		int b;
		int aux;

		//La variable "teclado" se usará para leer los datos
		Scanner teclado = new Scanner(System.in);		

		//Preguntar el valor de A
		System.out.println("Introducir valor de A: ");    	    

		//Leer un entero
		a = teclado.nextInt();

		//Preguntar el valor de B
		System.out.println("Introducir valor de B: ");

		//Leer un entero
		b = teclado.nextInt();

		//Intercambiar valores	    
		aux = a;
		a = b;
		b = aux;

		//Mostrar información
		System.out.println("El valor de A es " + a);
		System.out.println("El valor de B es " + b);		
	}
	
}