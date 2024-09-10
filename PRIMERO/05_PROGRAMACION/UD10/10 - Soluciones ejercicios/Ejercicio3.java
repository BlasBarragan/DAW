import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio3 {

    public static void main(String[] args) {
        String rutaFichero = "recursos\\parrafos.txt"; 
        ArrayList<String> parrafos = new ArrayList<>(); 
        int contador = 0; 

        BufferedReader br = null;
        FileReader fr = null;
        File fichero = new File(rutaFichero);
        
        try {
        	fr = new FileReader(fichero);
        	br = new BufferedReader(fr);
            String linea;
            
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) { 
                    if (parrafos.size() <= contador) {
                        parrafos.add(linea);
                    } else {
                        parrafos.set(contador, parrafos.get(contador) + " " + linea);
                    }
                } else { 
                    contador++;
                }
            }
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
        		System.out.println("No se ha podido cerrar el fichero.");
            	e.printStackTrace();
        	}
        }

        System.out.println("El archivo tiene " + (contador + 1) + " párrafos.\n");

        for (int i = 0; i < parrafos.size(); i++) {
            String parrafo = parrafos.get(i);
            int cantidadDeLetras = parrafo.replaceAll("\\s+", "").length(); // eliminamos los espacios en blanco y contamos la cantidad de caracteres restantes
            System.out.println("Párrafo " + (i + 1) + ": " + cantidadDeLetras + " letras.");
        }
    }
}