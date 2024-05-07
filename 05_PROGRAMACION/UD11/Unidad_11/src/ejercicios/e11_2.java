package ejercicios;

//Ejercicio 11.2: Consulta a la Base de Datos con Bucle do-while

import java.sql.*;

public class e11_2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/personas";
        String usuario = "root";
        String contrasenya = "";
        String consulta = "SELECT * FROM personas";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar a la base de datos
            conn = DriverManager.getConnection(url, usuario, contrasenya);

            // Crear un objeto PreparedStatement para ejecutar la consulta SQL
            ps = conn.prepareStatement(consulta);

            // Ejecutar la consulta y obtener los resultados
            rs = ps.executeQuery();

            // Acceder a los datos de las personas y mostrarlos
            if (rs.next()) {
                do {
                    String dni = rs.getString(1);  // Cambiamos el nombre de campo por
                    String nombre = rs.getString(2); // el número de columna
                    int edad = rs.getInt(3);
                    System.out.println(dni + "\t" + nombre + "\t" + edad);
                } while (rs.next());
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error durante la conexión o la consulta.");
            e.printStackTrace();
        } finally {
            // Cerrar las conexiones
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar las conexiones.");
                e.printStackTrace();
            }
        }
    }
}
