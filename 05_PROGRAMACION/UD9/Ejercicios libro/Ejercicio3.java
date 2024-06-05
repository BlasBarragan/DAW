/*
Realiza un programa que genere una excepción de forma aleatoria de entre
las siguientes excepciones: NumberFormatException, IOException, FileNotFoundException,
IndexOutOfBoundsException y ArithmeticException.
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class ExcepcionAleatoria {
    public static void main(String[] args) {
        // Crear un array con las clases de excepción disponibles
        Class[] excepciones = {
                NumberFormatException.class,
                IOException.class,
                FileNotFoundException.class,
                IndexOutOfBoundsException.class,
                ArithmeticException.class
        };

        // Generar un índice aleatorio para seleccionar una excepción
        Random random = new Random();
        int indiceExcepcion = random.nextInt(excepciones.length);

        // Generar la excepción seleccionada aleatoriamente
        try {
            throw (Exception) excepciones[indiceExcepcion].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
