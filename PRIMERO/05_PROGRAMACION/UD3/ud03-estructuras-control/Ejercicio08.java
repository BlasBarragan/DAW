package U03EstructurasDeControl;

import java.util.Scanner;

public class Ejercicio08 {

	static final String piedra  = "piedra";
	static final String papel   = "papel";
	static final String tijeras = "tijeras";

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
				(opJugador1.equals(tijeras) && opJugador2.equals(papel)) ){

				System.out.println("Jugador 1 gana!");
			}
			else {
				System.out.println("Jugador 2 gana!");
			}
		}
	}

}