package juegos;

import barajas.Baraja;
import principal.Principal;

public class Brisca extends Juego {

	// Constructor
		public Brisca() {
			super("La Brisca");
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
