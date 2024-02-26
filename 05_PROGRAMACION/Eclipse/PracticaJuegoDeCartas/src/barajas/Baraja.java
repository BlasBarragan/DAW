package barajas;

import java.util.ArrayList;
import java.util.Random;

public class Baraja{

	// Atributos
	ArrayList<Carta> listaCartas ; // creamos array que almacene las cartas
	int tipoBaraja; // define el tipo de baraja 1-simple 2-doble
	
	// Constructores
	public Baraja() { // construsctor sin atributos. Genera una baraja vacia

		this.listaCartas = new ArrayList<Carta>();
	}
	
	public Baraja(int tipoBaraja) { // constructor con atributo de tipoBaraja que define cuantas barajas contendra el array
		this();
		if (tipoBaraja == 1) {
			crearBaraja(1);
		}else {
			crearBaraja(2);
		}
	}
	
	public Baraja (int tipoBaraja, boolean barajar) { // constructor que llama al constrctor anterior para crear la baraja y ademas baraja las cartas del array
		this(tipoBaraja);
		if (barajar) {
			barajar();
		}
	}
	
// Metodos
	// crearBAraja() - genera tantas barajas como se defina en su atributo
	private void crearBaraja(int cantidad) {
		while (cantidad > 0) {
			for(Palo palo : Palo.values()) { // por cada uno de los Palos(enum) genera 10 cartas 
				for(int i = 1; i <= 10; i++)
					listaCartas.add(new Carta(i, palo)); // añade las cartas al array
			}
			cantidad--;
		}
	}

	// numeroCartas() - devuelve el numero de cartas restante en la baraja
	public int numeroCartas() {
		
		return listaCartas.size();
	}
	
	// vacia() - devuelve true/false a si esta vacia la baraja
	public boolean vacia() {
		
		return listaCartas.isEmpty();
	}
	
	// barajar() - Crea una baraja auxiliar y por medio de un random, baraja el orden de las cartas y las devuelve al array original
	public void barajar() {
		Random ran = new Random();
		
		ArrayList<Carta> barajaAux = new ArrayList<Carta> (); // array auxiliar
		
		int restantes = this.numeroCartas(); // lee el numero de cartas que quedan
		
		for (int i=0; i< restantes; i++) { // por cada posicion restante en el array 
			int posicion = ran.nextInt(listaCartas.size()); // obtiene una posicion aleatoria
			barajaAux.add(listaCartas.get(posicion)); // saca la carta en dicha posicion del array original y la añade al array auxiliar
			listaCartas.remove(posicion); // elimina la carta del array original
		}
		
		for(Carta i : barajaAux) { // por cada una de las cartas en el array auxiliar
			listaCartas.add(i); // devuelve las cartas al array original en su nueva posicion
		}
	}
	
	// robar() - extrae la carta en primera posicion del array
	public Carta robar() {
		
		Carta carta = listaCartas.get(0);
		listaCartas.remove(0);
		return carta;
	}
	
	// getCarta() - extrae la carta en primera posicion del array
		public Carta getCarta(int i) {
			
			Carta carta = listaCartas.get(i);
			listaCartas.remove(i);
			return carta;
		}
	
	// cortar() - corta la baraja. Pasa tantas cartas como nos diga el atributo desde la primera a la ultima posicion
	public void cortar(int posicion) {
		
		for (int i = 0; i < posicion; i++) {
			Carta carta = robar();
			insertarCartaFinal(carta);
		}
	}
	
	// insertarCartaFinal() - inserta una carta segun su idCarta en la ultima posicion del array
	public void insertarCartaFinal(int idCarta) {
		Carta carta= new Carta(idCarta);
		
		listaCartas.add(carta);
	}
	
	// insertarCartaPrincipio() - inserta una carta segun su idCarta en la primera posicion del array
	public void insertarCartaPrincipio(int idCarta) {
		Carta carta= new Carta(idCarta);
		
		listaCartas.add(0,carta);
	}
	
	// insertarCartaFinal() - inserta una carta en la ultima posicion del array
	public void insertarCartaFinal(Carta c) {
		
		listaCartas.add(c);
	}
	
	// insertarCartaPrincipio() - inserta una carta en la primera posicion del array
	public void insertarCartaPrincipio(Carta c) {
		
		listaCartas.add(0,c);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

