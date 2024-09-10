Practica2_E3.java
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

	public static int CalcularPrecioBillete(char tipo_destino, int numero_noches, char tipo_pago, int dia)
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
		// Forma de pago
		int suplemento_pago = CalcularPago(tipo_pago);
		// Temporada
		int suplemento_temporada= CalcularTemporada(dia);
		
		switch(tipo_destino)
		{
		case 'n': 
			billete = billeteN;
			alojamiento = alojamientoN;
			System.out.println("Destino: Nacional");
			break;
		case 'e': 
			billete = billeteE;
			alojamiento = alojamientoE;
			System.out.println("Destino: Europeo");
			break;
		case 'i': 
			billete = billeteI;
			alojamiento = alojamientoI;
			System.out.println("Destino: Intercontinental");
			break;
		default:
			System.out.println("Error: Opción no valida");
		}
		
		precio = billete + alojamiento * numero_noches + suplemento_pago + suplemento_temporada;
		System.out.println("Precio: " + precio + " Euros");
		return precio;
	}

	public static void ImprimirBillete(String nombre_cliente, char tipo_dest, int numero_noches, int precio, char tipo_pago, int dia)
	{
		String destino = "0";
		String destinoN = "Nacional";
		String destinoE = "Europeo";
		String destinoI = "Intercontinental";
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
		System.out.println("\nNombre: "+nombre_cliente);
		System.out.println("Destino: "+destino);
		System.out.println("Días: "+numero_noches);
		CalcularPrecioBillete(tipo_dest,numero_noches,tipo_pago,dia);
		
	}
	
	public static int CalcularPago(char tipo_pago)
	{
		int recargo_pago = 0;
		
		switch(tipo_pago)
		{
		case 'c': 
			recargo_pago = 20;
			System.out.println("Forma de pago: Tarjeta Crédito/Débito");
			break;
		case 'e': 
			recargo_pago = 0;
			System.out.println("Forma de pago: Efectivo");
			break;
		case 't': 
			recargo_pago = 10;
			System.out.println("Forma de pago: Transferencia bancaria");
			break;
		default:
			System.out.println("Error: Opción no valida");
		}
		return recargo_pago;			
	}
	
	public static int CalcularTemporada(int dia)
	{
		int recargo_temporada = 0;
		
		if (dia >=1 && dia <=10)
		{
			recargo_temporada = 35;
			System.out.println("Temporada: Dias Blancos");
		}
		else if (dia >=15 && dia <=20)
		{
			recargo_temporada = 0;
			System.out.println("Temporada: Dias Rojos");
		}
		else if (dia >=11 && dia <=14 && dia >= 20 && dia <= 30)
		{
			recargo_temporada = 10;
			System.out.println("Temporada: Dias Verdes");
		}
		else
			System.out.println("Error: Dias no disponibles");
		
		return recargo_temporada;
	}
	
	public static void main(String[] args) {
		// Inicialización de Scanner y declaración de variables para Ejercicio1
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		int precio = 0;
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
				System.out.println("\n¿Que dia del mes sería la salida?");
				int dia = sc.nextInt(); 
				sc.nextLine();
				// Imprimimos billete
				ImprimirBillete(nombre,tipo_dest,noches,precio,tipo_pago,dia);
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

