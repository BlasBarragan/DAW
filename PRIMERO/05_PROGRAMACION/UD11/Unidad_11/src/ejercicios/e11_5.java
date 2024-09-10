package ejercicios;

//Ejercicio 11.5: Crear una Tabla "ALUMNOS"


import java.sql.*;

public class e11_5 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String url = "jdbc:mysql://localhost:3306/instituto";
        String usuario = "root";
        String contrasenya = "";

        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, contrasenya);

            // Crear la tabla "ALUMNOS"
            System.out.println("Creando tabla ALUMNOS...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE ALUMNOS (nia INT PRIMARY KEY, nombre VARCHAR(255), edad INT)";
            stmt.executeUpdate(sql);
            System.out.println("Tabla ALUMNOS creada exitosamente...");

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
