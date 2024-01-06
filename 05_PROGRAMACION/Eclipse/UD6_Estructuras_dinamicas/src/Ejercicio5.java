/**
 * Ejercicio 5. Gestion de colas de procesos
 * 
 * Programa para que la CPU atienda procesos.
 * Pedir al usuario que introduzca PID's que se almacenan
 * en Cola de numeros enteros hasta valor negativo
 * 
 * Despues, se muestra un menu con las siguientes opciones:
 * 1. Atender proceso
 * 2. Eliminar proceso
 * 3. Mostrar procesos restantes
 * 4. Mostrar total de procesos atendidos
 * 5. Atender todos los procesos
 * 6. Salir
 */
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Ejercicio5 {

	// Declaracion Variables
	static int procesoAtendido = 0; //Contador de procesos atendidos

	// ### Importamos java.util.Queue ### 
	// ### Importamos java.util.LinkedList ###
	// Creamos cola vacia
	private static Queue<Integer> cola = new LinkedList<Integer>();


	public static void main(String[] args) {

		// Pedimos valores al usuario
		Scanner sc = new Scanner(System.in);
		/*
			int a = 0;
			System.out.println("Añade PID's a la cola de procesos.");
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
		System.out.println();

		// Menu programa
		int opcion = 0; // Declaramos opcion fuera del *do* para no tener fallo
		do {
			MenuPrincipal();
			System.out.println("Elija una opcion: ");

			opcion = sc.nextInt(); // Obtenemos digito de usuario
			sc.nextLine(); // Consumo retorno dde carro

			switch(opcion) {
			case 1:
				AtenderProceso();
				break;
			case 2:
				EliminarProceso();
				break;
			case 3:
				MostrarRestante();
				break;
			case 4:
				ProcesosAtendidos();
				break;
			case 5:
				AtenderTodos();
				break;
			case 6:
				break;
			default:
				System.out.println("Opcion no válida!");
			}// FIN switch

		}while (opcion != 6); // FIN do
		System.out.println("< ==== Salir ==== >");

	}// FIN MAIN

	// ######## FUNCIONES ########
	/**
	 * Funcion MenuPrincipal
	 * Muestra un menu con las distintas opciones del programa
	 */
	public static void MenuPrincipal () {
		System.out.println("< ======== GESTOR DE COLAS DE PROCESO ======== >");
		System.out.println();
		System.out.println("1-> Atender proceso");
		System.out.println("2-> Eliminar proceso");
		System.out.println("3-> Mostrar procesos restantes");
		System.out.println("4-> Mostrar total de procesos atendidos");
		System.out.println("5-> Atender todos los procesos");
		System.out.println("6-> Salir");
		System.out.println();
	}
	/**
	 * Funcion AtenderProceso
	 * Muestra el proceso a atender y se elimina de la cola.
	 * Imprime ("El proceso con el PID X ha sido atendido");
	 */
	public static void AtenderProceso () {
		System.out.println("< ==== Atender proceso ==== >");
		System.out.println("");
		System.out.println("Proceso: " + cola.peek());
		System.out.println("El proceso con el PID " + cola.poll() + " ha sido atendido.");
		System.out.println("");

		procesoAtendido ++;
	}
	/**
	 * Funcion EliminarProceso
	 * Elimina el proceso en cabeza, sin ser atendido por la CPU.
	 */
	public static void EliminarProceso () {
		System.out.println("< ==== Eliminar proceso ==== >");		
		System.out.println("");
		System.out.println("Proceso " + cola.poll() + " eliminado.");
		System.out.println("");
	}
	/**
	 * Funcion MostrarRestante
	 * Muestra la lista de PIDs que quedan por atender en formato vertical.
	 */
	public static void MostrarRestante () {
		System.out.println("< ==== Mostrar procesos restantes ==== >");
		System.out.println("");
		System.out.println("Quedan los siguientes PID por atender: ");
		for (Integer pid : cola) {
			System.out.println(pid);
		}
		System.out.println("");
	}
	/**
	 * Funcion ProcesosAtendidos
	 * Muestra el total de los procesos que han sido atendidos por la CPU.
	 * Imprime el resultado de la variable procesoAtendido
	 */
	public static void ProcesosAtendidos () {
		System.out.println("< ==== Mostrar total de procesos atendidos ==== >");
		System.out.println("");
		if (procesoAtendido == 0) {
			System.out.println("Ningun proceso atendido todavia");
		}else {
			System.out.println("Se han atendido un total de " + procesoAtendido + " procesos por la CPU");
		}
		System.out.println("");
	}
	/**
	 * Funcion AtenderTodos
	 * Atiende todos los procesos pendientes en cola.
	 */
	public static void AtenderTodos () {
		System.out.println("< ==== Atender todos los procesos ==== >");
		while (!cola.isEmpty()) {
			System.out.println("Proceso " + cola.poll() + " atendido");
			procesoAtendido ++;
		}
		System.out.println("Todos los procesos atendidos");
		System.out.println("La cola esta vacia");
		System.out.println("");
	}

	// FIN PROGRAMA
}
