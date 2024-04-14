import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {

	/**
	 * Ejercicio 1. Escribe un programa que muestre 
	 * la lista de ficheros y directorios de una ruta del sistema
	 * introducida por el usuario. 
	 * El programa mostrará el contenido del directorio, si existe, 
	 * y volverá a pedir otra
	 * ruta al usuario; terminará cuando el usuario introduzca una ruta vacía
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String ruta;
		
		do {
			System.out.println("Indica la ruta que quieres listar: ");
			ruta = sc.nextLine();
			File sistema = new File(ruta);
			String [] arbolRuta = sistema.list();
			
			try {

				for ( String elemento : arbolRuta) {
					System.out.println(elemento);
				}
			}
			catch (NullPointerException e) {
				System.out.println("La ruta indicada no es valida");
			}
		}		
		while (!ruta.isEmpty()) ;{
			System.out.println("Fin programa");
		}
	}
}