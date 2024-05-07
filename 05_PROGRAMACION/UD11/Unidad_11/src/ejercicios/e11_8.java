package ejercicios;

//Ejercicio 11.8: Eliminar un Alumno de la Base de Datos

import java.sql.*;
import java.util.Scanner;

public class e11_8 {
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

            System.out.println("Ingrese el NIA del alumno que desea eliminar:");
            int nia = scanner.nextInt();

            String consulta = "DELETE FROM ALUMNOS WHERE nia = ?";
            ps = conn.prepareStatement(consulta);
            ps.setInt(1, nia);
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Alumno eliminado con éxito.");
            } else {
                System.out.println("No se encontró un alumno con ese NIA.");
            }

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
