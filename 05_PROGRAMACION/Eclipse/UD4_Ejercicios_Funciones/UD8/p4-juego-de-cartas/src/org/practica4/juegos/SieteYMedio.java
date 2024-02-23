package org.practica4.juegos;

import java.util.Scanner;

import org.practica4.barajas.Baraja;
import org.practica4.barajas.Carta;
import org.practica4.barajas.TipoBaraja;

/**
 * Clase SiesteYMedio que hereda de la clase Juego, implementa el método jugar
 * 
 * Modos de juego a implementar: Player 1, Player1 vs Player2, Player1 vs CPU
 */
public class SieteYMedio extends Juego{

	public SieteYMedio(){
		super("Siete y medio");
		//Crear una baraja barajada
		baraja = new Baraja(TipoBaraja.NORMAL, true);
		nombreJugador1 = "Jugador1";
		nombreJugador2 = "CPU";
	}
	
	public void jugar(){
		Scanner sc = new Scanner(System.in);

		Carta c1;
		Carta c2;

		String respuesta; 

		boolean continuarJugador1 = true;
		boolean continuarCPU = true;		
		boolean compararPuntos = true;

		int opcion = -1;

		while (opcion != 0) {
			System.out.println("1. Player 1");
			System.out.println("2. Player 1 VS Player 2");
			System.out.println("3. Player 1 VS CPU");
			System.out.println("0. Salir");
			System.out.print("\nOpción: ");

			opcion = sc.nextInt();

			System.out.println("");
			switch (opcion) {
				case 1:
					jugarModoPlayer1();
					break;
				case 2:
					jugarModoPlayer1VSPlayer2();
					break;
				case 3:
					jugarModoPlayer1VSCPU();
					break;
				case 4:
					break;
				case 0:
					break;
				default:
					System.out.println("Opción inválida. Por favor elige una opción del menú.");
			}
		}
	}	

	public void jugarModoPlayer1() {
		// Completar basándote en Player1 VS CPU
		System.out.println("Completar alumnado...\n");
	}

	public void jugarModoPlayer1VSPlayer2() {
		// Completar basándote en Player1 VS Player2
		System.out.println("Completar alumnado...\n");
	}

	public void jugarModoPlayer1VSCPU() {
		Scanner sc = new Scanner(System.in);
		
		Carta c1;
		Carta c2;

		String respuesta; 

		boolean continuarJugador1 = true;
		boolean continuarCPU = true;		
		boolean compararPuntos = true;

		//Repetir hasta que los 2 jugadores terminen
		while (continuarJugador1 || continuarCPU){
			//1.- Juega JUGADOR 1
			if (continuarJugador1) {
				c1 = baraja.robar();
				sumarPuntosJugador(c1.getValorSieteyMedio(), 0, 1);
				imprimirCartaJugada(c1, nombreJugador1);				
			}	

			//Impimir puntuación de los 2 jugadores
			imprimirPuntuacion();

			//Comprobar si GANA el jugador 1			
			if (puntosJugador1 == 7.5 && continuarJugador1) {
				//Gana
				imprimirFinJuego( nombreJugador1, "Gana" );
				continuarJugador1 = false;
				compararPuntos = false;
			}
			else 
			{
				//Comprobar si PIERDE el jugador 1
				if (puntosJugador1 > 7.5 && continuarJugador1) {
					//Pierde
					imprimirFinJuego( nombreJugador1, "Pierde" );
					continuarJugador1 = false;
					compararPuntos	  = false;
				}
				else 
				{
					//Si gana y no se pasa...
					if (continuarJugador1) {
						//Continua o se planta el JUGADOR 1 ???
						System.out.printf( "%s: %s", nombreJugador1, "¿Continuar (c) o Plantarse (any key)? " );						
						respuesta = sc.nextLine();
						continuarJugador1 = respuesta.equals("c");
					}					
					//2.- Juega CPU
					if (continuarCPU) {
						c2 = baraja.robar();
						sumarPuntosJugador(c2.getValorSieteyMedio(), 0, 2);
						
						System.out.println("");
						
						imprimirCartaJugada(c2, nombreJugador2);
						
						System.out.println("");
						
						if (puntosJugador2 == 7.5 && continuarCPU) {
							//Gana CPU
							imprimirFinJuego( nombreJugador2, "Gana" );
							continuarCPU   = false;
							compararPuntos = false;
						}
						else 
						{
							if (puntosJugador2 > 7.5 && continuarCPU) {
								//Pierde CPU
								imprimirFinJuego( nombreJugador2, "Pierde" );
								continuarCPU   = false;
								compararPuntos = false;
							}
						}
					}
				}
			}

			//Decisión de la CPU
			if (continuarCPU) {
				if (puntosJugador2 >= 6)
					continuarCPU = false;
			}
		}		

		//Imprimir quien ha ganado
		if (compararPuntos) {
			imprimirGanador();
		}

	}

	private void imprimirCartaJugada(Carta c, String jugador){
		System.out.println(jugador + ": " + c.getNombreCarta() + ": " + c.getValorSieteyMedio() + " " + " puntos");
	}

}