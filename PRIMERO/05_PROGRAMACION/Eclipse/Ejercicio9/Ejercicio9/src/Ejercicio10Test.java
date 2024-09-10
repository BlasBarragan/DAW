import java.util.Scanner;

public class Ejercicio10Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero de empleados: ");
        String nombreArchivo = scanner.nextLine();
        FicheroEmpleados ficheroEmpleados = new FicheroEmpleados(nombreArchivo);

        while (true) {
            System.out.println("Menú");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre completo del empleado:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la edad del empleado:");
                    int edad = scanner.nextInt();
                    System.out.println("Ingrese el salario del empleado:");
                    double salario = scanner.nextDouble();

                    // Validar la información ingresada
                    if (edad < 0 || salario < 0) {
                        System.out.println("Edad y salario deben ser valores positivos. Intente de nuevo.");
                        break;
                    }

                    Empleado nuevoEmpleado = new Empleado(nombre, edad, salario);
                    ficheroEmpleados.agregarEmpleado(nuevoEmpleado);
                    break;
                case 2:
                    ficheroEmpleados.mostrarEmpleados();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}