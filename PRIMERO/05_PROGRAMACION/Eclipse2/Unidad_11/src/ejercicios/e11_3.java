package ejercicios;

//Ejercicio 11.3: Inserciones Parametrizadas

import java.sql.*;
import java.util.Scanner;

public class e11_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement ps = null;

        String url = "jdbc:mysql://localhost:3306/pruebabd";
        String usuario = "root";
        String contrasenya = "";

        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, contrasenya);

            // Bucle para insertar múltiples personas
            String respuesta;
            do {
                System.out.println("Ingrese el DNI de la persona:");
                String dni = scanner.nextLine();
                System.out.println("Ingrese el nombre de la persona:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese la edad de la persona:");
                int edad = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                String consulta = "INSERT INTO personas (dni, nombre, edad) VALUES (?, ?, ?)";
                ps = conn.prepareStatement(consulta);
                ps.setString(1, dni);
                ps.setString(2, nombre);
                ps.setInt(3, edad);
                int resultado = ps.executeUpdate();

                if (resultado > 0) {
                    System.out.println("Persona insertada con éxito.");
                }

                System.out.println("¿Desea insertar otra persona? (s/n)");
                respuesta = scanner.nextLine();
            } while (respuesta.equalsIgnoreCase("s"));

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error durante la conexión o la consulta.");
            e.printStackTrace();
        } finally {
            // Cerrar conexiones
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
                scanner.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones.");
                e.printStackTrace();
            }
        }
    }
}

