package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Enumerado para representar los palos de la baraja
enum Palo {
    OROS,
    COPAS,
    BASTOS,
    ESPADAS
}

// Clase Carta
class Carta {
    private int numero;
    private Palo palo;

    public Carta(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    // Otros métodos según lo especificado en el enunciado
}

// Clase Baraja
class Baraja {
    private List<Carta> listaCartas;

    public Baraja() {
        this.listaCartas = new ArrayList<>();
        // Inicializar la baraja con las 40 cartas de la baraja española
        for (Palo palo : Palo.values()) {
            for (int numero = 1; numero <= 10; numero++) {
                listaCartas.add(new Carta(numero, palo));
            }
        }
    }

    // Otros constructores y métodos según lo especificado en el enunciado
}

// Clase Juego (abstracta)
abstract class Juego {
    protected Baraja baraja;
    protected String nombreJuego;
    protected String nombreJugador1;
    protected String nombreJugador2;
    protected double puntosJugador1;
    protected double puntosJugador2;
    protected int numeroMano;

    public Juego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    // Método abstracto que implementará el algoritmo de juego
    public abstract void jugar();

    // Otros métodos según lo especificado en el enunciado
}

// Clase Principal
public class Principal {
    public static void main(String[] args) {
        // Implementa el menú principal y la lógica para lanzar cada juego
    }
}

