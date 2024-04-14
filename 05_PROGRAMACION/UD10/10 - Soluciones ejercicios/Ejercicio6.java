import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio6 {
	
	
	
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		File fichero = new File("recursos\\numeros.txt");
		
		try {
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			
			String linea;
			ArrayList<Integer> numeros = new ArrayList<Integer>();
			while((linea = br.readLine()) != null) {
				numeros.add(Integer.valueOf(linea));
			}
			System.out.println("-- Resultados --");
			System.out.println("Mínimo: " +	Collections.min(numeros));
			System.out.println("Máximo: " + Collections.max(numeros));
			
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el fichero.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero.");
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("No se ha podido cerrar el fichero");
			}
		}
	}
}
