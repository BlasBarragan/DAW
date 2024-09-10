package org.practica4.barajas;

import org.practica4.interfaces.Relacionable;

/**
 * Clase Carta que construye y gestiona cartas, estable los valores de las cartas en cada juego
 * e implementa la interfaz Relacionable, ya que cualquier carta puede ser mayor, menor o igual que otra.
 */
public class Carta implements Relacionable {
	private int numero;
	private Palo palo;
	
	public Carta(int numero, Palo palo) {
		this.numero = numero;
		this.palo = palo;
	}
	
	public Carta(int id) {
		this.numero = id % 10 + 1;

		switch(id / 10) {
			case 1:
				this.palo = Palo.OROS;
				break;
			case 2:
				this.palo = Palo.COPAS;
				break;
			case 3:
				this.palo = Palo.ESPADAS;
				break;
			case 4:
				this.palo = Palo.BASTOS;
				break;
		}
	}

	public int getNumero() {
		return numero;
	}

	public Palo getPalo() {
		return palo;
	}
	
	public String getNombreNumero() {
		String nombreNumero = "" ;
		
		switch(this.numero) {
			case 1: 
				nombreNumero = "as";
				break;
			case 2: 
				nombreNumero = "dos";
				break;
			case 3: 
				nombreNumero = "tres";
				break;
			case 4: 
				nombreNumero = "cuatro";
				break;
			case 5: 
				nombreNumero = "cinco";
				break;
			case 6: 
				nombreNumero = "seis";
				break;
			case 7: 
				nombreNumero = "siete";
				break;
			case 8: 
				nombreNumero = "sota";
				break;
			case 9: 
				nombreNumero = "caballo";
				break;
			case 10: 
				nombreNumero = "rey";
				break;
			default:
				nombreNumero = "desconocido";
		}
		
		return nombreNumero;
	}
	
	public String nombrePalo() {
		String nombrePalo = "";
		
		switch(this.palo) {
			case OROS:
				nombrePalo = "oros";
				break;
			case COPAS:
				nombrePalo = "copas";
				break;
			case ESPADAS:
				nombrePalo = "espadas";
				break;
			case BASTOS:
				nombrePalo = "bastos";
				break;
			default:
				nombrePalo = "desconocido";
		}
		
		return nombrePalo;
	}
	
	public String getNombreCarta() {
		String nombreCarta = "";
		
		switch(this.palo) {
			case OROS:
				for(int i = 0; i < 10; i++)
					nombreCarta = getNombreNumero() + " de oros";
				break;
			case COPAS:
				for(int i = 0; i < 10; i++)
					nombreCarta = getNombreNumero() + " de copas";			
				break;
			case ESPADAS:
				for(int i = 0; i < 10; i++)
					nombreCarta = getNombreNumero() + " de espadas";
				break;
			case BASTOS:
				for(int i = 0; i < 10; i++)
					nombreCarta = getNombreNumero() + " de bastos";
				break;
			default:
				nombreCarta = "desconocido";
		}
		
		return nombreCarta;
	}
	
	public int getValorTute() {
		int valor = 0;
		
		if(this.numero == 1)
			valor = 11;
		else if(this.numero == 3)
			valor = 10;
		else if(this.numero == 8)
			valor = 2;
		else if(this.numero == 9)
			valor = 3;
		else if(this.numero == 10)
			valor = 4;
		
		return valor;
	}
	
	public int getValorMus() {
		int valor = 0;
		
		if(this.numero == 1 || this.numero == 2)
			valor = 1;
		else if(this.numero == 3 || this.numero == 8 || 
				this.numero == 9 || this.numero == 10)
			valor = 10;
		else
			valor = this.numero;
		
		return valor;
	}
	
	public double getValorSieteyMedio() {
		double valor = 0;
		
		if(this.numero >= 8 && this.numero <= 10)
			valor = 0.5f;	
		else
			valor = this.numero;
		
		return valor;
	}
	
	public int getValorBrisca(){
		//El valor de las cartas en la Brisca es el mismo que en el Tute
		return getValorTute();
	}

	@Override
	public boolean esMenorQue(Relacionable r) {
		Carta otraCarta = (Carta)r;
		return this.numero < otraCarta.getNumero();
	}

	@Override
	public boolean esIgualQue(Relacionable r) {
		Carta otraCarta = (Carta)r;
		return this.numero == otraCarta.getNumero() && this.palo == otraCarta.getPalo();
	}

	@Override
	public boolean esMayorQue(Relacionable r) {
		Carta otraCarta = (Carta)r;
		return this.numero > otraCarta.getNumero();
	}
}  
