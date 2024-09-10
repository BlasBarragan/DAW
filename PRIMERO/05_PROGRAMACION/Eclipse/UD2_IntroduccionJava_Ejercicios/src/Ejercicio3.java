/**
 * Blas Barragan Roman
 * 
 * UD2 introduccion a Java
 * 
 * Ejercicio 3
 * a) Escribe un programa en el que se declaren las variables enteras x e y.
 *	Asígnales los valores 144 y 999 respectivamente. A continuación, muestra
 *	por pantalla el valor de cada variable, la suma, la resta, la división y la
 *	multiplicación.
 *	b) Modifica el programa anterior para pedir los valores de las variables x e y
 *	al usuario.
 */
import java.util.Scanner;
public class Ejercicio3 {

	public static void main(String[] args) {
		/** Apartado a)
		 */
		int x = 144;
		int y = 999;
		
		System.out.println("Valor de x: " + x);
		System.out.println("Valor de y: " + y);
		System.out.println("Suma de x e y: " + (x+y));
		System.out.println("Resta de x e y: " + (x-y));
		System.out.println("Division de x entre y: " + (x/y));
		System.out.println("Division de y entre x: " + (y/x));
		System.out.println("Multiplicación de x por y: " + (x*y));
		
		/** Apartado b)
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Ahora dime tu los numeros");
		System.out.println("Dime un numero para x: ");
		x = sc.nextInt();
		System.out.println("Ahora un numero para y: ");
		y = sc.nextInt();
		
		System.out.println("Valor de x: " + x);
		System.out.println("Valor de y: " + y);
		System.out.println("Suma de x e y: " + (x+y));
		System.out.println("Resta de x e y: " + (x-y));
		System.out.println("Division de x entre y: " + (x/y));
		System.out.println("Division de y entre x: " + (y/x));
		System.out.println("Multiplicación de x por y: " + (x*y));
	}

}
