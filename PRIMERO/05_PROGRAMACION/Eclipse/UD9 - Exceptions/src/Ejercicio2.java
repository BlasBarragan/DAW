import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		System.out.println("Resultado: " + peticion());
	}
	
	public static int peticion() throws InputMismatchException, ArithmeticException {
		int a;
		int b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un entero: ");
		a = sc.nextInt();
		System.out.println("Introduce un segundo entero: ");
		b = sc.nextInt();
		
		if (a < 0 || a > 9)
			throw new InputMismatchException("Primer valor incorrecto");
		if ( b < 0 || a > 9)
			throw new InputMismatchException("Segundo valor incorrecto");
		if (a/b == 0 )
			throw new ArithmeticException("Division imposible");
		
		return a/b;
	}

}
