/*
Realiza un programa que sea capaz de ordenar alfabéticamente las palabras
contenidas en un fichero de texto. El nombre del fichero que contiene las
palabras se debe pasar como argumento en la línea de comandos. El nombre
del fichero resultado debe ser el mismo que el original añadiendo la coletilla
sort, por ejemplo palabras_sort.txt. Suponemos que cada palabra ocupa una
línea.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenarPalabras {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java OrdenarPalabras <nombreFichero>");
            return;
        }

        String nombreFichero = args[0];
        String nombreFicheroOrdenado = obtenerNombreOrdenado(nombreFichero);

        List<String> palabras = leerPalabrasDeFichero(nombreFichero);
        if (palabras != null) {
            Collections.sort(palabras);
            escribirPalabrasEnFichero(palabras, nombreFicheroOrdenado);
            System.out.println("Palabras ordenadas guardadas en " + nombreFicheroOrdenado);
        }
    }

    // Obtiene el nombre del fichero ordenado
    public static String obtenerNombreOrdenado(String nombreFichero) {
        int puntoIndice = nombreFichero.lastIndexOf('.');
        if (puntoIndice == -1) {
            return nombreFichero + "_sort";
        } else {
            return nombreFichero.substring(0, puntoIndice) + "_sort" + nombreFichero.substring(puntoIndice);
        }
    }

    // Lee las palabras de un fichero y las devuelve en una lista
    public static List<String> leerPalabrasDeFichero(String nombreFichero) {
        List<String> palabras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                palabras.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return palabras;
    }

    // Escribe las palabras en un fichero
    public static void escribirPalabrasEnFichero(List<String> palabras, String nombreFichero) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
            for (String palabra : palabras) {
                bw.write(palabra);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

