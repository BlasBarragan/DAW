package U03EstructurasDeControl;

import java.util.Scanner;

public class Ejercicio09 {

	static final String piedra  = "piedra";
	static final String papel   = "papel";
	static final String tijeras = "tijeras";
	static final String lagarto = "lagarto";
	static final String spock   = "spock";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String opJugador1 = "";
		String opJugador2     = "";

		System.out.print("Jugador 1: ");
		opJugador1 = sc.nextLine();		
		
		System.out.print("Jugador 2: ");
		opJugador2 = sc.nextLine();	
		
		System.out.println("");
		if (opJugador1.equals(opJugador2)) {
			System.out.println("Empate!");
		}
		else {

			if ((opJugador1.equals(piedra) && opJugador2.equals(tijeras)) ||
				(opJugador1.equals(papel) && opJugador2.equals(piedra)) ||
				(opJugador1.equals(tijeras) && opJugador2.equals(papel)) || 
				
				(opJugador1.equals(piedra) && opJugador2.equals(lagarto)) ||
				(opJugador1.equals(papel) && opJugador2.equals(spock)) ||
				(opJugador1.equals(tijeras) && opJugador2.equals(lagarto)||
						
				(opJugador1.equals(lagarto) && opJugador2.equals(papel)) ||
				(opJugador1.equals(lagarto) && opJugador2.equals(spock)) ||
				
				(opJugador1.equals(spock) && opJugador2.equals(tijeras)) ||
				(opJugador1.equals(spock) && opJugador2.equals(piedra))) ){

				System.out.println("Jugador 1 gana!");
			}
			else {
				System.out.println("Jugador 2 gana!");
			}
		}
	}

}