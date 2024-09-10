import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Solución con PrintWriter
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String nombre = "";
		String telefono = "";
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
		File fichero = new File("recursos\\agenda.txt");
		
		try {
			fw = new FileWriter(fichero, false);
			
			pw = new PrintWriter(fw);
			
			do {
				System.out.print("Introduce nombre: ");
				nombre = sc.nextLine();
				
				if (!nombre.toLowerCase().equals("fin") ) {
					System.out.print("Introduce teléfono: ");
					telefono = sc.nextLine();
					
					pw.println(nombre+"-"+telefono);
				}

			} while(!nombre.toLowerCase().equals("fin"));
		} catch(IOException e) {
			System.out.println("No se ha podido abrir el fichero o fallo en escritura.");
			e.printStackTrace();
		} finally {
			pw.close();
			sc.close();
		}
		
	}

}
