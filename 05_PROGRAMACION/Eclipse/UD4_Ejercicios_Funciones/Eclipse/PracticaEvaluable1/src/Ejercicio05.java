/**
 * Barragán Román, Blas
 * Práctica Evaluable 1
 * Ejercicio 5 parcialmente, hay veces que las ramitas que se las lleva el viento. 
 * El arbolito de la T.I.A
 */
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		// Definimos variables

		String estrella = "*";
		String tronco = "Y";
		String piso = " ";
		String rama = "^";
		int altura_piso = 0;
		int piso_estrella = 0;
		int piso_1 = 0;
		int piso_x = 0;
		int piso_y = 0;
		int piso_tronco = 0;

		// Solicitamos altura deseada

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la altura del árbol: ");
		int altura = sc.nextInt();
		altura_piso = altura;
		piso_estrella = altura;
		piso_1 = altura;
		piso_tronco = altura;
		piso_x = altura - 3;
		piso_y = -1 * piso_x;

		// Ponemos la estrella
		for (int i = 0; i < piso_estrella; i++) {
			System.out.print(piso);
		}
		System.out.println(estrella);
		altura_piso--;
		// ponemos la primera ramita
		for (int i = 0; i < piso_1; i++) {
			System.out.print(piso);
		}
		System.out.println(rama);
		altura_piso--;
		
		// Segun la altura deseada vamos añadiendo pisos, a mas altura sopla mas viento
		if (altura > 4) {
			// Aqui me he hecho un poco de lio, intentando que siempre fuera impar para cuadrar los pisos
			while (altura_piso > 1) {
				if (altura_piso % 2 == 0 && altura_piso != 3) {
					for (int i = 0; i != piso_y - 2; i--) {
						System.out.print(piso);
					}
					for (int n = 0; n < piso_x; n++) {
						System.out.print(rama);
					}
					System.out.println();
					piso_y++;
					piso_x++;
					altura_piso--;
				} else {
					for (int i = 0; i != piso_y - 2; i--) {
						System.out.print(piso);
					}
					for (int n = 0; n + 1 < piso_x; n++) {
						System.out.print(rama);
					}
					System.out.println();
					piso_y++;
					piso_x++;
					altura_piso--;
				}
			}
		} else // La altura minima siempre será 4, por lo que cualquier valor inferior siempre será de 4 pisos
			{
			for (int i = 0; i < 3; i++) {
				System.out.print(piso);
			}
			for (int i = 0; i < 3; i++) {
				System.out.print(rama);
			}
			System.out.println();
		}
		// Cuando llegamos al ultimo piso, ponemos el tronco
		for (int i = 0; i < piso_tronco; i++) {
			System.out.print(piso);
		}
		System.out.print(tronco);
	}
}
