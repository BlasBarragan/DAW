import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {
	
/**Amplía el programa anterior para que pida al usuario una extensión de fichero concreta 
 * (porejemplo, “.txt”) y muestre todos los ficheros del directorio dado con esa extensión. 
 * Crea y utiliza un método llamado ArrayList<String> filtrarPorExtension(File fichero, String extensión) 
 * que se encargará de filtrar la ruta según la extensión pasada en el parámetro. 
 * Nota: el usuario pasa la extensión sin el punto (.)
 */

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		String ruta;
		String extension;
		
		do {
			System.out.println("Indica la ruta que quieres listar: ");
			ruta = sc.nextLine();
			System.out.println("Indica la extension para filtrar: ");
			extension = sc.nextLine();
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
	
	public static void filtrarPorExtension(File sistema, String extension) {
		
	}
}
