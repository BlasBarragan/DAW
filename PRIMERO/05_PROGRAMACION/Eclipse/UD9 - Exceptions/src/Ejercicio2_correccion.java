import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2_correccion {
	
	public static void main(String[] args) {
		int a;
		int b;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Introduce un entero: ");
			a = sc.nextInt();
			System.out.println("Introduce un segundo entero: ");
			b = sc.nextInt();
			
			System.out.println("Resultado: " + a/b);
		}
		catch (InputMismatchException e) {
			System.out.println("Valor introducido erroneo");
			e.printStackTrace();
		}
		catch (ArithmeticException e) {
			System.out.println("Division erronea");
			e.printStackTrace();
		}
	}
}
