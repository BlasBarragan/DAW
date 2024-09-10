/*
 * Barragán Román, Blas
 * Practica Evaluable 2
 * 
 * Ejercicio 1 Totalmente
 * Ejercicio 2 Totalmente
 * Ejercicio 3 Totalmente
 * Ejercicio 4 Totalmente
 */

import java.util.Scanner;

public class Ejercicio {

	/**
	 *Funcion CalcularPrecioBillete
	 *
	 *Calculamos el precio total del billete, incluyendo alojamiento, recargos y descuentos
	 */
	public static double CalcularPrecioBillete(char tipo_destino, int noches, char tipo_pago, int dia, double descuento_edad)
	{
		double precio = 0;
		double precio_total = 0;
		// variables coste billete
		int billete = 0;
		int billeteN = 100;
		int billeteE = 170;
		int billeteI = 560;
		// variables coste alojamiento
		int alojamiento = 0;
		int alojamientoN = 65;
		int alojamientoE = 100;
		int alojamientoI = 100;
		// variables coste forma de pago
		int suplemento = 0;
		int efectivo = 0;
		int tarjeta = 20;
		int transferencia = 10;

		switch(tipo_destino) //Asociamos precio de billete y alojamiento según destino
		{
		case 'n': 
			billete = billeteN;
			alojamiento = alojamientoN;
			break;
		case 'e': 
			billete = billeteE;
			alojamiento = alojamientoE;
			break;
		case 'i': 
			billete = billeteI;
			alojamiento = alojamientoI;
			break;
		}
		switch(tipo_pago) // Asociamos recargo por forma de pago
		{
		case 'e': 
			suplemento = efectivo;
			break;
		case 'c': 
			suplemento = tarjeta;
			break;
		case 't': 
			suplemento = transferencia;
			break;
		}

		if (noches >7)	// descuento por larga estancia
			billete = billete - 30;

		precio = billete + alojamiento*noches + suplemento + CalcularTemporada(dia);
		precio = precio - (precio*descuento_edad);

		if (precio > 1200.0) // Descuento gran importe
			precio_total = precio-(precio * 0.02);
		else
			precio_total = precio;

		return precio_total;
	}

	/**
	 *Funcion ImprimirBillete
	 *
	 *Mostramos en pantalla los detalles y el precio total del viaje
	 */
	public static void ImprimirBillete(String nombre, char tipo_destino, int noches, double precio, char tipo_pago)
	{
		// Variable tipo de vuelo
		String destino = "0";
		String destinoN = "Nacional";
		String destinoE = "Europeo";
		String destinoI = "Intercontinental";
		// Variables tipo de pago
		String formaPago = "0";
		String pagoC = "Tarjeta Crédito/Débito";
		String pagoE = "Efectivo";
		String pagoT = "Transferencia bancaria";

		switch(tipo_destino) // Asociamos destino
		{
		case 'n': 
			destino = destinoN;
			break;
		case 'e': 
			destino = destinoE;
			break;
		case 'i': 
			destino = destinoI;
			break;
		default:
			System.out.println("Error: Opción no valida");
		}
		switch(tipo_pago)	// Asociamos tipo de pago 
		{
		case 'c': 
			formaPago = pagoC;
			break;
		case 'e': 
			formaPago = pagoE;
			break;
		case 't': 
			formaPago = pagoT;
			break;
		default:
			System.out.println("Error: Opción no valida");
		}
		// Imprime billete
		System.out.println("\nNombre: "+nombre);
		System.out.println("Destino: "+destino);
		System.out.println("Días: "+noches);
		System.out.println("Forma de pago: "+formaPago);
		System.out.println("Precio: "+precio+ " euros");
	}

	/**
	 *Funcion CalcularTemporada
	 *Requisito de Ejercicio 3
	 *Calculamos el recargo y el color de la temporada seleccionada, según el dia de inicio del viaje
	 */
	public static int CalcularTemporada(int dia)
	{
		int recargo_temporada = 0;

		if (dia >=1 && dia <=10)
		{
			recargo_temporada = 35;
			System.out.print("Temporada: Dias Blancos");
		}
		else if (dia >=15 && dia <=20)
		{
			recargo_temporada = 0;
			System.out.print("Temporada: Dias Rojos");
		}
		else if (dia >=11 && dia <=14 || dia >= 20 && dia <= 30)
		{
			recargo_temporada = 10;
			System.out.print("Temporada: Dias Verdes");
		}
		else
			System.out.println("Error: Dias no disponibles");

		return recargo_temporada;
	}

	public static double CalcularDescuentoEdad(int edad)
	{
		double descuento_edad = 0;

		if (edad <7)
			descuento_edad = 0.5;
		else if (edad >7 && edad <25)
			descuento_edad = 0.2;
		else if (edad >65)
			descuento_edad = 0.25;

		return descuento_edad;
	}

	/**
	 *Funcion main
	 *Solicitamos los datos necesarios para calcular el coste del viaje y hacer la reserva
	 *Los datos se validan al ser intraducidos para evitar errores
	 */
	public static void main(String[] args) {

		// Inicialización de Scanner y declaración de variables para Ejercicio1
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		double facturacion = 0.0;
		int num_reservas = 0;
		char tipo_destino = '0';

		// Declaración de variables para Ejercicio2
		char tipo_pago = '0';

		// Mostramos menu de selección por pantalla
		do 
		{
			System.out.println("\n---Menú Principal---");
			System.out.println("1. Añadir cliente");
			System.out.println("2. Ver resumen de día");
			System.out.println("3. Salir");
			System.out.println("\nElija una opción: ");
			// Solicitamos opcion deseada
			opcion = sc.nextInt();

			switch(opcion)
			{
			case 1: // Opción 1 = Nuevo Cliente

				// Solicitud nombre cliente
				System.out.print("\nAñadir cliente...");
				sc.nextLine();
				System.out.println("\nNombre cliente: ");
				String nombre = sc.nextLine();

				/**
				 * Añadimos requisito Ejercicio 4
				 * Solicitud de edad para calculo de descuento
				 */
				//Solicitud edad pasajero
				System.out.println("Edad cliente: ");
				int edad = sc.nextInt();
				double descuento_edad = CalcularDescuentoEdad(edad); // Llamamos a la funcion para que calcule el descuento según la edad
				sc.nextLine();

				// Solicitud del tipo de vuelo
				do 
				{
					System.out.print("\n¿Que tipo de vuelo realizará?");
					System.out.println("\nNacional (N)");
					System.out.println("Europeo (E)");
					System.out.println("Intercontinental (I)");
					tipo_destino = Character.toLowerCase(sc.nextLine().charAt(0));// Almacenamos caracter en minusculas
					switch(tipo_destino) // 
					{
					case 'n': 
						break;
					case 'e': 
						break;
					case 'i': 
						break;
					default:
						System.out.println("Error: Opción no valida");
					}
				}
				while(tipo_destino != 'n' && tipo_destino != 'e' && tipo_destino != 'i'&& tipo_destino != 'N' && tipo_destino != 'E' && tipo_destino != 'I');
				{
				} // Salimos del do-while

				// Solicitud dias viaje
				System.out.println("\n¿Cuantas noches?");
				int noches = sc.nextInt(); 
				sc.nextLine();

				/**
				 *  Añadimos requisito Ejercicio2
				 *  Solicitud de una forma de pago con calculo de recargo segun eleccion
				 */
				// Solicitud forma de pago
				do
				{
					System.out.print("\n¿Como desea pagar?");
					System.out.println("\nTarjeta de Crédito/Débito +20€ (C)");
					System.out.println("Efectivo (E)");
					System.out.println("Transferencia Bancaria +10€ (T)");
					tipo_pago = Character.toLowerCase(sc.nextLine().charAt(0)); // Almacenamos caracter en minusculas
					switch(tipo_pago) // 
					{
					case 'c': 
						break;
					case 'e': 
						break;
					case 't': 
						break;
					default:
						System.out.println("Error: Opción no valida");
					}
				}
				while(tipo_pago != 'c' && tipo_pago != 'e' && tipo_pago != 't'&& tipo_pago != 'C' && tipo_pago != 'E' && tipo_pago != 'T');
				{
				} // Salimos del do-while
				System.out.println("\n¿Que dia del mes sería la salida?");
				int dia = sc.nextInt(); 
				sc.nextLine();
				// Calculamos precio 
				double precio = CalcularPrecioBillete(tipo_destino, noches, tipo_pago, dia, descuento_edad);
				// Imprimimos billete
				ImprimirBillete(nombre, tipo_destino, noches, precio, tipo_pago);
				// Añadimos a facturación
				facturacion = facturacion + precio;
				// Añadimos reserva
				num_reservas = num_reservas +1;
				break;
			case 2: // Opción 2
				System.out.println("\nResumen del dia: ");
				System.out.println("Total de reservas: " + num_reservas);
				System.out.println("Ingresos totales: " + facturacion);	
				break;
			case 3: // Salir
				System.out.println("Billetes emitidos: " + num_reservas);
				System.out.println("Total: " + facturacion);	
				break;
			default: // No existe la opción
				System.out.println("Opción no válida");
			}
		}
		while(opcion !=3);
		{
			sc.close();
			System.out.println("\nHasta mañana!");
		}
	}
}

