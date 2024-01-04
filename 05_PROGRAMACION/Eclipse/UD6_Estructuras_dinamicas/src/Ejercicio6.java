/**
 * Ejercicio 6. Implementar un filtro de fechas
 * 
 * Programa para que una vez recogidas las fechas en formato,
 * DD/MM/AAAA introducidas por el usuario.
 * Se muestre que fechas de las introducidas son unicas.
 * 
 * Se ingresaran fechas hasta que se introduzca la palabra "fin".
 * Se comprobara formato y rango de las fechas introducidas.
 * Las fechas se convertiran a objeto Calendar.
 * El programa devolvera el numero total de fechas unicas.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ejercicio6 {

	// Creamos ArrayList para almacenar las fechas(String) de usuario.
	private static ArrayList<String> arrayFechas = new ArrayList<String>();
	// Creamos HashSet para almacenar objetos GregorianCalendar,
	private static HashSet<GregorianCalendar> calendario = new HashSet<GregorianCalendar>();

	public static void main(String[] args) {
		ObtenerFecha();
		System.out.println(arrayFechas);
		System.out.println(calendario.size());
	}

	//######## FUNCIONES #########
	public static void ObtenerFecha() {

		// Solicitamos fechas
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca las fechas con formato DD/MM/AAAA \n");

		// Creamos un patron del formato de fecha que queremos utilizar
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar gc = new GregorianCalendar(); // Creamos un calendario
		Date fechaUsuario = null; 

		// Declaramos variables
		String fecha = "";
		String salida = "fin";

		//Comprobamos la validez del dato introducido por el usuario
		while (!fecha.equals(salida)) { // Mientras fecha no sea igual que salida
			System.out.println("Si has acabado, ingresa fin");
			fecha = sc.nextLine();
			if (fecha.equals(salida)) { // Si fecha es igual que salida(fin)
			} else {
				try {
					fechaUsuario = formatoFecha.parse(fecha); // Pasamos texto a fecha
					String [] fechaSeparada = fecha.split("/"); // Obtenemos valores para los int de la String
					int dia = Integer.parseInt(fechaSeparada[0]); 
					int mes = Integer.parseInt(fechaSeparada[1]);
					int ano = Integer.parseInt(fechaSeparada[2]);
					if (dia >= 01 && dia <= 30) { // Definimos rango para dia
						if (mes >= 01 && mes <= 12) { // Definimos rango para mes
							//gc.setTime(fechaUsuario); 
							/*
							 * Dado que la fecha introducida por el usuario la paso a tipo Date con el formato requerido,
							 * Podriamos de esta manera añadir las fechas al HashSet "calendario"
							 * ahorrandonos trabajar con las subcadenas dia, mes, ano?
							 */
							gc.set(dia, mes, ano);
							calendario.add(gc); // Añadimos a calendario

							arrayFechas.add(fecha); // Añadimos fecha al array
							System.out.println("Fecha añadida");
						}else {
							System.out.println("Formato de fecha incorrecto, meses de 01 a 12");
						}
					}else {
						System.out.println("Formato de fecha incorrecto, dias de 01 a 31");
					}
				} catch (ParseException e) { // Si el formato de fecha no es correcto
					//e.printStackTrace(); // Imprime el error
					System.out.println("Formato de fecha incorrecto, debe ser dd/mm/aaaa");
				}
			}
		}
	}

}
