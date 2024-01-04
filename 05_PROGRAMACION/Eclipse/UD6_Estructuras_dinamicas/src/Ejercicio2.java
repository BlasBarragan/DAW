/**
 * Ejercicio 2. Practicando estructura Pila
 * 
 * Pedir enteros y los vamos apilando en el tipo de lista mas adecuado
 */
import java.util.Scanner;
import java.util.Stack;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		// ### Importamos java.util.Stack ### 
		// Creamos el stack
		Stack<Integer> pila = new Stack<Integer>();
		// Pedimos valores al usuario
		/*
		Scanner sc = new Scanner(System.in);
		int a = 0;
		System.out.println("Añade enteros positivos a la pila.");
		while (a >= 0) { // Usamos la estructura del ejercicio1 donde al introducir -1 indicamos que hemos acabado de añadir numeros
			System.out.println("Si has acabado, ingresa -1");
			a = sc.nextInt();
			if (a >= 0) {
				pila.push(a);
			}
		}
		*/
		
		System.out.println("*** Añadimos numeros por programa para agilizar las pruebas ***");	
		//Añado numeros por programa para las pruebas
				pila.push(33);
			    pila.push(15);
			    pila.push(20);
			    pila.push(34);
			    pila.push(8);
			    pila.push(12);
		
		System.out.println(pila);
			    
		// A. Obtener la cima de la pila.
		System.out.println("La cima de la pila es: " + pila.peek());
		
		// B. Eliminar la cima de la pila.
		System.out.println("Eliminamos la cima de la pila");
		pila.pop();
		
		// C. Imprimir la pila en vertical en formato logico (primero abajo, ultimo arriba).
		System.out.println("Esta es la pila: " + pila);			
		System.out.println("Imprimimos la pila en formato logico." + pila.size());
			// El ultimo valor añadido simpre tiene indice 0, asi que recorremos la pila 
		for (int i = pila.size() -1; i >= 0; i--) { // Obtenemos el tamaño de la pila y le restamos 1 (indice empieza en 0)
			System.out.println("Indice: " + pila.indexOf(pila.get(i)) + " Valor: " + pila.get(i) + " Posicion: " + pila.search(pila.get(i)));
		}
			// *** .get() obtiene el valor del indice indicado *** 
		
		// D. Elimiar todos los elementos de la pila.
		pila.clear();
		System.out.println("Eliminamos todos los elementos de la pila.");

		// E. Comprobar que la pila esta vacia
		if (!pila.isEmpty()) {
			System.out.println("La pila todavia contiene valores " + pila);
		}else {
			System.out.println("La pila esta vacia " + pila);
		}
		
	}
}
