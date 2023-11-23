/*
 * Barragán Román, Blas
 * Practica Evaluable 2
 * 
 * Ejercicio 1 Totalmente
 * Ejercicio 2 Totalmente
 * Ejercicio 3 
 * Ejercicio 4 
 */

import java.util.Scanner;

public class Ejercicio {

	public static int CalcularPrecioBillete(char tipo_dest, int noches, char tipo_pago)
	{
		int precio = 0;
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

		switch(tipo_dest)
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
		default:
			System.out.println("Error: Opción no valida");
		}
		switch(tipo_pago)
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
		default:
			System.out.println("Error: Opción no valida");
		}
		precio = billete + alojamiento*noches + suplemento;	
		return precio;
	}

	public static void ImprimirBillete(String nombre, char tipo_dest, int noches, int precio, char tipo_pago)
	{
		String destino = "0";
		String destinoN = "Nacional";
		String destinoE = "Europeo";
		String destinoI = "Intercontinental";
		// Variables tipo de pago
		String formaPago = "0";
		String pagoC = "Tarjeta Crédito/Débito";
		String pagoE = "Efectivo";
		String pagoT = "Transferencia bancaria";
		switch(tipo_dest)
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
		switch(tipo_pago)
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
		System.out.println("\nNombre: "+nombre);
		System.out.println("Destino: "+destino);
		System.out.println("Días: "+noches);
		System.out.println("Forma de pago: "+formaPago);
		System.out.println("Precio: "+precio+ " euros");
	}

	public static void main(String[] args) {
		// Inicialización de Scanner y declaración de variables para Ejercicio1
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		int facturacion = 0;
		int num_reservas = 0;
		char tipo_dest = '0';
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
				// Solicitud del tipo de vuelo
				do 
				{
					System.out.print("\n¿Que tipo de vuelo realizará?");
					System.out.println("\nNacional (N)");
					System.out.println("Europeo (E)");
					System.out.println("Intercontinental (I)");
					tipo_dest = Character.toLowerCase(sc.nextLine().charAt(0));// Almacenamos caracter en minusculas
					switch(tipo_dest) // 
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
				while(tipo_dest != 'n' && tipo_dest != 'e' && tipo_dest != 'i'&& tipo_dest != 'N' && tipo_dest != 'E' && tipo_dest != 'I');
				{
				} // Salimos del do-while
				// Solicitud dias viaje
				System.out.println("\n¿Cuantas noches?");
				int noches = sc.nextInt(); 
				sc.nextLine();
				// Añadimos requisito Ejercicio2
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

				// Calculamos precio 
				int precio = CalcularPrecioBillete(tipo_dest,noches,tipo_pago);
				// Imprimimos billete
				ImprimirBillete(nombre,tipo_dest,noches,precio,tipo_pago);
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
			System.out.println("\nHasta mañana!");
		}
	}
}

