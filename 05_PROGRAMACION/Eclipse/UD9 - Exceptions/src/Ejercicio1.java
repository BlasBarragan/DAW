import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Valor introducido: " + peticion());
		
	}
	
	public static int peticion() throws InputMismatchException{
		
		int valor;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero entero: ");
		valor = sc.nextInt();
		if (valor < 0 || valor >9) {
			throw new InputMismatchException("Valor introducido incorrecto");
		}
		return valor;
	}

}
