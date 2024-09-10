package ejercicios;

//Ejercicio 11.6: Insertar Alumnos en la Tabla "ALUMNOS"

import java.sql.*;
import java.util.Scanner;

public class e11_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement ps = null;

        String url = "jdbc:mysql://localhost:3306/instituto";
        String usuario = "root";
        String contrasenya = "";

        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, contrasenya);

            String respuesta;
            do {
                System.out.println("Ingrese el NIA del alumno:");
                int nia = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                System.out.println("Ingrese el nombre del alumno:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese la edad del alumno:");
                int edad = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                String consulta = "INSERT INTO ALUMNOS (nia, nombre, edad) VALUES (?, ?, ?)";
                ps = conn.prepareStatement(consulta);
                ps.setInt(1, nia);
                ps.setString(2, nombre);
                ps.setInt(3, edad);
                ps.executeUpdate();

                System.out.println("Alumno insertado con éxito.");
                System.out.println("¿Desea insertar otro alumno? (s/n)");
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
