/**
 * Ejercicio 3. Practicando estructura Cola
 * 
 * Pedir enteros y los vamos encolando en el tipo de lista mas adecuado
 */

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Ejercicio3 {

	public static void main(String[] args) {

		// ### Importamos java.util.Queue ### 
		// ### Importamos java.util.LinkedList ###
		// Creamos la cola
		Queue<Integer> cola = new LinkedList<Integer>();
		// Pedimos valores al usuario
		/*
			Scanner sc = new Scanner(System.in);
			int a = 0;
			System.out.println("Añade enteros positivos a la cola.");
			while (a >= 0) { // Usamos la estructura del ejercicio1 donde al introducir -1 indicamos que hemos acabado de añadir numeros
				System.out.println("Si has acabado, ingresa -1");
				a = sc.nextInt();
				if (a >= 0) {
					cola.add(a);
				}
			}
		*/	
			System.out.println("*** Añadimos numeros por programa para agilizar las pruebas ***");	
			//Añado numeros por programa para las pruebas
					cola.add(33);
				    cola.add(15);
				    cola.add(20);
				    cola.add(34);
				    cola.add(8);
				    cola.add(12);
			
			System.out.println(cola);
			
			// A. Obtener cabeza de la cola.
			System.out.println("La cabeza de cola es: " + cola.peek());
			
			// B. Elimina la cabeza de la cola.
			System.out.println("Cola contiene: " + cola);
			cola.poll();
			System.out.println("Hemos eliminado la cabeza de la cola.");
			
			// C. Imprimir contenido original de la cola
			System.out.println("Así queda la cola: " + cola);

			// D. Eliminar los elementos de la cola.
			cola.clear();
			
			// E. Comprobamos que la cola esta vacia.
			if (!cola.isEmpty()) {
				System.out.println("La cola todavia contiene valores " + cola);
			}else {
				System.out.println("La cola esta vacia " + cola);
			}
	}
}
