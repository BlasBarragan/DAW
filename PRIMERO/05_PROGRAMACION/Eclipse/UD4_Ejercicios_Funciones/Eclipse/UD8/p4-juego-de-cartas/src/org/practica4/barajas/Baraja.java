package org.practica4.barajas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Clase Baraja que construye y gestiona una baraja de cartas
 */
public class Baraja {
	ArrayList<Carta> listaCartas;
	TipoBaraja tipo;
	
	public Baraja() {
		this.listaCartas = new ArrayList<Carta>();
	}
	
	public Baraja(TipoBaraja tipo) {
		this();
		this.tipo = tipo;
		
		switch(tipo) {
			case NORMAL:
				crearCantidadBarajas(1);
				break;
			case DOBLE:
				crearCantidadBarajas(2);
				break;
			default:
				System.out.println("Tipo de baraja desconocida");
		}
	}
	
	/* Método auxiliar: Se usa sólo dentro de la clase */
	private void crearCantidadBarajas(int cantidadBarajas) {
		while (cantidadBarajas > 0) {
			for(Palo palo : Palo.values()) {
				for(int i = 1; i <= 10; i++)
					listaCartas.add(new Carta(i, palo));
			}
			cantidadBarajas--;
		}
	}
	
	public Baraja(TipoBaraja tipo, boolean barajar) {
		this(tipo);
		
		if(barajar)
			barajar();
	}
	
	public int getNumeroDeCartas() {
		return listaCartas.size();
	}
	
	public boolean isVacia() {
		return listaCartas.size() == 0;
	}
	
	public boolean esVacia(){

		return listaCartas.isEmpty();
	}

	public void barajar() {
		Random random = new Random();
		
		// Alternativa
		//Collections.shuffle(listaCartas);
		
		// Crear otra baraja de cartas (temporal)
		ArrayList<Carta> otraListaCartas = new ArrayList<Carta>();

		// Obtener las cartas que quedan en la baraja original
		int cartasRestantes = this.getNumeroDeCartas();
			
		while(!esVacia()) {
			// Genererar un numero al azar
			int numeroAleatorio = random.nextInt(cartasRestantes);
	
			// Obtener la carta al azar
			Carta carta = listaCartas.get(numeroAleatorio);
			
			// Añadir la carta en la otra lista de cartas
			otraListaCartas.add(carta);
			
			// Retiramos la carta de la baraja original
			listaCartas.remove(numeroAleatorio);
			
			cartasRestantes--;
		}	
		
		// Copiar la baraja temporal a la original
		for(Carta carta : otraListaCartas)
			this.listaCartas.add(carta);

	}
	
	public void cortar(int posicion) {
		for (int i = 0; i < posicion; i++) {
			Carta c = this.robar();
			this.insertaCartaFinal(c);
		}	
	}
	
	public Carta robar() {
		Carta carta = this.listaCartas.get(0);
		this.listaCartas.remove(0);
		
		return carta;
	}
	
	public void insertaCartaFinal(int idCarta) {
		Carta carta = new Carta(idCarta);
		this.listaCartas.add(carta);
	}
	
	public void insertaCartaFinal(Carta carta) {
		this.listaCartas.add(carta);
	}
	
	public void insertaCartaPrincipio(int idCarta) {
		Carta carta = new Carta(idCarta);
		this.listaCartas.add(0, carta);
	}	
	
	public void insertaCartaPrincipio(Carta carta) {
		this.listaCartas.add(0, carta);
	}	
	
	public void mostrar() {
		System.out.println("\nCartas de la baraja");
		System.out.println("===================");

		for(Carta carta : this.listaCartas)
			System.out.println(carta.getNombreCarta());
	}
}
