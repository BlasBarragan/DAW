package ejercicios;

//Ejercicio 11.1: Test de Conexión con la Base de Datos

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class e11_1 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Cargamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Definimos la URL, el usuario y el password
            String url = "jdbc:mysql://localhost/pruebabd";
            String usuario = "root"; // por defecto en phpMyAdmin
            String contrasenya = ""; // por defecto en phpMyAdmin

            // Establecemos la conexión con la base de datos
            conn = DriverManager.getConnection(url, usuario, contrasenya);

            // Mensaje de éxito en la conexión
            System.out.println("La conexión se ha realizado con éxito.");

        } catch (SQLException e) {
            System.out.println("No se ha realizado la conexión.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado el driver.");
            e.printStackTrace();
        } finally {
            // Cerramos conexiones
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
