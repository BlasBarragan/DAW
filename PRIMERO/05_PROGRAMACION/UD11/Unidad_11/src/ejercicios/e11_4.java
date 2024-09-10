package ejercicios;

//Ejercicio 11.4: Creación de una Base de Datos

import java.sql.*;

public class e11_4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String contrasenya = "";

        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, contrasenya);

            // Crear la base de datos "instituto"
            System.out.println("Creando base de datos...");
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE instituto";
            stmt.executeUpdate(sql);
            System.out.println("Base de datos creada exitosamente...");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error durante la conexión o la consulta.");
            e.printStackTrace();
        } finally {
            // Cerrar conexiones
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones.");
                e.printStackTrace();
            }
        }
    }
}

