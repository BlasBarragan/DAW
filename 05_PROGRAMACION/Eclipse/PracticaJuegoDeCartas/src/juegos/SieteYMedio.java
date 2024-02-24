package juegos;

import java.util.Scanner;
import barajas.Baraja;
import barajas.Carta;

public class SieteYMedio extends Juego {

// Constructor
	public SieteYMedio() {
		super("El 7 y medio");
		baraja = new Baraja(1, true);
		nombreJ1 = "Jugador 1";
		nombreJ2 = "Jugador 2";
	}
	
// Metodos
	
	// jugar() - Contiene el menu principal del juego 
	public void jugar(){
		
		Scanner sc = new Scanner(System.in);
		
		
		// Menu modo de juego
		System.out.println("1. Player 1");
		System.out.println("2. Player 1 VS Player 2");
		System.out.println("3. Player 1 VS CPU");
		System.out.println("0. Salir");
		System.out.print("\nOpción: ");
		System.out.println("");
		
		int opcion = sc.nextInt();
		
		// Seleccion modo de juego
		switch (opcion) {
			case 1:
				modoP1();
				break;
			case 2:
				modoP1vsP2();
				break;
			case 3:
				modoP1vsCPU();
				break;
			case 4:
				break;
			case 0:
				break;
				
			default:
				System.out.println("Opción inválida. Por favor elige una opción del menú.\n");
				System.out.println("1. Player 1");
				System.out.println("2. Player 1 VS Player 2");
				System.out.println("3. Player 1 VS CPU");
				System.out.println("0. Salir");
				System.out.print("\nOpción: ");
				opcion = sc.nextInt();
				break;
		}
	}	
	
	// modoP1() - Modo de juego 1 jugador
	public void modoP1() {
		
		Scanner sc = new Scanner(System.in);
		Carta c;
		String opcion;
		String ganaPierde = null;
		
		// Cabezera de juego
		System.out.println("*********** BIENVENID@ ***********");
		System.out.println("           " + this.imprimirCabecera() + "         ");
		System.out.println("******* COMENCEMOS A JUGAR *******");
		System.out.println("\n");
		
		// Mostramos la primera carta jugada
		c = baraja.robar();
		sumarPuntosJugador(c.Valor7ymedio(), puntosJ1, 1);
		mostrarCarta(c, nombreJ1);

		// Mostramos resultado
		System.out.println(nombreJ1 + ": " + puntosJ1 + "\n");

		// Comprobamos puntuacion
		if (puntosJ1 >= 6.0 && puntosJ1 <= 7.5) {
			
			ganaPierde = "gana";
			imprimirFinJuego(nombreJ1, ganaPierde);
		}
		else if (puntosJ1 > 7.5) {

			ganaPierde = "pierde";
			imprimirFinJuego(nombreJ1, ganaPierde);
		}
		else{
			
			// Preguntamos al jugador
			System.out.println(nombreJ1 + ", elige una opcion: ");
			System.out.println("Continuar: (c) o Plantarse (p)?");
			opcion = sc.next();
			opcion = opcion.toLowerCase(); // toLowerCase() para evitar error al ingresar mayusculas
			
			do {
				switch (opcion) {
				
					case "c": {
						
						System.out.println("#--------------#");
						System.out.println("Continúa...");
						c = baraja.robar(); // Robamos carta
						sumarPuntosJugador(c.Valor7ymedio(), 0, 1); // Se suman los puntos de la carta robada al total del jugador
						mostrarCarta(c, nombreJ1); // Se muestra la carta previamente robada
						System.out.println(nombreJ1 + ": " + puntosJ1 + "\n"); // Mostramos puntuacion total del jugador
						
						// Comparamos resultado
						if (puntosJ1 >= 6.0 && puntosJ1 <= 7.5) {
			
							ganaPierde = "gana";
							opcion = "p";
							break;
						}
						else if (puntosJ1 > 7.5) {

							ganaPierde = "pierde";
							opcion = "p";
							break;
						}
						else{
							// Preguntamos al jugador
							System.out.println(nombreJ1 + ", elige una opcion: ");
							System.out.println("Continuar: (c) o Plantarse (p)?");
							opcion = sc.next();
							break;
						}
					}
					case "p": {
						
						break;
					}
					
					default:{
						System.out.println("Opción no válida");
						// Preguntamos al jugador
						System.out.println(nombreJ1 + ", elige una opcion: ");
						System.out.println("Continuar: (c) o Plantarse (p)?");
						opcion = sc.next();
						break;
					}
				}
				}while (!opcion.equals("p"));
			
			// Terminamos el juego
			System.out.println("*********** JUEGO TERMINADO ***********\n");
			System.out.println(imprimirPuntuacionP1());
			
			if (puntosJ1 >= 6.0 && puntosJ1 <= 7.5) {
				
				ganaPierde = "gana";
				imprimirFinJuego(nombreJ1, ganaPierde);
			}
			else if (puntosJ1 > 7.5 || puntosJ1 < 6.0) {

				ganaPierde = "pierde";
				imprimirFinJuego(nombreJ1, ganaPierde);
			}
			
			System.out.println("\n*********** JUEGO TERMINADO ***********");
		}
	}
	
	// modoP1vsP2() - Modo de juego 2 jugadores
	public void modoP1vsP2() {
		
		Scanner sc = new Scanner(System.in);
		int jugadores = 2;
		
		// Cabezera de juego
		System.out.println("*********** BIENVENID@S ***********");
		System.out.println("           " + this.imprimirCabecera() + "         ");
		System.out.println("******* COMENCEMOS A JUGAR *******");
		System.out.println("\n");
		
		// Pedimos nombre a los dos jugadores
		System.out.println("Jugador 1, ingresa un nombre de jugador: ");
		nombreJ1 =  sc.nextLine();
		setNombreJ1(nombreJ1);
		System.out.println("Jugador 2, ingresa un nombre de jugador: ");
		nombreJ2 = sc.nextLine();
		setNombreJ2(nombreJ2);
		
		// Empieza el juego
		System.out.println("********* EMPEZAMOS *********");
		System.out.println("\n");
		int p = 2;
		do {
			for (int i = 0; i<jugadores;i++) {
				String nombre = getNombreJ(i+1);
				double puntos = 0;
				
				if (nombre.equals(nombreJ1)) {
					puntos= puntosJ1;
					p--;
				}
				else if (nombre.equals(nombreJ2)){
					puntos= puntosJ2;
					p--;
				}
				
				turno(nombre, puntos, i+1);
			}
				
		}
		while (p ==1);

			
			// Terminamos el juego
			System.out.println("*********** JUEGO TERMINADO ***********\n");
			System.out.println(imprimirPuntuacionP1());
			System.out.println(imprimirPuntuacionP2());
			
			if (puntosJ1 == 7.5 || puntosJ2 == 7.5) {
				if (puntosJ1 == 7.5 && puntosJ2 == 7.5) {
					System.out.println("EMPATE");
				}
				else if ( puntosJ1 == 7.5) {
						imprimirFinJuego(nombreJ1, "gana");
				}
				else if (puntosJ2 == 7.5){
						imprimirFinJuego(nombreJ2, "gana");
				}
			}
			else {
				double puntos1 = puntosJ1 - 7.5;
				double puntos2 = puntosJ2 - 7.5;
				
				if (puntos1 > puntos2) {
					
					imprimirFinJuego(nombreJ2, "gana");
				}
				else if (puntos1==puntos2) {

					System.out.println("EMPATE DE PERDEDORES");
				}
				else {
					imprimirFinJuego(nombreJ1, "gana");
				}
				
			}
		
			System.out.println("\n*********** JUEGO TERMINADO ***********");	
	}
	
	public void turno(String nombre, double puntos, int num) {

		Scanner sc = new Scanner(System.in);
		Carta c;
		String nombreJ = getNombreJ(num);
		double puntosJ = puntos;
		int numJ = num;
		boolean continuar = false;
		String opcion;
		
		// Cabezera de juego
		System.out.println("*********** TURNO ***********");
		System.out.println("           " + nombreJ + "         ");
		System.out.println("******************************");
		System.out.println("\n");
		
		// Mostramos la carta jugada
		c = baraja.robar();
		mostrarCarta(c, nombreJ);
		sumarPuntosJugador(c.Valor7ymedio(), puntosJ, numJ);
		
		if (num == 1) {
			puntosJ = puntosJ1;
		}
		else {
			puntosJ = puntosJ2;
		}
		

		// Mostramos resultado
		System.out.println(nombreJ + ": " + puntosJ + "\n");
		
	do {
		
		// Preguntamos al jugador
		System.out.println(nombreJ + ", elige una opcion: ");
		System.out.println("Continuar: (c) o Plantarse (p)?");
		opcion = sc.next();
		
		if (opcion.equalsIgnoreCase("c")){
			continuar = true;
			// Mostramos la carta jugada
			c = baraja.robar();
			mostrarCarta(c, nombreJ);
			sumarPuntosJugador(c.Valor7ymedio(), 0, numJ);
			if (num == 1) {
				puntosJ = puntosJ1;
			}
			else {
				puntosJ = puntosJ2;
			}
			

			// Mostramos resultado
			System.out.println(nombreJ + ": " + puntosJ + "\n");
		}
		else if (opcion.equalsIgnoreCase("p")){
			continuar = false;
		}
		
	}while (continuar) ;

	}
	
	public void modoP1vsCPU() {
		
		Scanner sc = new Scanner(System.in);
		Carta c;
		String opcion;
		String ganaPierde = null;
		
		// Cabezera de juego
		System.out.println("*********** BIENVENID@ ***********");
		System.out.println("           " + this.imprimirCabecera() + "         ");
		System.out.println("******* COMENCEMOS A JUGAR *******");
		System.out.println("\n");
		
		// Pedimos nombre a los dos jugadores
		System.out.println("Jugador 1, ingresa un nombre de jugador: ");
		nombreJ1 =  sc.nextLine();
		setNombreJ1(nombreJ1);
		nombreJ2 = "CPU";
		setNombreJ2(nombreJ2);
		
		// Empieza el juego
		System.out.println("********* EMPEZAMOS *********");
		System.out.println("\n");
		
		// Mostramos la primera carta jugada
		c = baraja.robar();
		sumarPuntosJugador(c.Valor7ymedio(), puntosJ1, 1);
		mostrarCarta(c, nombreJ1);

		// Mostramos resultado
		System.out.println(nombreJ1 + ": " + puntosJ1 + "\n");
		System.out.println(nombreJ2 + ": " + puntosJ2 + "\n");
		// Comprobamos puntuacion
		if (puntosJ1 == 7.5) {
			
			turnoCPU(nombreJ2, puntosJ2);
		}
		else if (puntosJ1 > 7.5) {

			turnoCPU(nombreJ2, puntosJ2);
		}
		else{
			
			// Preguntamos al jugador
			System.out.println(nombreJ1 + ", elige una opcion: ");
			System.out.println("Continuar: (c) o Plantarse (p)?");
			opcion = sc.next();
			opcion = opcion.toLowerCase(); // toLowerCase() para evitar error al ingresar mayusculas
			
			do {
				switch (opcion) {
				
					case "c": {
						
						System.out.println("#--------------#");
						System.out.println("Continúa...");
						c = baraja.robar(); // Robamos carta
						sumarPuntosJugador(c.Valor7ymedio(), 0, 1); // Se suman los puntos de la carta robada al total del jugador
						mostrarCarta(c, nombreJ1); // Se muestra la carta previamente robada
						System.out.println(nombreJ1 + ": " + puntosJ1 + "\n"); // Mostramos puntuacion total del jugador
						System.out.println(nombreJ2 + ": " + puntosJ2 + "\n");
						
						// Comparamos resultado
						if (puntosJ1 == 7.5) {
			
							//turnoCPU(nombreJ2, puntosJ2);
							opcion= "p";
							break;
						}
						else if (puntosJ1 > 7.5) {

							//turnoCPU(nombreJ2, puntosJ2);
							opcion= "p";
							break;
						}
						else{
							// Preguntamos al jugador
							System.out.println(nombreJ1 + ", elige una opcion: ");
							System.out.println("Continuar: (c) o Plantarse (p)?");
							opcion = sc.next();
							break;
						}
					}
					case "p": {
						
						//turnoCPU(nombreJ2, puntosJ2);
						break;
					}
					
					default:{
						System.out.println("Opción no válida");
						// Preguntamos al jugador
						System.out.println(nombreJ1 + ", elige una opcion: ");
						System.out.println("Continuar: (c) o Plantarse (p)?");
						opcion = sc.next();
						break;
					}
				}
				}while (!opcion.equals("p"));
			
			turnoCPU(nombreJ2, puntosJ2);
			
			// Terminamos el juego
			System.out.println("*********** JUEGO TERMINADO ***********\n");
			System.out.println(imprimirPuntuacionP1());
			System.out.println(imprimirPuntuacionP2());
			
			if (puntosJ1 == 7.5 || puntosJ2 == 7.5) {
				if (puntosJ1 == 7.5 && puntosJ2 == 7.5) {
					System.out.println("EMPATE");
				}
				else if ( puntosJ1 == 7.5) {
						imprimirFinJuego(nombreJ1, "gana");
				}
				else if (puntosJ2 == 7.5){
						imprimirFinJuego(nombreJ2, "gana");
				}
			}
			else {
				double puntos1 = puntosJ1 - 7.5;
				double puntos2 = puntosJ2 - 7.5;
				
				if (puntos1 > puntos2) {
					
					imprimirFinJuego(nombreJ2, "gana");
				}
				else if (puntos1==puntos2) {

					System.out.println("EMPATE DE PERDEDORES");
				}
				else {
					imprimirFinJuego(nombreJ1, "gana");
				}
				
			}
			
			System.out.println("\n*********** JUEGO TERMINADO ***********");
		}	
	}
	
	public void turnoCPU(String nombre, double puntos) {

		Scanner sc = new Scanner(System.in);
		Carta c;
		String nombreJ = "CPU";
		double puntosJ = puntos;

		boolean continuar = false;
		
		// Cabezera de juego
		System.out.println("*********** TURNO ***********");
		System.out.println("           " + nombreJ + "         ");
		System.out.println("******************************");
		System.out.println("\n");
		
		// Mostramos la carta jugada
		c = baraja.robar();
		mostrarCarta(c, nombreJ);
		sumarPuntosJugador(c.Valor7ymedio(), puntosJ, 2);
		puntosJ = puntosJ2;

		// Mostramos resultado
		System.out.println("\n" + nombreJ1 + ": " + puntosJ1);
		System.out.println(nombreJ2 + ": " + puntosJ2 + "\n");
		
	do {

			c = baraja.robar();
			mostrarCarta(c, nombreJ);
			sumarPuntosJugador(c.Valor7ymedio(), 0, 2);
			puntosJ = puntosJ2;

			// Mostramos resultado
			System.out.println("\n" + nombreJ1 + ": " + puntosJ1);
			System.out.println(nombreJ2 + ": " + puntosJ2 + "\n");

		
	}while (!(puntosJ > 7.5 || puntosJ == 7.5)) ;

	}
		
	
	private void mostrarCarta(Carta carta, String jugador) {
		System.out.println(jugador + " => " + carta.NombreCarta()+ ": " + carta.Valor7ymedio() + " puntos. " );
	}
	
}
