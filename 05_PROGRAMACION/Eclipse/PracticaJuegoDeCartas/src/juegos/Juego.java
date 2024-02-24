package juegos;

import barajas.*;

public abstract class Juego {
	
	protected Baraja baraja;
	private String nombreJuego;
	protected String nombreJ1;
	protected String nombreJ2;
	protected double puntosJ1;
	protected double puntosJ2;
	
	// Constructor
	Juego(String nombre){
		nombreJuego = nombre;
		puntosJ1 = 0;
		puntosJ2 = 0;
		
		imprimirCabecera();
	}
	
	// Metodos
	public abstract void jugar();
	
	public String getNombreJ(int num) {
		if (num == 1) {
			return nombreJ1;
		}
		else {
			return nombreJ2;
		}
	}
	
	public String getNombreJ1() {
		return nombreJ1;
	}

	public void setNombreJ1(String nombreJ1) {
		this.nombreJ1 = nombreJ1;
	}

	public String getNombreJ2() {
		return nombreJ2;
	}

	public void setNombreJ2(String nombreJ2) {
		this.nombreJ2 = nombreJ2;
	}

	public String imprimirCabecera() {
		
		return nombreJuego;
	}
	
	protected void imprimirFinJuego(String nombreJ, String ganaPierde) {
		
			System.out.println("El jugador: " + nombreJ + " " + ganaPierde);
		}

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

	public String imprimirPuntuacion() {
		
		return "Jugador: " + nombreJ1 + " " + puntosJ1 + " puntos. \n" + "Jugador: " + nombreJ2 + " " + puntosJ2 + " puntos." ;
	}
	
	public String imprimirPuntuacionP1() {
		
		return "Jugador: " + nombreJ1 + " " + puntosJ1 + " puntos. \n";
	}
	
	public String imprimirPuntuacionP2() {
		
		return "Jugador: " + nombreJ2 + " " + puntosJ2 + " puntos. \n";
	}
	
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


