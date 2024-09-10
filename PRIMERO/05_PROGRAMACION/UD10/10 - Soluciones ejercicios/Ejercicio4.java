import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Solución con BufferedWriter en vez de PrintWriter
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = "";
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		File fichero = new File("recursos\\frases.txt");
		
		try {
			fw = new FileWriter(fichero, true);
			
			bw = new BufferedWriter(fw);
						
			do {
				System.out.print("Introduce frase: ");
				frase = sc.nextLine();
				if (!frase.toLowerCase().equals("fin") ) {
					bw.write(frase);
					bw.newLine();
					//bw.write(frase+"\n"); // write y newline a la vez
				}
			} while(!frase.toLowerCase().equals("fin"));
			
		} catch(IOException e) {
			System.out.println("No se ha podido abrir el fichero o fallo en escritura.");
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				System.out.println("No se ha podido cerrar el fichero");
				e.printStackTrace();
			}
			
			sc.close();
		}
		
		System.out.println("Fin del programa");
	}
}
