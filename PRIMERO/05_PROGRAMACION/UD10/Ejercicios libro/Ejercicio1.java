/*
Escribe un programa que guarde en un fichero con nombre primos.dat los
números primos que hay entre 1 y 500.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Primos {
    public static void main(String[] args) {
        List<Integer> primos = generarPrimos(1, 500);
        guardarPrimosEnFichero(primos, "primos.dat");
        leerPrimosDeFichero("primos.dat");
    }

    // Generar números primos en un rango dado
    public static List<Integer> generarPrimos(int inicio, int fin) {
        List<Integer> primos = new ArrayList<>();
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                primos.add(i);
            }
        }
        return primos;
    }

    // Comprobar si un número es primo
    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Guardar números primos en un fichero binario
    public static void guardarPrimosEnFichero(List<Integer> primos, String nombreFichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(primos);
            System.out.println("Números primos guardados en " + nombreFichero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Leer números primos de un fichero binario
    public static void leerPrimosDeFichero(String nombreFichero) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            List<Integer> primos = (List<Integer>) ois.readObject();
            System.out.println("Números primos leídos de " + nombreFichero + ": " + primos);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
