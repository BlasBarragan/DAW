/*
Ejercicio 10. Queremos tener una agenda telefónica en la que podamos guardar el nombre y teléfono de un
contacto. Realiza un programa con un bucle y un menú con las siguientes opciones. Evidentemente debes
crear una clase Contacto:
1. Dar de alta un contacto
2. Consultar un contacto por su nombre
3. Saber la cantidad de amigos grabados
4. Mostrar toda la agenda por pantalla
5. Borrar un contacto
6. Modificar los datos de un contacto
7. Importar datos
8. Exportar datos
Las opciones más importantes de este ejercicio, en cuanto al uso de ficheros, son las de importar y exportar
datos. La opción de importar datos solicitará un nombre de fichero donde están los contactos y lo pasará a
ArrayList. Y la opción de exportar datos pedirá un nombre de fichero guardará allí los datos de ArrayList. El
resto de las opciones será a través de la gestión del ArrayList.
Nota: en este ejercicio debes considerar la clase Contacto como serializable y utilizar la clase
ObjectInputStream y ObjectOutputStream.
*/
// CLASE Contacto
import java.io.Serializable;

public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}

// CLASE main
import java.io.*;
import java.util.*;

public class Main {
    private static List<Contacto> agenda = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    darDeAltaContacto();
                    break;
                case 2:
                    consultarContacto();
                    break;
                case 3:
                    cantidadDeAmigos();
                    break;
                case 4:
                    mostrarAgenda();
                    break;
                case 5:
                    borrarContacto();
                    break;
                case 6:
                    modificarContacto();
                    break;
                case 7:
                    importarDatos();
                    break;
                case 8:
                    exportarDatos();
                    break;
                case 9:
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

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Dar de alta un contacto");
        System.out.println("2. Consultar un contacto por su nombre");
        System.out.println("3. Saber la cantidad de amigos grabados");
        System.out.println("4. Mostrar toda la agenda por pantalla");
        System.out.println("5. Borrar un contacto");
        System.out.println("6. Modificar los datos de un contacto");
        System.out.println("7. Importar datos");
        System.out.println("8. Exportar datos");
        System.out.println("9. Salir");
        System.out.print("Opción: ");
    }

    private static void darDeAltaContacto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        agenda.add(new Contacto(nombre, telefono));
        System.out.println("Contacto agregado correctamente.");
    }

    private static void consultarContacto() {
        System.out.print("Nombre del contacto a consultar: ");
        String nombre = scanner.nextLine();
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(contacto);
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    private static void cantidadDeAmigos() {
        System.out.println("Cantidad de amigos grabados: " + agenda.size());
    }

    private static void mostrarAgenda() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (Contacto contacto : agenda) {
                System.out.println(contacto);
            }
        }
    }

    private static void borrarContacto() {
        System.out.print("Nombre del contacto a borrar: ");
        String nombre = scanner.nextLine();
        Iterator<Contacto> iterator = agenda.iterator();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                System.out.println("Contacto borrado correctamente.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    private static void modificarContacto() {
        System.out.print("Nombre del contacto a modificar: ");
        String nombre = scanner.nextLine();
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Nuevo teléfono: ");
                String telefono = scanner.nextLine();
                contacto.setTelefono(telefono);
                System.out.println("Contacto modificado correctamente.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    private static void importarDatos() {
        System.out.print("Nombre del fichero a importar: ");
        String nombreFichero = scanner.nextLine();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            agenda = (List<Contacto>) ois.readObject();
            System.out.println("Datos importados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void exportarDatos() {
        System.out.print("Nombre del fichero a exportar: ");
        String nombreFichero = scanner.nextLine();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(agenda);
            System.out.println("Datos exportados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
