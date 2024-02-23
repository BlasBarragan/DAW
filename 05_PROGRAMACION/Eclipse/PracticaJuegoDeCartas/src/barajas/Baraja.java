package barajas;

import java.util.ArrayList;
import java.util.Random;

public class Baraja{

	// Atributos
	ArrayList<Carta> listaCartas ;
	int tipoBaraja;
	
	// Constructores
	public Baraja() {

		this.listaCartas = new ArrayList<Carta>();
	}
	
	public Baraja(int tipoBaraja) {
		this();
		if (tipoBaraja == 1) {
			crearBaraja(1);
		}else {
			crearBaraja(4);
		}
	}
	
	public Baraja (int tipoBaraja, boolean barajar) {
		this(tipoBaraja);
		if (barajar) {
			barajar();
		}
	}
	
	// Metodos
	private void crearBaraja(int cantidad) {
		while (cantidad > 0) {
			for(Palo palo : Palo.values()) {
				for(int i = 1; i <= 10; i++)
					listaCartas.add(new Carta(i, palo));
			}
			cantidad--;
		}
	}
	
	public int numeroCartas() {
		
		return listaCartas.size();
	}
	
	public boolean vacia() {
		
		return listaCartas.isEmpty();
	}
	
	public void barajar() {
		Random ran = new Random();
		
		ArrayList<Carta> barajaAux = new ArrayList<Carta> ();
		
		int restantes = this.numeroCartas();
		
		for (int i=0; i< restantes; i++) {
			int posicion = ran.nextInt(listaCartas.size());
			barajaAux.add(listaCartas.get(posicion));
			listaCartas.remove(posicion);
		}
		
		for(Carta i : barajaAux) {
			listaCartas.add(i);
		}
	}
	
	public Carta robar() {
		
		Carta carta = listaCartas.get(0);
		listaCartas.remove(0);
		return carta;
	}
	
	public void cortar(int posicion) {
		
		for (int i = 0; i < posicion; i++) {
			Carta carta = robar();
			insertarCartaFinal(carta);
		}
	}
	
	public void insertarCartaFinal(int idCarta) {
		Carta carta= new Carta(idCarta);
		
		listaCartas.add(carta);
	}
	public void insertarCartaPrincipio(int idCarta) {
		Carta carta= new Carta(idCarta);
		
		listaCartas.add(0,carta);
	}
	public void insertarCartaFinal(Carta c) {
		
		listaCartas.add(c);
	}
	public void insertarCartaPrincipio(Carta c) {
		
		listaCartas.add(0,c);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

