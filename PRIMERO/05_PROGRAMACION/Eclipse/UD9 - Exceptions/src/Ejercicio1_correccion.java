import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1_correccion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int entero;
		
		try { 
			System.out.println("Introduce un numero entero: ");
			entero = sc.nextInt();
			
			System.out.println("Valor introducido: " + entero);
		}	
		catch (InputMismatchException e) {
			System.out.println("Valor introducido incorrecto");
			e.printStackTrace();
		}
	}
}
