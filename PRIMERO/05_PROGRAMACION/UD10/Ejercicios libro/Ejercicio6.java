/*
Realiza un programa que diga cuántas ocurrencias de una palabra hay en un
fichero. Tanto el nombre del fichero como la palabra se deben pasar como
argumentos en la línea de comandos.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarOcurrencias {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java ContarOcurrencias <nombreFichero> <palabra>");
            return;
        }

        String nombreFichero = args[0];
        String palabra = args[1];

        try {
            int ocurrencias = contarOcurrenciasEnFichero(nombreFichero, palabra);
            System.out.println("La palabra '" + palabra + "' aparece " + ocurrencias + " veces en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int contarOcurrenciasEnFichero(String nombreFichero, String palabra) throws IOException {
        int ocurrencias = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en palabras
                String[] palabras = linea.split("\\s+");

                // Contar las ocurrencias de la palabra en la línea actual
                for (String p : palabras) {
                    if (p.equals(palabra)) {
                        ocurrencias++;
                    }
                }
            }
        }

        return ocurrencias;
    }
}


// PIDE PALABRA POR TERMINAL

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContarOcurrencias {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java ContarOcurrencias <nombreFichero>");
            return;
        }

        String nombreFichero = args[0];
        String palabra = solicitarPalabraPorTerminal();

        try {
            int ocurrencias = contarOcurrenciasEnFichero(nombreFichero, palabra);
            System.out.println("La palabra '" + palabra + "' aparece " + ocurrencias + " veces en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String solicitarPalabraPorTerminal() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String palabra = null;
        try {
            System.out.print("Introduce la palabra a buscar: ");
            palabra = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return palabra;
    }

    public static int contarOcurrenciasEnFichero(String nombreFichero, String palabra) throws IOException {
        int ocurrencias = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en palabras
                String[] palabras = linea.split("\\s+");

                // Contar las ocurrencias de la palabra en la línea actual
                for (String p : palabras) {
                    if (p.equals(palabra)) {
                        ocurrencias++;
                    }
                }
            }
        }

        return ocurrencias;
    }
}

