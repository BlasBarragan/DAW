/*
Ejercicio 8. Haz un programa que genere un fichero con algunos números enteros, lo cierre y lo vuelve a abrir
y muestre el contenido. A continuación, le añadirá más enteros y que vuelva a mostrar el fichero. Para ello:
• Haz el método generarFicheroEnteros, al que se le pase un nombre de fichero y una cantidad, y
guardará en dicho fichero tantos números como la cantidad indicada. Los números se generarán de
forma aleatoria.
• Haz el método mostrarFicheroEnteros al que se le pasa como parámetro un fichero y debe mostrar
todos los números del fichero (sabemos que son enteros) por pantalla, separados por un tabulador.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String nombreFichero = "numeros.txt";
        int cantidadInicial = 10;
        int cantidadAdicional = 5;

        // Generar el fichero con números enteros
        generarFicheroEnteros(nombreFichero, cantidadInicial);

        // Mostrar el contenido del fichero
        System.out.println("Contenido inicial del fichero:");
        mostrarFicheroEnteros(nombreFichero);

        // Añadir más números enteros al fichero
        generarFicheroEnteros(nombreFichero, cantidadAdicional);

        // Mostrar el contenido actualizado del fichero
        System.out.println("Contenido actualizado del fichero:");
        mostrarFicheroEnteros(nombreFichero);
    }

    public static void generarFicheroEnteros(String nombreFichero, int cantidad) {
        Random random = new Random();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true))) {
            for (int i = 0; i < cantidad; i++) {
                int numero = random.nextInt(100); // Genera números entre 0 y 99
                bw.write(String.valueOf(numero));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarFicheroEnteros(String nombreFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.print(linea + "\t");
            }
            System.out.println(); // Para el salto de línea final
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
