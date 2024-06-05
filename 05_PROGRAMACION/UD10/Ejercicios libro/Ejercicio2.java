/*
Realiza un programa que lea el fichero creado en el ejercicio anterior y que
muestre los números por pantalla.
*/

import java.io.*;
import java.util.List;

public class LeerPrimos {
    public static void main(String[] args) {
        leerYMostrarPrimos("primos.dat");
    }

    // Método para leer y mostrar números primos desde un fichero binario
    public static void leerYMostrarPrimos(String nombreFichero) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            List<Integer> primos = (List<Integer>) ois.readObject();
            System.out.println("Números primos leídos de " + nombreFichero + ":");
            for (int primo : primos) {
                System.out.println(primo);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

