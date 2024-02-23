package principal;

import java.util.Scanner;

import juegos.*;

public class Principal {

	public static void main(String[] args) {

		System.out.println("**********************************");
		System.out.println("         JUEGOS DE CARTAS         ");
		System.out.println("**********************************");
		System.out.println("");
		System.out.println("1. El 7 y medio");
		System.out.println("2. La Brisca");
		System.out.println("3. El Tute");
		System.out.println("0. SALIR");
		System.out.println("");
		System.out.println("Elige una opcion: ");
		
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		
		switch (opcion) {
			case 1: {// 7 y medio
				Juego siete = new SieteYMedio();
				System.out.println("**********************************");
				System.out.println("           " + siete.imprimirCabecera() + "         ");
				System.out.println("**********************************");
				siete.jugar();
				break;
			}
			case 2: {// Brisca
				System.out.println("**********************************");
				System.out.println("        " + "" + "         ");
				System.out.println("**********************************");
				break;
			}
			case 3: {// Tute
				System.out.println("**********************************");
				System.out.println("        " + "" + "         ");
				System.out.println("**********************************");
				break;
			}
			case 0: {// Salir
				System.out.println("**********************************");
				System.out.println("         HASTA LA PROXIMA         ");
				System.out.println("**********************************");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
		
		
	}

}
