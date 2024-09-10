/**
 * Práctica 4 DAW Semipresencial
 * Curso 2022-2023
 * 
 * Fecha de propuesta: 13/02/2023
 * 
 * Proyecto compilado en Java 17
 */

package org.practica4.principal;

import org.practica4.juegos.*;

import java.util.Scanner;

/**
 * Clase Principal donde se encuentra el punto de entrada al programa. Simplemente se mostrará un menú
 * para elegir el tipo de juego de cartas al que se quiere jugar.
 */
public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int respuesta = -1;
		
		System.out.println("*****************************************");
		System.out.println("        JUEGOS DE CARTAS DAW SEMI         ");
		System.out.println("*****************************************");
		
		while (respuesta != 0) {
			System.out.println("1. 7 y medio");
			System.out.println("2. Brisca");
			System.out.println("3. Tute\n");
			System.out.println("0. Salir");
			System.out.print("\nOpción: ");

			respuesta = sc.nextInt();

			System.out.println("");
			switch (respuesta) {
			case 1:
				Juego sieteYMedio = new SieteYMedio();
				sieteYMedio.jugar();
				break;
			case 2:
				Juego brisca = new Brisca();
				brisca.jugar();
				break;
			case 3:
				Juego tute = new Tute();
				tute.jugar();
				break;
			case 0:
				break;
			default:
				System.out.println("Opción inválida. Por favor elige una opción del menú.");
			}
		}

		System.out.println("Gracias por jugar con nosotros.");
		sc.close();
	}
}
