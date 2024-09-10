/*
Ejercicio 9. Escribe un programa que permita leer y escribir un fichero binario con información de empleados
de una empresa. Cada empleado tendrá los siguientes datos:
• Nombre completo (cadena de caracteres)
• Edad (entero)
• Salario (double)
El programa deberá permitir al usuario elegir entre dos opciones:
• Crear un nuevo fichero de empleados y agregar información de empleados al mismo.
• Leer un fichero existente de empleados y mostrar en pantalla la información de todos los empleados
en formato legible.
Cuando se seleccione la opción 1, el programa deberá solicitar al usuario que ingrese la información de un
nuevo empleado. La información ingresada deberá ser validada antes de ser escrita en el fichero binario. Si el
fichero no existe, deberá crearse. Si ya existe, la información del nuevo empleado deberá ser agregada al final
del fichero.
Cuando se seleccione la opción 2, el programa deberá solicitar al usuario que ingrese el nombre del fichero
que se desea leer. Si el fichero existe y contiene información de empleados, esta información deberá ser leída
y mostrada en pantalla de forma legible.
Deberás tres clases:
• Empleado: clase serializable con los atributos necesarios (nombre, edad y salario), el constructor y los
getters/setters.
• FicheroEmpleados: clase que manejará el fichero de los empleados. Como atributo tendrá el nombre
de fichero, y dos métodos:
o public void agregarEmpleado(Empleado empleado): se encargará de añadir un objeto
(serializará) Empleado al final del fichero binario.
o public void mostrarEmpleados(): se encargará de leer y mostrar en pantalla todos los objetos
Empleado (deserializará) almacenados en el fichero binario.
• Ejercicio10Test: contiene el método main. Mostrará el menú y se encargará de pedir el ingreso de
datos
Ejemplo de salida:
Introduce el nombre del fichero de empleados: empleados.dat
Menú
1. Agregar empleado
2. Mostrar empleados
3. Salir
Opción: 1
Nombre: Anakin
Edad: 40
Salario: 1.200
Empleado agregado correctamente.
1. Agregar empleado
2. Mostrar empleados
3. Salir
Opción: 2
Nombre Edad Salario
Anakin 40 1200.0
*/
// CLASE EMPLEADO
import java.io.Serializable;

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Edad: %d, Salario: %.2f", nombre, edad, salario);
    }
}

// CLASE FicheroEmpleados
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FicheroEmpleados {
    private String nombreFichero;

    public FicheroEmpleados(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public void agregarEmpleado(Empleado empleado) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero, true)) {
            protected void writeStreamHeader() throws IOException {
                reset();
            }
        }) {
            oos.writeObject(empleado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarEmpleados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            List<Empleado> empleados = new ArrayList<>();
            while (true) {
                try {
                    Empleado empleado = (Empleado) ois.readObject();
                    empleados.add(empleado);
                } catch (EOFException e) {
                    break;
                }
            }
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// CLASE Ejercicio10Test
import java.util.Scanner;

public class Ejercicio10Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del fichero de empleados: ");
        String nombreFichero = scanner.nextLine();
        
        FicheroEmpleados ficheroEmpleados = new FicheroEmpleados(nombreFichero);
        
        while (true) {
            System.out.println("Menú");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    
                    Empleado empleado = new Empleado(nombre, edad, salario);
                    ficheroEmpleados.agregarEmpleado(empleado);
                    System.out.println("Empleado agregado correctamente.");
                    break;

                case 2:
                    System.out.println("Nombre\tEdad\tSalario");
                    ficheroEmpleados.mostrarEmpleados();
                    break;

                case 3:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}

