/*
Escribe un programa que guarde en un fichero el contenido de otros dos
ficheros, de tal forma que en el fichero resultante aparezcan las líneas de los
primeros dos ficheros mezcladas, es decir, la primera línea será del primer
fichero, la segunda será del segundo fichero, la tercera será la siguiente del
primer fichero, etc.
Los nombres de los dos ficheros origen y el nombre del fichero destino se deben
pasar como argumentos en la línea de comandos.
Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas
pueden tener tamaños diferentes.
*/

import java.io.*;
import java.util.*;

public class MezclarArchivos {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: java MezclarArchivos <fichero1> <fichero2> <ficheroDestino>");
            return;
        }

        String fichero1 = args[0];
        String fichero2 = args[1];
        String ficheroDestino = args[2];

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// EJECUCION POR SHELL
// javac MezclarArchivos.java
// java MezclarArchivos fichero1.txt fichero2.txt ficheroDestino.txt

// CODIGO QUE PIDE NOMBRE DE ARCHIVOS

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

