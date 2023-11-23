import java.util.Scanner;

/**
 * Blas Barragan Roman
 * 
 * UD2 Introduccion a Java
 * 
 * Ejercicio 5
 * Realiza un conversor de euros a dólares.
 * La cantidad de euros que se quiere convertir a dólares debe ser introducida
 * por teclado.
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		// Definicion variables
		float euros = 0;
		float dolares = 0;
		final float valor_conversion = 1.088f;
		// Solicitud a usuario
		Scanner sc = new Scanner(System.in);
		System.out.println("Conversor de euros a dolares");
		System.out.println("Euros: ");
		euros = sc.nextInt();
		// Calculo cambio EUR-USD
		dolares = euros*valor_conversion;
		System.out.println(euros + "€ Euros, son al cambio " + dolares + "$ USD");
	}

}
