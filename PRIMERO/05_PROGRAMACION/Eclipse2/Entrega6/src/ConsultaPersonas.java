import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Ejercicio 2 
public class ConsultaPersonas {

	public static void main(String[] args) {

		// URL de conexión a la base de datos
		String url = "jdbc:mysql://localhost:3306/pruebabd";

		// Nombre de usuario y contraseña de la base de datos
		String usuario = "root";
		String contrasenya = "";

		// Query SQL para obtener todos los datos de la tabla "personas"
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

			// Mostrar los datos de las personas accediendo a los campos
			while (rs.next()) {
				
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				int edad = rs.getInt("edad");
				
				System.out.println(dni + "\t" + nombre + "\t" + edad);
			}
		} catch (ClassNotFoundException e) {

			// Manejar excepciones de carga de driver JDBC
			System.out.println("No se pudo cargar el driver JDBC");
			e.printStackTrace();
			
		} catch (SQLException e) {

			// Manejar excepciones de SQL
			System.out.println("Error al conectarse a la base de datos:");
			e.printStackTrace();
			
		} finally {
			// Cerrar las conexiones
			try {

				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
				
			} catch (SQLException e) {
				
				// Manejar excepciones de SQL al cerrar los objetos
				System.out.println("Error al cerrar las conexiones");
				e.printStackTrace();
				
			}
		}
	}
}