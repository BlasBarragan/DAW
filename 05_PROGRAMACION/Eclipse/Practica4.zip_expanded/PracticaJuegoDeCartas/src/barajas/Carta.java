package barajas;

import Interfaz.Relacionable;

// Clase Carta. Define las comportamientos y valores de las cartas segun el juego seleccionado
public class Carta implements Relacionable {
	
	//Atributos
		private int numero;
		private Palo palo;
		
	// Constructor
	public Carta(int numero, Palo palo) { // Crea la carta pasando palo y numero
		
		this.numero = numero;
		this.palo = palo;
	}
		
	public Carta(int id) { // Representa la carta siendo 1 as de oros y 40 rey de bastos
		
		if (id <= 10) { 
			
			palo = Palo.OROS;
			numero = id-10;
		}
		if (id >10 && id <=20) { 
			
			palo = Palo.COPAS;
			numero = id-20;
		}
		if (id >20 && id <=30) {
			
			palo = Palo.ESPADAS;
			numero = id-30;
		}
		if (id >30 && id <=40) {
			
			palo = Palo.BASTOS;
			numero = id-40;
		}
		
	}
		
		
// Metodos
	// getNumero() - Devuelve el numero de la carta en cuestion (1-10)
	public int getNumero() {
		
		return numero; 
	}
	
	// getPalo() - Devuelve el palo de la carta en cuestion (0-3)
	public Palo getPalo() {
		
		return palo;
	}
	
	// NombreNumero() - Devuelve el numero de la carta en cuestion pero en formato letra/figura
	public String NombreNumero() {
		
		String nombreCarta;
		
		switch (numero) {
			case 1: { nombreCarta = "As"; break;}
			case 2: { nombreCarta = "Dos"; break;}
			case 3: { nombreCarta = "Tres"; break;}
			case 4: { nombreCarta = "Cuatro"; break;}
			case 5: { nombreCarta = "Cinco"; break;}
			case 6: { nombreCarta = "Seis"; break;}
			case 7: { nombreCarta = "Siete"; break;}
			case 8: { nombreCarta = "Sota"; break;}
			case 9: { nombreCarta = "Caballo"; break;}
			case 10: { nombreCarta = "Rey"; break;}
			
			default:
				throw new IllegalArgumentException("Valor erroneo");
		}
		return nombreCarta;
	}
	
	// NombrePalo() - Devuelve el palo de la carta en cuestion pero en formato letra
	public String NombrePalo() {
		String nombrePalo;
		
		switch (palo) {
		
		case OROS: { nombrePalo = "OROS"; break;}
		case COPAS: { nombrePalo = "COPAS"; break;}
		case ESPADAS: { nombrePalo = "ESPADAS"; break;}
		case BASTOS: { nombrePalo = "BASTOS"; break;}
		
		default:
			throw new IllegalArgumentException("Valor erroneo");
		}
		return nombrePalo;
	}
	
	// NombreCarta() - Devuelve el numero y palo de la carta en cuestion en formato letra
	public String getNombreCarta() {
		
		return NombreNumero() + " de " + NombrePalo();
	}
	
	// ValorTute() - Define el valor de las cartas segun la puntuacion del juego TUTE
	public int ValorTute() {
		
		int valorTute; 
		
		switch (numero) {
		
		case 1: { valorTute = 11; break;}
		case 3: { valorTute = 10; break;}
		case 8: { valorTute = 2; break;}
		case 9: { valorTute = 3; break;}
		case 10: { valorTute = 4; break;}
		
		default:
			valorTute = 0;
			break;
		}
		return valorTute;
	}
	
	// ValorMus() - Define el valor de las cartas segun la puntuacion del juego US
	public int ValorMus() {
		
		int valorMus; 
		
		if (numero <= 2 && numero != 0) {
			valorMus = 1;
		}
		else if (numero >=8 || numero == 3) {
			valorMus = 10;
		}
		else {
			valorMus = numero;
		}

		return valorMus;
	}
	
	// Valor7ymedio() - Define el valor de las cartas segun la puntuacion del juego 7 Y MEDIO
	public double Valor7ymedio() {
		
		double valor7ymedio; 
		
		if (numero >=8) {
			valor7ymedio = 0.5;
		}
		else {
			valor7ymedio = numero;
		}
		
		return valor7ymedio;
	}
	
	// equals(): sobreescribir la clase equals() de la clase Object. Dos cartas son iguales si tiene el mismo número y palo
	public boolean equals(int n1, int p1, int n2, int p2) {
		
		boolean iguales;
		if (n1 == n2) {
			if (p1 == p2) {
				iguales = true;
			}else {
				iguales = false;}
		}else { 
			iguales = false;
		}
		
		return iguales;
	}

	@Override
	public boolean esMayorQue(Relacionable r) {
		// TODO Auto-generated method stub
		Carta cartaB = (Carta)r;
		
		return this.numero < cartaB.numero;
	}

	@Override
	public boolean esMenorQue(Relacionable r) {
		// TODO Auto-generated method stub
		Carta cartaB = (Carta)r;
		
		return this.numero > cartaB.numero;
	}

	@Override
	public boolean esIgualQue(Relacionable r) {
		// TODO Auto-generated method stub
		Carta cartaB= (Carta)r;
		
		return this.numero == cartaB.numero;
	}
		
		
}
