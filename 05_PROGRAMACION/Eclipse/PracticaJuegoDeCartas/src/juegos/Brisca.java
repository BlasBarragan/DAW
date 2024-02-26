package juegos;

import java.util.ArrayList;
import barajas.Baraja;
import barajas.Carta;
import java.util.Scanner;


// Clase Brisca
public class Brisca extends Juego {
   


    public Brisca() {
        super("Brisca");
        baraja = new Baraja(1, true); // Creamos baraja simple y la barajamos con el true
		nombreJ1 = "Jugador 1";
		nombreJ2 = "Jugador 2";
		manoJ1 = new Baraja();
		manoJ2 = new Baraja();
		monton = new Baraja();
    }

    @Override
    public void jugar() {
        // Implementación del juego de Brisca
        System.out.println("***********************************");
        System.out.println(" " + nombreJuego);
        System.out.println("***********************************");
        // Inicializar el juego
        baraja.barajar();
        repartirCartas();
        // Ciclo de juego
        while (!nombreJ1.isEmpty() && !nombreJ2.isEmpty()) {
            System.out.println("Turno de Jugador 1:");
            jugarTurno(manoJ1, manoJ2);
            if (nombreJ1.isEmpty() || nombreJ2.isEmpty()) break;
            System.out.println("\nTurno de Jugador 2:");
            jugarTurno(manoJ1, manoJ2);
        }
        // Determinar ganador
        determinarGanador();
    }

    private void repartirCartas() {
        for (int i = 0; i < 3; i++) {
            manoJ1.insertarCartaFinal(baraja.robar());
            manoJ2.insertarCartaFinal(baraja.robar());
        }
    }

    private void jugarTurno(ArrayList<Carta> manoActual, ArrayList<Carta> otraMano) {
        Scanner scanner = new Scanner(System.in);
        mostrarCartasEnMano(manoActual);
        System.out.print("Selecciona una carta para jugar (1-" + manoActual.size() + "): ");
        int cartaSeleccionada = scanner.nextInt() - 1;
        Carta cartaJugada = manoActual.get(cartaSeleccionada);
        System.out.println("Has jugado: " + cartaJugada.getNombreCarta());
        monton.insertarCartaFinal(cartaJugada);
        manoActual.remove(cartaJugada);
        System.out.println("Montón: " + monton.numeroCartas() + " carta(s)");
        // Simulación de turno de otro jugador (CPU)
        Carta cartaCPU = seleccionarCartaCPU(otraMano);
        System.out.println("La CPU ha jugado: " + cartaCPU.getNombreCarta());
        monton.insertarCartaFinal(cartaCPU);
        otraMano.remove(cartaCPU);
        System.out.println("Montón: " + monton.numeroCartas() + " carta(s)");
        // Evaluar ganador de la mano
        determinarGanadorMano();
    }

    private void mostrarCartasEnMano(ArrayList<Carta> mano) {
        System.out.println("Cartas en tu mano:");
        for (int i = 0; i < mano.size(); i++) {
            System.out.println((i + 1) + ". " + mano.get(i).getNombreCarta());
        }
    }

    private Carta seleccionarCartaCPU(ArrayList<Carta> manoCPU) {
        return manoCPU.get(0); // Implementación simple: la CPU siempre juega la primera carta de su mano
    }

    private void determinarGanadorMano() {
        // Implementación básica: el jugador con la carta de mayor valor gana la mano
        Carta cartaJugador1 = monton.getCarta(monton.numeroCartas() - 2);
        Carta cartaJugador2 = monton.getCarta(monton.numeroCartas() - 1);
        System.out.println("Cartas en el montón:");
        System.out.println("Jugador 1: " + cartaJugador1.getNombreCarta());
        System.out.println("Jugador 2: " + cartaJugador2.getNombreCarta());
        if (cartaJugador1.getNumero() > cartaJugador2.getNumero()) {
            System.out.println("Jugador 1 gana la mano.");
            manoJ1.remove(monton);
        } else if (cartaJugador1.getNumero() < cartaJugador2.getNumero()) {
            System.out.println("Jugador 2 gana la mano.");
            manoJ2.addAll(monton);
        } else {
            System.out.println("Empate, las cartas vuelven al montón.");
        }
        monton.clear();
    }

    private void determinarGanador() {
        if (nombreJ1.isEmpty() && nombreJ2.isEmpty()) {
            System.out.println("Empate.");
        } else if (nombreJ1.isEmpty()) {
            System.out.println("Jugador 2 gana el juego.");
        } else {
            System.out.println("Jugador 1 gana el juego.");
        }
    }
}
