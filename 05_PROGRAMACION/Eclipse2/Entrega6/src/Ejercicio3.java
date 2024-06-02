
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		// URL de conexión a la base de datos
		String url = "jdbc:mysql://localhost:3306/pruebabd";

		// Nombre de usuario y contraseña de la base de datos
		String usuario = "root";
		String contrasenya = "";

		// Query SQL para obtener todos los datos de la tabla "personas"
		String dni;
		String nombre;
		int edad;

		String consulta = "INSERT INTO personas VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String respuesta;
		do {
			
		Scanner sc = new Scanner(System.in);
		System.out.println("Quieres añadir datos a la DB? s/n");
		respuesta = sc.next();
		
			if (respuesta.equalsIgnoreCase("s")) {
				
				System.out.println("Indica el dni:");
				dni = sc.next();
				sc.nextLine();
				System.out.println("Indica el nombre:");
				nombre = sc.nextLine();
				System.out.println("Indica la edad:");
			
				edad = sc.nextInt();
				
				try {
	
					// Cargar el driver JDBC
					Class.forName("com.mysql.cj.jdbc.Driver");
	
					// Conectar a la base de datos
					conn = DriverManager.getConnection(url, usuario, contrasenya);
	
					// Crear un objeto PreparedStatement para ejecutar la consulta SQL
					ps = conn.prepareStatement(consulta);
					
					// Establecemos los valores de los parámetros utilizados
					ps.setString(1, dni);
					ps.setString(2, nombre);
					ps.setInt(3, edad);
	
					// Lanzamos la consulta
					ps.executeUpdate();
	
					System.out.println("Insertado con exito!");
					
					
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
	
						if (rs != null) {
							rs.close();
						}
						if (ps != null) {
							ps.close();
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
			else if (respuesta.equalsIgnoreCase("n")) {
				break;
			}
			else {
				System.out.println("Respuesta erronea. Por favor introduce 's' o 'n'");
			}
		} while (!respuesta.equalsIgnoreCase("n"));
		
		System.out.println("Fin programa");
		
	}

}


