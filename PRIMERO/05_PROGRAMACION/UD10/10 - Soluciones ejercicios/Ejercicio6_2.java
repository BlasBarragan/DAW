/*
Ejercicio 6. Implementa un programa que muestre por pantalla los valores máximos y mínimos del archivo
‘numeros.txt’
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("numeros.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (numeros.isEmpty()) {
            System.out.println("El archivo está vacío o no contiene números válidos.");
            return;
        }

        int max = Collections.max(numeros);
        int min = Collections.min(numeros);

        System.out.printf("Valor máximo: %d\n", max);
        System.out.printf("Valor mínimo: %d\n", min);
    }
}
