/*
Realiza un programa que pida 6 números por teclado y nos diga cuál es el
máximo. Si el usuario introduce un dato erróneo (algo que no sea un número
entero) el programa debe indicarlo y debe pedir de nuevo el número.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class MaximoDeSeisNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maximo = Integer.MIN_VALUE;

        System.out.println("Introduce 6 números enteros:");

        for (int i = 0; i < 6; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            try {
                int numero = scanner.nextInt();
                if (numero > maximo) {
                    maximo = numero;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero.");
                // Limpiar el buffer del scanner para evitar un bucle infinito
                scanner.nextLine();
                i--; // Decrementar el contador para repetir la solicitud del mismo número
            }
        }

        System.out.println("El máximo de los números ingresados es: " + maximo);
    }
}
