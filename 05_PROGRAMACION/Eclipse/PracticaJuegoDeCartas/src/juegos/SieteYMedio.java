package juegos;

import java.util.Scanner;
import barajas.Baraja;
import barajas.Carta;

public class SieteYMedio extends Juego {

	public SieteYMedio() {
		super("El 7 y medio");
		baraja = new Baraja(1, true);
		nombreJ1 = "Jugador 1";
		nombreJ2 = "Jugador 2";
	}

	public void jugar(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Player 1");
		System.out.println("2. Player 1 VS Player 2");
		System.out.println("3. Player 1 VS CPU");
		System.out.println("0. Salir");
		System.out.print("\nOpción: ");

		int opcion = sc.nextInt();

		System.out.println("");
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
	
	public void modoP1() {
		Scanner sc = new Scanner(System.in);
		Carta c;
		String opcion;
		String ganaPierde = null;
		//barajas.Carta c1 = baraja.robar();
		//String respuesta; 
		//boolean continuar = true;
		
		// imprimir cabecera juego ( empieza)
		// sacar una carta y mostrar ( player 1: carta => puntos.
		// si hay 2 jugadores, comparar puntuaciones ( p1 x puntos, p2 x puntos) 
		// preguntar si seguir jugando ( plantar, puntos =6 || 7.5 o mayor que 7.5) 
		
		System.out.println("*********** BIENVENID@ ***********");
		System.out.println("           " + this.imprimirCabecera() + "         ");
		System.out.println("******* COMENCEMOS A JUGAR *******");
		System.out.println("\n");
		//SieteYMedio juego1 = new SieteYMedio();
		//System.out.println(juego1.nombreJ1 );
		
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
			opcion = opcion.toLowerCase();
			
			do {

				switch (opcion) {
				
					case "c": {
						
						System.out.println("#--------------#");
						System.out.println("Continúa...");
						c = baraja.robar();
						sumarPuntosJugador(c.Valor7ymedio(), 0, 1);
						mostrarCarta(c, nombreJ1);
						System.out.println(nombreJ1 + ": " + puntosJ1 + "\n");
						// Comparamos resultado
						if (puntosJ1 >= 6.0 && puntosJ1 <= 7.5) {
			
							ganaPierde = "gana";
							//imprimirFinJuego(nombreJ1, ganaPierde);
							opcion = "p";
							break;
						}
						else if (puntosJ1 > 7.5) {

							ganaPierde = "pierde";
							//imprimirFinJuego(nombreJ1, ganaPierde);
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
	
	public void modoP1vsP2() {
		
	}
	
	public void modoP1vsCPU() {
		
	}
	
	private void mostrarCarta(Carta carta, String jugador) {
		System.out.println(jugador + " => " + carta.NombreCarta()+ ": " + carta.Valor7ymedio() + " puntos. " );
	}
	
}
