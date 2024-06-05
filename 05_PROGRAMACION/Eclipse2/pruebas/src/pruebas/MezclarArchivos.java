package pruebas;

import java.io.*;
import java.util.Scanner;

public class MezclarArchivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del primer fichero: ");
        String fichero1 = scanner.nextLine();

        System.out.print("Introduce el nombre del segundo fichero: ");
        String fichero2 = scanner.nextLine();

        System.out.print("Introduce el nombre del fichero destino: ");
        String ficheroDestino = scanner.nextLine();

        mezclarFicheros(fichero1, fichero2, ficheroDestino);
    }

    public static void mezclarFicheros(String fichero1, String fichero2, String ficheroDestino) {
        try (BufferedReader br1 = new BufferedReader(new FileReader(fichero1));
             BufferedReader br2 = new BufferedReader(new FileReader(fichero2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroDestino))) {

            String linea1, linea2;
            boolean finFichero1 = false, finFichero2 = false;

            while (!finFichero1 || !finFichero2) {
                if (!finFichero1) {
                    linea1 = br1.readLine();
                    if (linea1 != null) {
                        bw.write(linea1);
                        bw.newLine();
                    } else {
                        finFichero1 = true;
                    }
                }

                if (!finFichero2) {
                    linea2 = br2.readLine();
                    if (linea2 != null) {
                        bw.write(linea2);
                        bw.newLine();
                    } else {
                        finFichero2 = true;
                    }
                }
            }

            System.out.println("Ficheros mezclados correctamente en " + ficheroDestino);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
