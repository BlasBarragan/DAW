
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio5a8 {

	public static void main(String[] args) {

		// Preguntamos nombre de DB y creamos.
		String NombreDB = crearDB();
		// Creamos tabla ALUMNOS sobre DB.
		String tabla = crearTabla(NombreDB);

		int menu;
		do {
			// Menu programa
			System.out.println("<--- GESTION DB --->");
			System.out.println("DB: " + NombreDB + " TABLA: ALUMNOS");
			System.out.println("Selecciona la opcion deseada:");
			System.out.println("1: Insertar Alumnos");
			System.out.println("2: Modificar edad Alumno");
			System.out.println("3: Eliminar Alumno");
			System.out.println("4: Salir");

			Scanner sc = new Scanner(System.in);
			menu = sc.nextInt();
			switch (menu) {
			case 1: { // Insertar Alumnos
				insertarAlumnos(NombreDB, tabla);
				break;
			}
			case 2: { // Modificar edad de Alumno
				modificarEdad(NombreDB, tabla);
				break;
			}
			case 3: { // Eliminar Alumno
				eliminarAlumno(NombreDB, tabla);
				break;
			}
			case 4: { // Salir
				break;
			}
			default:
				throw new IllegalArgumentException("Opcion no valida: " + menu);
			}
		} while (menu != 4);
		System.out.println("<--- FIN PROGRAMA --->");
	}

	// Pregunta al usuario por el nombre de la DB a crear y se crea.
	// Preguntamos a usuario el nombre de la base de datos para trabajar y se crea.
	public static String crearDB() {

		// Solicitamos a usuario el nombre de la DB
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica un nombre para la base de datos: ");
		String db = sc.next();
		String sql = "CREATE DATABASE " + db;

		// Conectamos a DB
		ConexionDB conn = new ConexionDB();

		// Paso 3: Ejecutar una consulta SQL
		System.out.println("Creando base de datos...");
		conn.ejecutarInstruccion(sql);

		// Cerrar las conexiones
		conn.cerrarConexionDB();

		return db;
	}

	// Ejercicio 5 - Crea tabla ALUMNOS en la DB con los campos nia, nombre y edad.
	public static String crearTabla(String NombreDB) {

		String tabla = "ALUMNOS";
		String instruccion = "CREATE TABLE " + NombreDB + "." + tabla
				+ " (nia varchar(255) NOT NULL, nombre varchar(255) NOT NULL, edad int NOT NULL, PRIMARY KEY(nia));";

		// Conectamos a DB
		ConexionDB conn = new ConexionDB();

		// Ejecutamos instruccion SQL
		System.out.println("Creando tabla ALUMNOS en " + NombreDB + "...");
		conn.ejecutarInstruccion(instruccion);

		// Cerramos coniexion
		conn.cerrarConexionDB();

		return tabla;
	}

	// Ejercicio 6 - Inserta alumnos en la tabla ALUMNOS.
	public static void insertarAlumnos(String NombreDB, String tabla) {

		String db = NombreDB;
		String tb = tabla;

		String nia;
		String nombre;
		int edad;

		String respuesta;

		do {

			Scanner sc = new Scanner(System.in);
			System.out.println("Quieres añadir datos a la tabla " + tb + " ? s/n");
			respuesta = sc.next();

			if (respuesta.equalsIgnoreCase("s")) {

				// Solicitamos datos al usuario
				System.out.println("Indica el nia:");
				nia = sc.next();
				sc.nextLine();
				System.out.println("Indica el nombre:");
				nombre = sc.nextLine();
				System.out.println("Indica la edad:");
				edad = sc.nextInt();

				// Conectamos a DB
				ConexionDB conn = new ConexionDB(db);
				// Ejecutamos SQL
				conn.insertarFila(tb, nia, nombre, edad);
				// Cerramos conexion
				conn.cerrarConexionDB();
			} else if (respuesta.equalsIgnoreCase("n")) {
				break;
			} else {
				System.out.println("Respuesta erronea. Por favor introduce 's' o 'n'");
			}
		} while (!respuesta.equalsIgnoreCase("n"));

		System.out.println("Volviendo a menu principal");

	}

	// Ejercicio 7 - Modifica edad de Alumno en DB.
	public static void modificarEdad(String NombreDB, String tabla) {

		String db = NombreDB;
		String tb = tabla;

		String nia;
		int edad;

		String consulta = "SELECT * FROM " + tb;
		String respuesta;

		do {

			// Pregunta si se quiere modificar un alumno.
			Scanner sc = new Scanner(System.in);
			System.out.println("Quieres modificar la edad de un alumno? s/n");
			respuesta = sc.next();

			// Si si
			if (respuesta.equalsIgnoreCase("s")) {

				// Conectamos a DB
				ConexionDB conn = new ConexionDB(db);

				try {
					// Lee los registros de la tabla
					System.out.println("Alumnos registrados en la tabla:");
					conn.ejecutarConsulta(consulta);

					// Muestra todas las filas de la tabla
					while (conn.resultSet.next()) {

						String DBnia = conn.resultSet.getString("nia");
						String DBnombre = conn.resultSet.getString("nombre");
						int DBedad = conn.resultSet.getInt("edad");

						System.out.println(DBnia + "\t" + DBnombre + "\t" + DBedad);
					}

				} catch (SQLException e) {
					// Manejar excepciones de SQL
					System.out.println("Error al conectarse a la base de datos:");
					e.printStackTrace();
				}

				// Solicitamos datos al usuario
				System.out.println("Indica el nia del alumno a modificar:");
				nia = sc.next();
				sc.nextLine();

				// Mostramos la fila que coincide con los datos del usuario
				String consultaAlumno = "SELECT * FROM " + tb + " WHERE nia = '" + nia + "';";
				try {
					conn.ejecutarConsulta(consultaAlumno);

					if (!conn.resultSet.next()) {
						System.out.println("nia no encontrado");
						continue;
					}

					String DBnia = conn.resultSet.getString("nia");
					String DBnombre = conn.resultSet.getString("nombre");
					int DBedad = conn.resultSet.getInt("edad");

					// if (DBnia.equalsIgnoreCase(nia)) {

					System.out.println("Alumno a modificar: ");
					System.out.println(DBnia + "\t" + DBnombre + "\t" + DBedad);

					System.out.println("Indica la edad modificada:");
					edad = sc.nextInt();

					String modEdad = "UPDATE " + tb + " SET edad = " + edad + " WHERE nia = '" + nia + "'";
					// Ejecutamos el cambio de edad
					conn.ejecutarInstruccion(modEdad);
					// Ejecutamos de nuevo la consuta para mostrar los cambios
					conn.ejecutarConsulta(consultaAlumno);

					while (conn.resultSet.next()) {
						DBnia = conn.resultSet.getString("nia");
						DBnombre = conn.resultSet.getString("nombre");
						DBedad = conn.resultSet.getInt("edad");

						System.out.println("Alumno actualizado: ");
						System.out.println(DBnia + "\t" + DBnombre + "\t" + DBedad);
					}

				} catch (SQLException e) {
					System.out.println("Error durante la consulta.");
		            e.printStackTrace();
				} finally {

					// Cerramos conexion
					conn.cerrarConexionDB();
				}

			} else if (respuesta.equalsIgnoreCase("n")) {
				break;
			} else {
				System.out.println("Respuesta erronea. Por favor introduce 's' o 'n'");
			}
		} while (!respuesta.equalsIgnoreCase("n"));

		System.out.println("Volviendo a menu principal");
	}

	// Ejercicio 8 - Elimina alumnos de la tabla ALUMNOS.
	public static void eliminarAlumno(String NombreDB, String tabla) {

		String db = NombreDB;
		String tb = tabla;

		String nia;

		String consulta = "SELECT * FROM " + tb;
		String respuesta;

		do {

			// Pregunta si se quiere eliminar un alumno.
			Scanner sc = new Scanner(System.in);
			System.out.println("Quieres eliminar un alumno de la DB? s/n");
			respuesta = sc.next();

			// Si si
			if (respuesta.equalsIgnoreCase("s")) {

				// Conectamos a DB
				ConexionDB conn = new ConexionDB(db);

				try {
					// Lee los registros de la tabla
					System.out.println("Alumnos registrados en la tabla:");
					conn.ejecutarConsulta(consulta);

					// Muestra todas las filas de la tabla
					while (conn.resultSet.next()) {

						String DBnia = conn.resultSet.getString("nia");
						String DBnombre = conn.resultSet.getString("nombre");
						int DBedad = conn.resultSet.getInt("edad");

						System.out.println(DBnia + "\t" + DBnombre + "\t" + DBedad);
					}

				} catch (SQLException e) {
					// Manejar excepciones de SQL
					System.out.println("Error al conectarse a la base de datos.");
					e.printStackTrace();
				}

				// Solicitamos datos al usuario
				System.out.println("Indica el nia del alumno a eliminar:");
				nia = sc.next();
				sc.nextLine();

				// Verificamos nia y mostramos la fila que coincide con los datos del usuario
				String consultaAlumno = "SELECT * FROM " + tb + " WHERE nia = '" + nia + "';";
				try {
					conn.ejecutarConsulta(consultaAlumno);

					if (!conn.resultSet.next()) {
						System.out.println("nia no encontrado");
						continue;
					}

					String DBnia = conn.resultSet.getString("nia");
					String DBnombre = conn.resultSet.getString("nombre");
					int DBedad = conn.resultSet.getInt("edad");

					System.out.println("El Alumno: " + DBnia + "\t" + DBnombre + "\t" + DBedad + " sera eliminado");

					System.out.println("Continuar?: s/n");
					String confirmacion = sc.next();

					if (confirmacion.equalsIgnoreCase("s")) {

						String delUsuario = "DELETE FROM " + tb + " WHERE nia = '" + nia + "'";
						// Ejecutamos la eliminacion
						conn.ejecutarInstruccion(delUsuario);
					} else {
						System.out.println("Operacion abortada");
					}

					// Ejecutamos de nuevo la consuta para mostrar los cambios
					conn.ejecutarConsulta(consulta);
					System.out.println("Alumnos en tabla " + tb + ": ");

					while (conn.resultSet.next()) {
						DBnia = conn.resultSet.getString("nia");
						DBnombre = conn.resultSet.getString("nombre");
						DBedad = conn.resultSet.getInt("edad");

						System.out.println(DBnia + "\t" + DBnombre + "\t" + DBedad);
					}

				} catch (SQLException e) {
					// Manejar excepciones de SQL
					System.out.println("Error al conectarse a la base de datos.");
					e.printStackTrace();
				} finally {
					// Cerramos conexion
					conn.cerrarConexionDB();
				}
			}
			// Si no
			else if (respuesta.equalsIgnoreCase("n")) {
				break;
			} else {
				System.out.println("Respuesta erronea. Por favor introduce 's' o 'n'");
			}
		} while (!respuesta.equalsIgnoreCase("n"));

		System.out.println("Volviendo a menu principal");
	}

}
