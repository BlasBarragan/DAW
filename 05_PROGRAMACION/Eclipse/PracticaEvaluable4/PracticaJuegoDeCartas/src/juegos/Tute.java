package juegos;

import barajas.Baraja;
import principal.Principal;

public class Tute extends Juego {
	
	// Constructor
	public Tute() {
		super("El Tute");
		baraja = new Baraja(); // Creamos baraja
		nombreJ1 = "Jugador 1";
		nombreJ2 = "Jugador 2";
	}
	// Metodos
	
	// jugar() - heredado de Juego. Contiene el menu principal del juego
	public void jugar(){
		System.out.println("Proximamente...\n");
		Principal.main(null);
	}
}
