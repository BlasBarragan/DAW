/**
 * Ejercicio 4. Practicando estructura Conjunto
 * 
 * Pedir numeros de jugador sin poder estar repetidos 
 */
import java.util.Scanner;
import java.util.HashSet;

public class Ejercicio4 {

	public static void main(String[] args) {

		// ### Importamos java.util.HashSet ###
		// Creamos el conjunto
		HashSet<Integer> equipo = new HashSet<Integer>();
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
		equipo.add(33);
		equipo.add(15);
		equipo.add(10);
		equipo.add(34);
		equipo.add(8);
		equipo.add(13);

		System.out.println(equipo);

		// A. Comprobar si el jugador 10 existe.
		if (equipo.contains(10)) {
			System.out.println("El jugador numero 10, esta en el equipo.");
		}else {
			System.out.println("El jugador numero 10, no esta en el equipo.");
		}
		// B. Mostrar todos los numeros de jugador.
		System.out.println("El equipo, esta formado por los jugadores numero: " + equipo);

		// C. Eliminar al jugador numero 13.
		equipo.remove(13);
		System.out.println("El jugador numero 13, ha sido eliminado");
		System.out.println("Asi queda el equipo: " + equipo);

		// D. Eliminar a todos los jugadores.
		equipo.clear();

		// E. Comprobar que no hay jugadores en el equipo.
		if (equipo.isEmpty()) {
			System.out.println("El equipo esta vacio " + equipo);
		}else {
			System.out.println("El equipo todavia tiene jugadores " + equipo);
		}
	}

}
