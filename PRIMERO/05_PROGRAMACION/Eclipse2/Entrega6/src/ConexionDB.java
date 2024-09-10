import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {

	protected Connection conexion;
	protected Statement sentencia;
	protected ResultSet resultSet;
	protected PreparedStatement insertar;

	// Conexion MySQL
	protected String cadenaDriver = "com.mysql.cj.jdbc.Driver";
	protected String url = "jdbc:mysql://localhost:3306/";
	String user = "root";
	String pass = "";
	
	// Conexion a MySQL.
	public ConexionDB() {

		try {
			Class.forName(cadenaDriver);
			conexion = DriverManager.getConnection(url, user, pass);

		} catch (SQLException e) {

			System.out.println("No se ha podido realizar la conexion");
			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("No se ha encontrado el driver");
			e.printStackTrace();

		}
	}
	
	// Conexion indicando DB concreta.
	public ConexionDB(String db) {

		this.url = url + db;
		try {
			Class.forName(cadenaDriver);
			conexion = DriverManager.getConnection(url, user, pass);

		} catch (SQLException e) {

			System.out.println("No se ha podido realizar la conexion");
			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("No se ha encontrado el driver");
			e.printStackTrace();

		}
	}
	
	// Conexion indicando driver y url.
	public ConexionDB(String cadenaDriver, String url) {

		try {
			Class.forName(cadenaDriver);
			conexion = DriverManager.getConnection(url, user, pass);

		} catch (SQLException e) {

			System.out.println("No se ha podido realizar la conexion");
			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("No se ha encontrado el driver");
			e.printStackTrace();

		}
	}

	// Cierra la conexion existente.
	public void cerrarConexionDB() {

		try {

			if (resultSet != null) {
				resultSet.close();
			}
			if (conexion != null)
				conexion.close();
			//System.out.println("Conexion cerrada");
			
		} catch (SQLException e) {

			System.out.println("No se ha podido cerrar la conexion con la DB");
			e.printStackTrace();
		}
	}

	// Ejecuta consultas SQL (executeQuery).
	public void ejecutarConsulta(String consulta) {
		
		try { 
			
			sentencia = conexion.createStatement();
			resultSet = sentencia.executeQuery(consulta);
			
		} catch (SQLException e) {
			
			System.out.println("No se ha podido ejecutar la consulta");
			e.printStackTrace();
		}
	}
	
	// Ejecuta instrucciones SQL (executeUpdate) y devuelve int de filas afectadas.
	public int ejecutarInstruccion(String instruccion) { 
		
		int filas = 0;
		
		try {
			
			sentencia = conexion.createStatement();
			filas = sentencia.executeUpdate(instruccion);
			
			System.out.println("Instruccion realizada con exito.");
			
			// Manejar excepciones de conexion
		} catch (CommunicationsException e) {

			System.out.println("Error de conexion");
			e.printStackTrace();

			// Manejar excepciones de SQL
		} catch (SQLException e) {
			if (e.getErrorCode()== 1007) {
				System.out.println("La base de datos indicada ya existe");
			} else if (e.getErrorCode()== 1050) {
				System.out.println("La tabla indicada ya existe");
			} else {
				System.out.println("No se ha podido ejecutar la instruccion");
				e.printStackTrace();
			}
		}
		
		
		return filas;
	}
	
	// Inserta nueva fila de alumno en la tabla indicada.
	public void insertarFila(String tabla, String nia, String nombre, int edad) {
		
		String insert = "INSERT INTO " + tabla + " VALUES (?, ?, ?)";
		
		try { 
			// Preparamos instruccion
			insertar = conexion.prepareStatement(insert);			
			
			// Establecemos los valores de los parámetros utilizados
			insertar.setString(1, nia);
			insertar.setString(2, nombre);
			insertar.setInt(3, edad);

			try { // Lanzamos la instruccion
		        insertar.executeUpdate();
		        System.out.println("Inserción realizada con éxito.");
		    } catch (SQLException e) {
		    	if (e.getErrorCode()== 1062) {
					System.out.println("Error: El nia " + nia + " ya existe en la base de datos.");
		    	} else{
		    		System.out.println("Error al ejecutar la inserción.");
		    		e.printStackTrace();
		    	}
		    }
		    	
		} catch (SQLException e) {
			
			System.out.println("Error al preparar la insercion");
			e.printStackTrace();
		}
	}
}
