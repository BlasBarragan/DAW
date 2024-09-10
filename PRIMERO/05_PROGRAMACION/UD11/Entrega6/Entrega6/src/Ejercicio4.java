import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class Ejercicio4 {

	public static void main(String[] args) {

		// URL de conexión a la base de datos
		String url = "jdbc:mysql://localhost:3306/"; // No debes indicar la BD en la url

		// Nombre de usuario y contraseña de la base de datos
		String usuario = "root";
		String contrasenya = "";

		// Solicitamos a usuario el nombre de la DB
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica un nombre para la base de datos: ");
		String sql = "CREATE DATABASE " + sc.next();

		Connection conn = null;
		Statement stmt = null;

		// Paso 2: Abrir la conexión
		try {
			// Cargamos el driver JDBC
			conn = DriverManager.getConnection(url, usuario, contrasenya);

			// Paso 3: Ejecutar una consulta SQL
			System.out.println("Creando base de datos...");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Base de datos creada exitosamente...");

			// Manejar excepciones de conexion
		} catch (CommunicationsException e) {

			System.out.println("Error de conexion");
			e.printStackTrace();

			// Manejar excepciones de SQL
		} catch (SQLException e) {

			System.out.println("Error al crear la base de datos.");
			e.printStackTrace();

		} finally {

			// Cerrar las conexiones
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

				// Manejar excepciones de SQL al cerrar los objetos
				System.out.println("Error al cerrar las conexiones");
				e.printStackTrace();

			}
		}

	}

}
