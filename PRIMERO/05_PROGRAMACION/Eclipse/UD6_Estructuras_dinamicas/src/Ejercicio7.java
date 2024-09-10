
/**
 * Ejercicio 7. Implementar el control de acceso a un area restringida de un programa.
 * 
 * Lo primero que pedirá el programa es usuario/contraseña.
 * -Si el usuario es admin (admin/1234), se mostrara el mensaje: "Ha accedido al area restringida como admin".
 * Y se mostrara el siguiente menu.
 * 1. Registrar nuevo usuario.
 * 	-Pedira usuario y contraseña nuevos.
 * 	-Avisa si ya existe.
 * 	-Contraseña numerica max 4 caracteres.
 * 2. Listar usuarios del sistema.
 * 	-Muesta usuarios registrados pero no las contraseñas.
 * 	-El formato, debe ser (usu1:usu2:usu3).
 * 3. Eliminar usuario del sistema.
 * 	-Se pedira usuario y debe confirmar la eliminacion,
 * 4. Actualizar contraseña de usuario.
 * 	-Se pedira el nombre de un usuario y la contrseña.
 * 	-En caso de no existir el usuario, se advertira.
 * 5. Salir.
 * 	-Termina el programa.
 * -Si el usuario NO es admin, se mostrara el mensaje: "Ha accedido al area restringida".
 * Y terminara el programa.
 * 
 * -En cualquier caso se tendran 3 intentos para introducir la contraseña correcta.
 * Si se agotan los intetos, se mostrara el mensaje: "Lo siento, no tiene acceso al area restringida".

 */
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio7 {

	// Creamos el HashMap para almacenar usuario:contraseña(clave:valor)
	private static HashMap<String, Integer> controlAcceso = new HashMap<String, Integer>();
	// Creamos Scanner para capturar introduccion del usuario.
	static Scanner sc = new Scanner(System.in);

	// ######## Declaracion Variables #######
	static String user = "";
	static Integer pass = 0000;

	public static void main(String[] args) {
		AnadirUsuario(); // Añadimos la cuenta de administrador y varios usuarios al diccionario.
		PedirContrasena(); // Inicia el login al sistema.
	}

	// ######## FUNCIONES #########
	/**
	 * Funcion AnadirUsuario
	 * 
	 * Añade las credenciales de admin y varios usuarios genericos para comprobar el
	 * funcionamiento del programa.
	 */
	public static void AnadirUsuario() {

		// Añadimos el login de admin.
		controlAcceso.put("admin", 1234);

		// Añadimos usuarios genericos para pruebas.
		controlAcceso.put("user1", 0001);
		controlAcceso.put("user2", 0002);
		controlAcceso.put("user3", 0003);
		controlAcceso.put("user4", 0004);
		controlAcceso.put("user5", 0005);
	}

	/**
	 * Funcion PedirContrasena
	 * 
	 * Solicita al usuario los datos de login al area restringida del programa y los
	 * valida con lo almacenado en el HashMap.
	 */
	public static void PedirContrasena() {
		int intentos = 2; // Inicializamos los intentos de usuario o contraseña fallidos.
		System.out.println("==== GESTOR DE USUARIOS DEL SISTEMA ====\n");
		System.out.println("Porfavor, introduce los siguientes datos para continuar =>");

		if (intentos <= 0) { // Si se agotan los intentos.
			System.out.println("\nLo siento, no tiene acceso al area restringida.");
		} else {
			System.out.print("\n Usuario: ");
			user = sc.next(); // Pedimos usuario.
			while (!controlAcceso.containsKey(user)) { // Mientras el usuario no exista.
				if (intentos > 0) { // Si quedan intentos.
					System.out.println("Usuario incorrecto");
					intentos--; // Restamos 1 intento.
					System.out.println("Intentos: " + (intentos + 1));
					System.out.print("\n Usuario: ");
					user = sc.next(); // Pedimos usuario de nuevo.
				} else { // Si no quedan intentos.
					System.out.println("\nLo siento, no tiene acceso al area restringida.");
					return; // Terminamos ejecucion del programa.
				}
			}
			System.out.print("\n Contraseña: ");
			pass = sc.nextInt(); // Pedimos contraseña.
			while (!controlAcceso.get(user).equals(pass)) { // Mientras contraseña de usuario y pass no coincidan.
				if (intentos > 0) { // Si quedan intentos.
					System.out.println("Contraseña incorrecta");
					intentos--; // Restamos 1 intento.
					System.out.println("Intentos: " + (intentos + 1));
					System.out.print("\n Contraseña: ");
					pass = sc.nextInt(); // Pedimos contraseña.
				} else { // Si no quedan intentos.
					System.out.println("\nLo siento, no tiene acceso al area restringida.");
					return; // Terminamos ejecucion del programa.
				}
			}
			if (user.equals("admin") && pass == 1234) {
				System.out.println("\nHa accedido al area restringida como administrador.");
				MenuAdmin(); // Llamamos al menu de administracion.
			} else {
				System.out.println("\nHa accedido al area restringida");
			}
		}
	}

	/**
	 * Funcion MenuAdmin
	 * 
	 * Muestra el menu de administracion.
	 */
	public static void MenuAdmin() {
		int opcion = 0; // Declaramos opcion para recoger la seleccion.
		do {
			System.out.println("\n< ***!$!$!$ AREA RESTRINGIDA $!$!$!*** >\n");
			System.out.println("1-> Registrar nuevo usuario");
			System.out.println("2-> Listar usuarios del sistema");
			System.out.println("3-> Eliminar usuario del sistema");
			System.out.println("4-> Actualizar contraseña de usuario");
			System.out.println("5-> Salir\n");
			System.out.println("Elija una opcion: ");

			opcion = sc.nextInt(); // Obtenemos digito de usuario.
			sc.nextLine(); // Consumo retorno de carro.

			switch (opcion) {
			case 1:
				RegistrarNuevo();
				break;
			case 2:
				ListarUsuario();
				break;
			case 3:
				EliminarUsuario();
				break;
			case 4:
				ActualizarContrasena();
				break;
			case 5:
				break;
			default:
				System.out.println("Opcion no válida!");
			}// FIN switch
		} while (opcion != 5); // FIN do
		System.out.println("< ==== Salir ==== >");
	}

	/**
	 * Funcion RegistrarNuevo
	 * 
	 * Añade nuevos usuarios. Se comprueba que no exista el usuario previamente y
	 * que la contraseña sea numerica con maximo 4 digitos.
	 */
	private static void RegistrarNuevo() {
		System.out.println("< ==== Registrar nuevo usuario ==== > \n");
		System.out.println("Nuevo Usuario: ");
		String nuevoUsuario = sc.next();

		while (controlAcceso.containsKey(nuevoUsuario)) { // Mientras el usuario introducido YA exista.
			System.out.println("Error: El usuario ya existe");
			System.out.println("\nNuevo Usuario: ");
			nuevoUsuario = sc.next();
		}
		System.out.println("Nueva contraseña: ");
		Integer nuevaPass = sc.nextInt();
		while (nuevaPass < 0 || nuevaPass > 9999) {
			System.out.println("Error: La contraseña debe ser numerica max. 4 digitos");
			System.out.println("\nNueva contraseña: ");
			nuevaPass = sc.nextInt();
		}
		controlAcceso.put(nuevoUsuario, nuevaPass);
		System.out.println(
				"Nuevo usuario: " + nuevoUsuario + "\nCon la contraseña: " + nuevaPass + "\nCreado correctamente. \n");
	}

	/**
	 * Funcion ListarUsuario
	 * 
	 * Muestra los usuarios registrados en el programa.
	 */
	private static void ListarUsuario() {
		System.out.println("< ==== Registro de usuarios ==== > \n");
		for (String clave : controlAcceso.keySet()) {
			System.out.print(clave + ":");
		}
		System.out.println("\n");
	}

	/**
	 * Funcion EliminarUsuario
	 * 
	 * Pide un nombre de usuario, lo busca en el programa y lo elimina.
	 */
	private static void EliminarUsuario() {
		System.out.println("< ==== Eliminar usuario ==== > \n");
		System.out.print("Usuario: ");
		String eliminarUsuario = sc.next();
		if (controlAcceso.containsKey(eliminarUsuario)) {
			controlAcceso.remove(eliminarUsuario);
			if (!controlAcceso.containsKey(eliminarUsuario)) {
				System.out.println("El usuario: " + eliminarUsuario + " ha sido eliminado con exito.");
			}
		} else {
			System.out.println("Usuario no encontrado");
		}
	}

	/**
	 * Funcion ActualizarContrasena
	 * 
	 * Pide un usuario y una contresaña, para despues actualizar el valor de la
	 * contraseña anterior.
	 */
	private static void ActualizarContrasena() {
		System.out.println("< ==== Actualizar contraseña ==== > \n");
		System.out.print("Usuario: ");
		String actualizarUsuario = sc.next();
		if (controlAcceso.containsKey(actualizarUsuario)) {
			System.out.println("El usuario: " + actualizarUsuario + " con contraseña: "
					+ controlAcceso.get(actualizarUsuario) + " será actualizado.");
			System.out.println("Indique una nueva contraseña.");
			System.out.print("Contraseña: ");
			Integer nuevaContrasena = sc.nextInt();
			while (!(nuevaContrasena >= 0 && nuevaContrasena <= 9999)) {
				System.out.println("Error: La contraseña debe ser numerica max. 4 digitos");
				System.out.print("\n Contraseña: ");
				nuevaContrasena = sc.nextInt();
			}
			System.out.println(
					"La contraseña: " + controlAcceso.replace(actualizarUsuario, nuevaContrasena) + " del usuario: "
							+ actualizarUsuario + " ha sido actualizada por el nuevo valor: " + nuevaContrasena + ".");
		} else {
			System.out.println("Usuario no encontrado");
		}
	}
}
