// Clases para conexion con DB

import java.sql.Connection; // Establece conexiones con DB
import java.sql.DriverManager; // Carga un driver
import java.sql.SQLException;

// Ejericio 1
public class TestConexionDB {

	public static void main(String[] args) {
		// Creamos conexion a DB
		Connection conn = null;
		
		try {

			// Cargamos driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Definimos url DB, usuer y pass
			String url = "jdbc:mysql://localhost/pruebabd";
			String user = "root";
			String pass = "";
			
			// Establecemos conexion con la DB
			conn = DriverManager.getConnection(url, user, pass);
			
			// Mensaje conexion completada
			System.out.println("<<<<-- Conexion a DB establecida con exito -->>>>");
		} catch (SQLException e) {
			
			System.out.println("No se ha podido realizar la conexion");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			
			System.out.println("No se ha encontrado el driver");
			e.printStackTrace();
			
		}finally {
			
			// Cerramos conexiones
			try {
				if (conn != null) {
					conn.close();
				}
			}catch (SQLException e) {	
				
				System.out.print("No se ha podido cerrar la conexion con la DB");
				e.printStackTrace();
			}
		}
		
	}

}
