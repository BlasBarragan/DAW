import java.io.File;
import java.util.Scanner;

public class Ejercicio1_gpt {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introduce una ruta (ruta vacía para salir): ");
            String ruta = scanner.nextLine();
            if (ruta.isEmpty()) {
                break;
            }
            try {
                File directorio = new File(ruta);
                if (directorio.exists() && directorio.isDirectory()) {
                    System.out.println("Contenido de " + ruta + ":");
                    String[] contenido = directorio.list();
                    for (String elemento : contenido) {
                        System.out.println(elemento);
                    }
                } else {
                    System.out.println("La ruta especificada no existe o no es un directorio.");
                }
            } catch (SecurityException e) {
                System.out.println("No tienes permisos para acceder a esta ruta.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
