package juegos;

import barajas.*;

//Clase abstract Juego que definira los aspectos genericos de los distintos tipos de juego
//No se puede instanciar al ser abstract
public abstract class Juego {
	
	// Atributos
	protected Baraja baraja;
	public String nombreJuego;
	protected String nombreJ1;
	protected String nombreJ2;
	protected double puntosJ1;
	protected double puntosJ2;
	
	// Constructor
	Juego(String nombre){
		nombreJuego = nombre;
		puntosJ1 = 0;
		puntosJ2 = 0;
		
		//imprimirCabecera();
	}
	
	// Método abstracto
	public abstract void jugar();
	
// Métodos
	// getNombreJ - obtiene el nombre del jugador que deseemos
	public String getNombreJ(int num) {
		if (num == 1) {
			return nombreJ1;
		}
		else {
			return nombreJ2;
		}
	}
	
	// getNombreJ1 - obtiene el nombre del jugador 1
	public String getNombreJ1() {
		
		return nombreJ1;
	}
	
	// setNombreJ1 - asigna el nombre del jugador 1
	public void setNombreJ1(String nombreJ1) {
		
		this.nombreJ1 = nombreJ1;
	}
	
	// getNombreJ2 - obtiene el nombre del jugador 2
	public String getNombreJ2() {

		return nombreJ2;
	}
	
	// setNombreJ2 - asigna el nombre del jugador 2
	public void setNombreJ2(String nombreJ2) {
		this.nombreJ2 = nombreJ2;
	}

	// imprimirCabecera() - imprime un pequeño titulo con el nombre del juego
	protected void imprimirCabecera() {
		
		System.out.println("*********** BIENVENID@ ***********");
		System.out.println("           " + nombreJuego + "         ");
		System.out.println("******* COMENCEMOS A JUGAR *******");
		System.out.println("\n");
	}
	
	// imprimirFinJuego() - imprime el nombre del jugador indicando si ha ganado o perdido. 
	protected void imprimirFinJuego(String nombreJ, String ganaPierde) {
		
			System.out.println("El jugador: " + nombreJ + " " + ganaPierde);
		}

	//	imprimirGanador() - imprimir quién ha ganado la partida, esto es, que un jugador tiene más puntos que otro.
	private void imprimirGanador() {
		
		if (puntosJ1>puntosJ2) {
			imprimirFinJuego(nombreJ1, "gana");
			imprimirFinJuego(nombreJ2, "pierde");
		}
		else {
			imprimirFinJuego(nombreJ2, "gana");
			imprimirFinJuego(nombreJ1, "pierde");
		}
	}

	//	imprimirPuntuacion() - imprime los puntos conseguidos por cada jugador
	public String imprimirPuntuacion() {
		
		return "Jugador: " + nombreJ1 + "= " + puntosJ1 + " puntos. \n" + "Jugador: " + nombreJ2 + "= " + puntosJ2 + " puntos.\n" ;
	}
	
	//	imprimirPuntuacionP1() - imprime los puntos del modo 1 jugador
	public String imprimirPuntuacionP1() {
		
		return "Jugador: " + nombreJ1 + "= " + puntosJ1 + " puntos. \n";
	}
	
	// sumarPuntosJugador() - Suma los puntos de cada turno al jugador correspondiente
	public void sumarPuntosJugador(double puntosCarta1, double puntosCarta2, int numJugador) {
		
		double puntosExtra = puntosCarta1 + puntosCarta2;
		
		if (numJugador == 1) {
			puntosJ1 = puntosExtra + puntosJ1;
		}
		else {
			puntosJ2 = puntosExtra + puntosJ2;
		}
	}
}


