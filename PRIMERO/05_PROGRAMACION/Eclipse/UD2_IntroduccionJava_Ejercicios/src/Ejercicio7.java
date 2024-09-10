import java.util.Scanner;

/**
 * Blas Barragan Roman
 * 
 * UD2 Introduccion a Java
 * 
 * Ejercicio 6 
 * Escribir un programa que ejecute una instrucción en Java tal que, suponiendo
 * que las variables x, y, z son de tipo double, asigne a z el valor que indica la
 * fórmula: z= 1+(x^2/y) / x^3/(1+y)
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		// Declaramos variables
		double x = 0;
		double y = 0;
		double z = 0;
		// Solicitamos valores a usuario
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un valor para x: ");
		x = sc.nextDouble();
		System.out.println("Dame un valor para y: ");
		y = sc.nextDouble();
		// Realizamos la ecuacion
		z = (1 + (x*x/y)) / ((x*x*x)/(1 + y));
		// Devolvemos resultado
		System.out.println("El valor de z es " + z);
	}

}
