/**
 * Barragán Román, Blas
 * Práctica Evaluable 1
 * Ejercicio 04 Totalmente
 * Numero secretísimo del Super
 */
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		int numero_introducido = 0;
		int numero_secreto = 0;
		int clave_desbloqueo = 0;
		int digito = 0;
		int posicion = 1;

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		numero_introducido = sc.nextInt();
		numero_secreto = numero_introducido;

		while (numero_introducido > 0) {
			digito = numero_introducido % 10; // Al solicitar el resto, nos devuelve la misma cifra cuando lo usamos del
												// 0 al 9.

			if (digito % 2 == 0) { // Comprobamos si es PAR y sumamos 1 o si es IMPAR y restamos 1
				digito = digito + 1;
			} else {
				digito = digito - 1;
			}
			// Añadimos a la clave el dígito calculado en la posición correspondiente
			clave_desbloqueo = clave_desbloqueo + digito * posicion; 
			 // Aumentamos la posición para el dígito siguiente 															
			posicion *= 10;
			// Suprimimos la ultima cifra del numero introducido
			numero_introducido /= 10;			
		}

		if ( digito==0 ) {
			System.out.println("La clave generada para el número " + numero_secreto + " es 0" + clave_desbloqueo);
		}else {
			System.out.println("La clave generada para el número " + numero_secreto + " es " + clave_desbloqueo);
		}	
		sc.close();
	}
}


