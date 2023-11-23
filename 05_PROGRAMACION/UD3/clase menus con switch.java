package teoria;

import java.util.Scanner;

public class ClaseMenuSwitch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Variable donde se guarda la opción del usuario
		int opcion;

		// Variable para indicar el fin del bucle
		boolean continuar = true;
		
		// Bucle infinito
		while (continuar) {

			// Mostrar por pantalla el menú
			System.out.printf("\n1.- Opción 1");
			System.out.printf("\n2.- Opción 2");
			System.out.printf("\n3.- Opción 3");
			System.out.printf("\n4.- Opción 4");
			System.out.printf("\n\n9.- Salir");
			System.out.printf("\n\nOpcion: ");

			// Leer la opción escogida por el usuario
			opcion = sc.nextInt();

			// Menú con enteros
			switch (opcion) {
			case 1: {
				System.out.println("\nHas escogido la opción 1");
				break;
			}
			case 2: {
				System.out.println("\nHas escogido la opción 2");
				break;
			}
			case 3: {
				System.out.println("\nHas escogido la opción 3");
				break;
			}
			case 4: {
				System.out.println("\nHas escogido la opción 4");
				break;
			}
			case 9: {
				System.out.println("\nFIN del programa");
				continuar = false;
			}
			default: {
				System.out.printf("\n\nOpción incorrecta\n");				
			}
			}
		}

		sc.nextLine();
		
		// Menú con String
		System.out.println("Escoja una opción: a) b) c)");
		
		String miOpcion = sc.nextLine().toLowerCase();
		
		switch (miOpcion) {

		case "a":
			System.out.println("Has escogido la opcion A");
			break;

		case "b":
			System.out.println("Has escogido la opcion B");
			break;

		case "c":
			System.out.println("Has escogido la opcion C");
			break;

		default:
			System.out.println("Opcion incorrecta");
			break;
		}

		sc.close();
	}

}